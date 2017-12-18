package com.onpositive.nlp.lexer;

import java.util.Collection;

public class OrToken {

	public final Collection<Object>options;
	private String name;

	public OrToken(String name,Collection<Object> options) {
		super();
		this.options = options;
		this.name=name;
	}
	@Override
	public String toString() {
		return "O:"+name;
	}
}
