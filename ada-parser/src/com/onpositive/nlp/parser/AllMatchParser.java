package com.onpositive.nlp.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class AllMatchParser<T> {

	ArrayList<IRule<T>> rules = new ArrayList<>();

	protected HashMap<String, ArrayList<IRule<T>>> layers = new HashMap<>();

	protected ArrayList<String> layersPriorities = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public void add(IRule<? extends T> r) {
		
		this.rules.add((IRule<T>) r);
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
		Collection<List<T>> currentStack = new ArrayList<>();
		currentStack.add(t);
		
		for (String s : layersPriorities) {
			Collection<List<T>> newStack = new ArrayList<>();
			for (List<T>v:currentStack){
				ArrayList<IRule<T>> rules2 = layers.get(s);
				if (rules2!=null){
					Collection<List<T>> proceed = proceed(v, rules2);
					newStack.addAll(proceed);
				}
			}
			currentStack=newStack;
		}
		ArrayList<IRule<T>> rules2 = rules;
		Collection<List<T>> newStack = new ArrayList<>();
		if (currentStack.isEmpty()) {
			currentStack.add(t);
		}
		for (List<T>v:currentStack){			
			if (rules2!=null){
				Collection<List<T>> proceed = proceed(v, rules2);
				newStack.addAll(proceed);
			}
		}
		currentStack=newStack;
		return filterMin(t, currentStack);
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
		for (int i = 0; i < size; i++) {
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

	public static <T> Collection<List<T>> parseRules(List<T> val, List<IRule<T>> rules) {
		LinkedHashSet<List<T>> sm = new LinkedHashSet<List<T>>();
		rules.forEach(r -> {
			sm.addAll(parse(val, r));
		});
		LinkedHashSet<List<T>> res = new LinkedHashSet<>();
		if (sm.size() > 0) {
			sm.forEach(v -> {
				Collection<List<T>> production = parseRules(v, rules);
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
		this.layersPriorities=ln;
	}

	// public static void main(String[] args) {
	// IRule<String>rule=(v,i)->{
	// if (i<v.size()-1&&v.get(i).equals("A")&&v.get(i+1).equals("A")){
	// return new RuleResult<String>("B", 2);
	// }
	// return null;
	// };
	// IRule<String>rule1=(v,i)->{
	// if (i<v.size()-1&&v.get(i).equals("B")&&v.get(i+1).equals("B")){
	// return new RuleResult<String>("C", 2);
	// }
	// return null;
	// };
	// @SuppressWarnings("unchecked")
	// List<IRule<String>> asList = Arrays.asList(new IRule[]{rule,rule1});
	// Collection<List<String>> vs = parseRules(Arrays.asList(new
	// String[]{"A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","A"}),asList);
	// System.out.println(vs.size());
	// }
}
