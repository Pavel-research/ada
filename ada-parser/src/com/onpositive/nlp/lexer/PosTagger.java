package com.onpositive.nlp.lexer;

import java.util.HashSet;

public class PosTagger {

	static HashSet<String>prepositions=new HashSet<>();
	
	static{
		prepositions.add("by");
		prepositions.add("in");
		prepositions.add("for");
		prepositions.add("at");
		prepositions.add("on");
	}
	
}
