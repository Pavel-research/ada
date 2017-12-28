package com.onpositive.nlp.parser;

import java.util.List;
import java.util.function.Consumer;

public interface IRule<T> {

	RuleResult<T> consume(List<T>elements,int position);

	void gatherLiterals(Consumer<String>lit);
}
