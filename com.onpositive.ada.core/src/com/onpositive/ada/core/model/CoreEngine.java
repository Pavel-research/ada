package com.onpositive.ada.core.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ada.metamodel.EntityClass;
import org.ada.metamodel.Property;
import org.ada.metamodel.TypedStore;
import org.ada.metamodel.Universe;
import org.ada.metamodel.VocabularyLoader;
import org.eclipse.emf.common.util.URI;
import org.raml.store.Store;
import org.raml.vocabularies.Vocabulary;
import org.yaml.snakeyaml.Yaml;

import com.ada.model.Comparative;
import com.ada.model.Context;
import com.ada.model.GenericTime;
import com.ada.model.IParsedEntity;
import com.ada.model.Preposition;
import com.ada.model.PropertyValue;
import com.ada.model.SimpleDisambiguator;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.AllInstancesOf;
import com.onpositive.clauses.impl.SingleSelector;
import com.onpositive.clauses.impl.ThemInstances;
import com.onpositive.model.Builtins;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;
import com.onpositive.model.ITypedEntity;
import com.onpositive.model.ITypedStore;
import com.onpositive.nlp.lexer.DatePart;
import com.onpositive.nlp.lexer.EntityRecognizer;
import com.onpositive.nlp.lexer.Lexer;
import com.onpositive.nlp.lexer.OrToken;
import com.onpositive.nlp.parser.AllMatchParser;

import ada.core.rules.loader.ModelLoader;
import ada.core.rules.loader.VocabularyRecognizer;

public class CoreEngine {

	protected ITypedStore store;

	public CoreEngine(String storePath, String vocabularyPath, String rulesPath[], String metaPath) {
		Vocabulary voc = null;
		try {
			voc = new Vocabulary(CoreEngine.class.getResource(vocabularyPath));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		Universe v = new VocabularyLoader().loadFrom(voc);
		TypedStore ts = new TypedStore(Store.getStore(storePath), v, voc.getBase());
		init(ts, rulesPath);
		Meta loadAs = new Yaml().loadAs(CoreEngine.class.getResourceAsStream(metaPath), Meta.class);
		loadAs.getProperties().keySet().forEach(k -> {
			v.classes().forEach(c -> {
				c.allProperties().forEach(p -> {
					if (p.name().equals(k)) {
						initFromMeta(loadAs, k, c, (Property)p);
						
					}
				});
			});
		});
		loadAs.classes.keySet().forEach(k->{
			EntityClass clazz = (EntityClass) v.getClass(k);
			ClassMeta classMeta = loadAs.classes.get(k);
			if (classMeta.getUrlContainedIn()!=null){
				classMeta.getUrlContainedIn().forEach(cn->{
					EntityClass class1 = (EntityClass) v.getClass(cn);
					class1.recordContained(clazz);
				});
			}
		});
		recognizer.innerEnd("them", Builtins.ALLMATCH);

	}

	private void initFromMeta(Meta loadAs, String k, IClass c, Property p) {
		PropertyMeta propertyMeta = loadAs.properties.get(k);
		List<String> sameAs = propertyMeta.getSameAs();
		if (sameAs != null) {
			sameAs.forEach(sa -> {
				recognizer.addEntity(sa, p);
			});
		}
		if (!propertyMeta.isMultiValue()){
			p.setMultiValue(false);
		}
		if (propertyMeta.getGetAs()!=null){
			p.setStoreId(propertyMeta.getGetAs());
		}
		List<String> related = propertyMeta.getRelated();
		if (related != null) {
			related.forEach(r -> {
				Optional<IProperty> relatedProperty = c.property(r);
				if (relatedProperty.isPresent()) {
					 p.recordRelated(relatedProperty.get());
				}
			});
		}
		if (propertyMeta.isRecognizeValues()){
			LinkedHashSet<Object> execute = new LinkedHashSet<>(store.execute(new AllInstancesOf(c).map(p)));
			for (Object m:execute){
				recognizer.innerEnd(m.toString(), new PropertyValue(m,p));
			}			
		}
	}

	public void addSynonims() {

	}

	public CoreEngine(ITypedStore store) {
		super();
		init(store, new String[] { "/basic.rules" });
	}

	@SuppressWarnings("unchecked")
	private void init(ITypedStore store, String rules[]) {
		this.store = store;
		this.recognizer = new VocabularyRecognizer(store.universe());
		Preposition.init(recognizer);
		Comparative.init(recognizer);
		store.allInstances().forEach(i -> {
			String name = i.name();

			if (name != null) {
				this.recognizer.addEntity(name, i);
			}
		});
		this.lexer = new Lexer(recognizer);
		for (String rule : rules) {
			AllMatchParser<?> parser = ModelLoader.load(URI.createURI(CoreEngine.class.getResource(rule).toString()));
			HashSet<String> literals = parser.literals();
			literals.forEach(l -> this.recognizer.addEntity(l, l));
			if (this.parser == null) {
				this.parser = (AllMatchParser<Object>) parser;
			} else {
				this.parser.merge((AllMatchParser<Object>) parser);
			}
		}
	}

	protected EntityRecognizer recognizer;

	protected Lexer lexer;

	protected AllMatchParser<Object> parser;

	Context ct = new Context();

	public Context getContext() {
		return ct;
	}

	public void setContext(Context ct) {
		this.ct = ct;
	}

	public ParsedQuery parse(String text) {
		List<List<Object>> lex = lexer.lex(text);
		SimpleDisambiguator simpleDisambiguator = new SimpleDisambiguator();
		LinkedHashSet<List<Object>> results = new LinkedHashSet<>();
		for (List<Object> seq : lex) {
			Collection<List<Object>> parse = parser.parse(toSelectors(seq));

			results.addAll(simpleDisambiguator.disambiguate(parse));
		}
		LinkedHashSet<List<Object>> gresults = new LinkedHashSet<>();
		int ms = Integer.MAX_VALUE;
		for (List<Object> o : results) {
			if (o.size() < ms) {
				ms = o.size();
			}
		}
		for (List<Object> o : results) {
			if (o.size() == ms) {
				gresults.add(o);
			}
		}
		for (List<Object> o : gresults) {
			if (o.size() == 1) {
				Object object = o.get(0);
				if (object instanceof IParsedEntity) {
					IParsedEntity p = (IParsedEntity) object;
					p.initFromContext(ct.clone());
				}
			}
		}
		if (gresults.size() > 0) {
			if (ms == 1) {
				List<List<Object>> collect = gresults.stream()
						.filter(v -> v.stream().filter(va -> va instanceof ISelector).findAny().isPresent())
						.collect(Collectors.toList());
				if (!collect.isEmpty()) {
					return new ParsedQuery(text,this,new ArrayList<>(simpleDisambiguator.finalDisambig(collect)));
				}
			}
			return new ParsedQuery(text,this,new ArrayList<>(simpleDisambiguator.finalDisambig(gresults)));
		}
		return new ParsedQuery(text,this,new ArrayList<>(simpleDisambiguator.finalDisambig(results)));
	}

	private List<Object> toSelectors(List<Object> seq) {
		ArrayList<Object> res = new ArrayList<>();
		for (Object o : seq) {
			if (o instanceof DatePart) {
				res.add(new GenericTime((DatePart) o));
			} else if (o instanceof ITypedEntity) {
				SingleSelector se = new SingleSelector(o, ((ITypedEntity) o).type());
				res.add(se);
			} else if (o instanceof IClass) {
				if (o == Builtins.ALLMATCH) {
					ThemInstances ti = new ThemInstances();
					res.add(ti);
				} else {
					AllInstancesOf ali = new AllInstancesOf((IType) o);
					res.add(ali);
				}
			}
			// else if (o instanceof Number) {
			// SingleSelector e = new SingleSelector(o, Builtins.NUMBER);
			// res.add(e);
			// }
			else if (o instanceof OrToken) {
				OrToken tk = (OrToken) o;
				ITypedEntity en = (ITypedEntity) tk.options.iterator().next();
				SingleSelector e = new SingleSelector(tk.options, en.type());
				e.setLabel(tk.toString());
				res.add(e);
			} else {
				res.add(o);
			}
		}
		return res;
	}

	public static CoreEngine getDebugEngine() throws IOException {
		return new CoreEngine(TypedStore.getDebugInstance());
	}

	public ITypedStore getStore() {
		return store;		
	}
}
