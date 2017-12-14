package com.onpositive.nlp.lexer;

public interface ISpellingCorrector {

	void putWord(String word);

	String correct(String word);

	boolean containsWord(String word);

}
