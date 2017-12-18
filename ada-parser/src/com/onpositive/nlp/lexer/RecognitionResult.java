package com.onpositive.nlp.lexer;

import java.util.ArrayList;

public class RecognitionResult {

	public final ArrayList<Object> results;
	public final boolean certain;

	public RecognitionResult(ArrayList<Object> results,boolean certain) {
		super();
		this.results = results;
		this.certain=certain;
	}
}
