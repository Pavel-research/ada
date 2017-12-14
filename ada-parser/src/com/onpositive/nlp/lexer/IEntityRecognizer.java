package com.onpositive.nlp.lexer;

import java.util.ArrayList;
import java.util.List;

public interface IEntityRecognizer {


	ArrayList<Object> tryMatch(List<? extends Object> tokens);

}
