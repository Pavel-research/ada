package com.onpositive.nlp.parser;

public class RuleResult<T> {

	public final T value;
	public final int len;
	
	public RuleResult(T value, int len) {
		super();
		this.value = value;
		this.len = len;
	}
	
}
