package com.onpositive.nlp.lexer;

public class Day extends DatePart{

	public Day(String name,int value, boolean shift, boolean relative) {
		super(name,value, shift, relative);
	}

	

	@Override
	public DatePart shift(int i) {
		return null;
	}
}
