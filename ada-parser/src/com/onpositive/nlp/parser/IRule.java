package com.onpositive.nlp.parser;

import java.util.List;

@FunctionalInterface
public interface IRule<T> {

	RuleResult<T> consume(List<T>elements,int position);

}
