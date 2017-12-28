package com.onpositive.nlp.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class AllMatchParser<T> {

	private static boolean DEBUG = false;

	public static boolean isDEBUG() {
		return DEBUG;
	}

	public static void setDEBUG(boolean dEBUG) {
		DEBUG = dEBUG;
	}

	ArrayList<IRule<T>> rules = new ArrayList<>();

	protected HashMap<String, ArrayList<IRule<T>>> layers = new HashMap<>();

	protected ArrayList<String> layersPriorities = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public void add(IRule<? extends T> r) {

		this.rules.add((IRule<T>) r);
	}

	public void merge(AllMatchParser<T> parser) {
		this.rules.addAll(parser.rules);
		parser.layers.keySet().forEach(k -> {
			ArrayList<IRule<T>> arrayList = layers.get(k);
			if (arrayList == null) {
				arrayList = new ArrayList<>();
				layers.put(k, arrayList);
			}
			arrayList.addAll(parser.layers.get(k));
		});
		parser.layersPriorities.forEach(l -> {
			if (!layersPriorities.contains(l)) {
				layersPriorities.add(l);
			}
		});
	}

	public HashSet<String> literals() {
		HashSet<String> res = new HashSet<>();
		rules.forEach(r -> r.gatherLiterals(m -> res.add(m)));
		layers.values().forEach(r -> r.forEach(rr -> rr.gatherLiterals(m -> res.add(m))));
		return res;
	}

	@SuppressWarnings("unchecked")
	public void addToLayer(String layer, IRule<? extends T> r) {
		ArrayList<IRule<T>> arrayList = layers.get(layer);
		if (arrayList == null) {
			arrayList = new ArrayList<>();
			layers.put(layer, arrayList);
		}
		arrayList.add((IRule<T>) r);
	}

	public Collection<List<T>> parse(List<T> t) {
		Collection<List<T>> newStack;
		Collection<List<T>> currentStack = parseUC(t);

		Collection<List<T>> filterMin = filterMin(t, currentStack);
		newStack = new LinkedHashSet<>();

		for (List<T> v : filterMin) {
			if (v.size() < t.size() && v.size() > 1) {
				newStack.addAll(parse(v));
			} else if (v.size() == 1) {
				newStack.add(v);
			}
		}
		if (newStack.isEmpty()) {
			return filterMin;
		}
		return filterMin(t, newStack);
	}

	private Collection<List<T>> parseUC(List<T> t) {

		Collection<List<T>> currentStack = new ArrayList<>();
		currentStack.add(t);
		for (int i = 1; i < t.size(); i++) {
			if (t.get(i) instanceof ISplitPoint) {
				ISplitPoint mm = (ISplitPoint) t.get(i);
				List<T> subList = t.subList(mm.includes() ? i : i + 1, t.size());
				if (subList.size() > 1) {
					Collection<List<T>> parse = parse(subList);
					if (parse.size() == 1 && ((List) parse.iterator().next()).size() == 1) {
						ArrayList<T> mn = new ArrayList<>();
						mn.addAll(t.subList(0, i));
						if (!mm.includes()) {
							mn.add(t.get(i));
						}
						mn.addAll((List) parse.iterator().next());
						currentStack.add(mn);
					}
				}
			}
		}
		for (String s : layersPriorities) {
			Collection<List<T>> newStack = new ArrayList<>();
			for (List<T> v : currentStack) {
				ArrayList<IRule<T>> rules2 = layers.get(s);
				if (rules2 != null) {
					Collection<List<T>> proceed = proceed(v, rules2);
					newStack.addAll(proceed);
				}
			}
			if (!newStack.isEmpty()) {
				currentStack = newStack;
			}
		}
		ArrayList<IRule<T>> rules2 = rules;
		Collection<List<T>> newStack = new LinkedHashSet<>();
		if (currentStack.isEmpty()) {
			currentStack.add(t);
		}
		for (List<T> v : currentStack) {
			if (rules2 != null) {
				Collection<List<T>> proceed = proceed(v, rules2);
				newStack.addAll(proceed);
			}
		}
		currentStack = newStack;
		return currentStack;
	}

	private Collection<List<T>> proceed(List<T> t, ArrayList<IRule<T>> rules2) {
		Collection<List<T>> parseRules = parseRules(t, rules2);
		return filterMin(t, parseRules);
	}

	private Collection<List<T>> filterMin(List<T> t, Collection<List<T>> parseRules) {
		int minSize = Integer.MAX_VALUE;
		for (List<T> m : parseRules) {
			minSize = Math.min(minSize, m.size());
		}
		int m = minSize;
		Stream<List<T>> filter = parseRules.stream().filter(x -> x.size() == m);
		LinkedHashSet<List<T>> res = new LinkedHashSet<List<T>>();
		filter.forEach(v -> res.add(v));
		if (res.isEmpty()) {
			res.add(t);
		}
		return res;
	}

	public static <T> List<List<T>> parse(List<T> t, IRule<T> rule) {
		int size = t.size();

		ArrayList<List<T>> sm = new ArrayList<List<T>>();
		for (int i = size - 1; i >= 0; i--) {
			RuleResult<T> consume = rule.consume(t, i);
			if (consume != null) {
				ArrayList<T> rs = new ArrayList<T>(t.subList(0, i));
				rs.add(consume.value);
				rs.addAll(t.subList(i + consume.len, t.size()));
				sm.add(rs);

			}
		}

		return sm;
	}

	@SuppressWarnings("unchecked")
	public <T> Collection<List<T>> parseRules(List<T> val, List<IRule<T>> rules) {
		LinkedHashSet<List<T>> sm = new LinkedHashSet<List<T>>();
		rules.forEach(r -> {
			sm.addAll(parse(val, r));
		});
		LinkedHashSet<List<T>> res = new LinkedHashSet<>();
		if (sm.size() > 0) {
			sm.forEach(v -> {
				@SuppressWarnings("rawtypes")
				Collection<List<T>> production = new LinkedHashSet<>((Collection) parseUC((List) v));
				if (production.size() > 0) {
					res.addAll(production);

				} else {
					res.add(v);
				}
			});
		}

		return res;
	}

	public void setLayers(ArrayList<String> ln) {
		this.layersPriorities = ln;
	}

}
