package com.onpositive.nlp.parser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class SyntacticMatch<T> implements IRule<T> {

	SyntacticPredicate pred;
	Function<Map<String, Object>, T> consumer;
	private String name;
	private String layer;

	public String getName() {
		return name;
	}

	public String getLayer() {
		return layer;
	}
	
	
	public SyntacticMatch(SyntacticPredicate pred, Function<Map<String, Object>, T> consumer) {
		super();
		this.pred = pred;
		this.consumer = consumer;
	}

	@Override
	public RuleResult<T> consume(List<T> elements, int position) {
		LinkedHashMap<String, Object> vars = new LinkedHashMap<>();
		int re = pred.tryParse(elements, position, vars);
		
		if (re != -1) {
			
			T apply = consumer.apply(vars);
			if (apply != null) {
				return new RuleResult<T>(apply, re);
			}
		}
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLayer(String name) {
		this.layer = name;
	}

	@Override
	public void gatherLiterals(Consumer<String> lit) {
		pred.gatherLiterals(lit);
	}

}
