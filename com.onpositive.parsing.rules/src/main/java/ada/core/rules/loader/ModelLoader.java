package ada.core.rules.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.example.mydsl.MyDslStandaloneSetup;
import org.xtext.example.mydsl.myDsl.ArgList;
import org.xtext.example.mydsl.myDsl.Assign;
import org.xtext.example.mydsl.myDsl.Call;
import org.xtext.example.mydsl.myDsl.Element;
import org.xtext.example.mydsl.myDsl.Group;
import org.xtext.example.mydsl.myDsl.Model;
import org.xtext.example.mydsl.myDsl.Name;
import org.xtext.example.mydsl.myDsl.OrExp;
import org.xtext.example.mydsl.myDsl.PrimaryExpression;
import org.xtext.example.mydsl.myDsl.Rule;
import org.xtext.example.mydsl.myDsl.Seq;
import org.xtext.example.mydsl.myDsl.StringLiteral;
import org.xtext.example.mydsl.myDsl.TransferModel;

import com.google.inject.Injector;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.Clauses;
import com.onpositive.nlp.parser.AllMatchParser;
import com.onpositive.nlp.parser.SyntacticMatch;
import com.onpositive.nlp.parser.SyntacticPredicate;
import com.onpositive.nlp.parser.TextMatch;

public class ModelLoader {

	protected HashMap<String, SyntacticMatch<?>> rules = new HashMap<>();

	protected HashMap<String, Class<?>> tc = new HashMap<>();

	public ModelLoader() {
		tc.put("selector", ISelector.class);
	}
	
	public static AllMatchParser<Object> load(URI path){
		Injector injector = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		Resource resource = resourceSet.getResource(path, true);
		EList<EObject> contents = resource.getContents();
		Model m=(Model) contents.get(0);
		AllMatchParser<Object> load = new ModelLoader().load(m);
		return load;
	}

	AllMatchParser<Object> load(Model model) {
		model.getRules().forEach(r -> {
			rules.put(r.getName(), createRule(r));
		});
		AllMatchParser<Object> m = new AllMatchParser<>();
		rules.values().forEach(r -> {
			if (r.getLayer() != null) {
				m.addToLayer(r.getLayer(), r);
			} else
				m.add(r);
		});
		ArrayList<String> ln = new ArrayList<>();
		model.getLayers().forEach(l -> {
			ln.add(l.getName());
		});
		m.setLayers(ln);
		return m;
	}

	private SyntacticMatch<?> createRule(Rule r) {
		SyntacticPredicate pred = toPredicate(r.getCondition());
		Function<Map<String, Object>, Object> func = toFunction(r.getThenPart());
		SyntacticMatch<Object> syntacticMatch = new SyntacticMatch<>(pred, func);
		syntacticMatch.setName(r.getName());
		if (r.getLayer() != null) {
			syntacticMatch.setLayer(r.getLayer().getName());
		}
		return syntacticMatch;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Function<Map<String, Object>, Object> toFunction(TransferModel thenPart) {
		EList<Call> seq = thenPart.getSeq();
		ArrayList<Function<Map<String, Object>, Object>> ts = new ArrayList<>();

		seq.forEach(c -> {
			ts.add(transformCall(c));
		});
		if (ts.size() == 1) {
			return ts.get(0);
		}
		Function<?, ?> prev = null;
		for (Function<?, ?> f : ts) {
			if (prev == null) {
				prev = f;
			} else {
				prev = prev.andThen((Function) f);
			}
		}
		return (Function<Map<String, Object>, Object>) prev;
	}

	private Function<Map<String, Object>, Object> transformCall(Call c) {
		ArgList args = c.getArgs();
		String name = c.getName().getName();
		ArrayList<Function<Map<String, Object>, Object>> as = new ArrayList<>();
		if (args != null) {
			args.getA().forEach(r -> {
				as.add(toFun(r));
			});
		}
		return m -> {
			Object[] arguments = new Object[as.size()];
			int i = 0;
			for (Function<Map<String, Object>, Object> f : as) {
				Object o = f.apply(m);
				if (o == null) {
					return null;
				}
				arguments[i] = o;
				i++;
			}
			return Clauses.get().create(name, arguments);
		};
	}

	private Function<Map<String, Object>, Object> toFun(PrimaryExpression r) {
		EObject c = r.getC();
		if (c instanceof Name) {
			return m -> m.get(((Name) c).getV());
		} else if (c instanceof StringLiteral) {
			String value = (((StringLiteral) c).getV());
			return m -> value;
		} else if (r instanceof Call) {
			return transformCall((Call) r);
		}
		throw new IllegalStateException();
	}

	private SyntacticPredicate toPredicate(Seq condition) {
		com.onpositive.nlp.parser.Seq sequence = new com.onpositive.nlp.parser.Seq();
		condition.getSeq().forEach(v -> {
			sequence.addPredicate(parseOr(v));
		});
		if (sequence.size() == 1) {
			return sequence.get(0);
		}
		return sequence;
	}

	private SyntacticPredicate parseOr(OrExp v) {
		ArrayList<SyntacticPredicate> options = new ArrayList<>();
		for (Element e : v.getOptions()) {
			EObject val = e.getVal();
			if (val instanceof Assign) {
				String name = ((Assign) val).getName();
				String token = ((Assign) val).getVal().getName();
				Class<?> class1 = tc.get(token);
				if (class1 == null) {
					throw new IllegalStateException();
				}
				options.add(SyntacticPredicate.assign(name, class1));
			} else if (val instanceof StringLiteral) {
				String value = (((StringLiteral) val).getV());
				options.add(SyntacticPredicate.text(value));
			} else if (val instanceof Group) {
				SyntacticPredicate pr = toPredicate(((Group) val).getSeq());
				String op = ((Group) val).getOp();
				if (op.equals("*")) {
					options.add(SyntacticPredicate.anyNumberOf(pr));
				} else if (op.equals("+")) {
					options.add(SyntacticPredicate.oneOrMore(pr));
				} else if (op.equals("?")) {
					options.add(SyntacticPredicate.optional(pr));
				} else {
					throw new IllegalStateException();
				}
			} else
				throw new IllegalStateException();
		}
		if (options.size() == 1) {
			return options.get(0);
		} else {
			if (options.stream().filter(x -> x instanceof TextMatch).count() != options.size()) {
				throw new IllegalStateException();
			} else {
				HashSet<String> opts = new HashSet<>();
				for (SyntacticPredicate o : options) {
					TextMatch t = (TextMatch) o;
					opts.addAll(t.get());
				}
				return new TextMatch(opts.toArray(new String[opts.size()]));
			}
		}
	}
}
