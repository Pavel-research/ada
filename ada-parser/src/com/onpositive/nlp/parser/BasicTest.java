package com.onpositive.nlp.parser;

import static com.onpositive.nlp.parser.SyntacticPredicate.assign;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class BasicTest {

	public static void main(String[] args) {
		SyntacticMatch<Object> rule = new SyntacticMatch<Object>(
				assign("o1", Number.class).then(SyntacticPredicate.oneOrMore(SyntacticPredicate.text("or").then(assign("o2", Number.class)))), m -> {
					HashSet<Number>ns=new HashSet<>();
					Number n1 = (Number) m.get("o1");
					ns.add(n1);
					Object o=m.get("o2");
					if (o instanceof List){
						ns.addAll((Collection<? extends Number>) o);
					}
					else{
						ns.add((Number) o);
					}
					return ns;
				});
		SyntacticMatch<Number> rule2 = new SyntacticMatch<Number>(
				assign("o1", Number.class).then("*").then(assign("o2", Number.class)), m -> {
					Number n1 = (Number) m.get("o1");
					Number n2 = (Number) m.get("o2");
					return n1.intValue() * n2.intValue();
				});
		SyntacticMatch<Number> rule3 = new SyntacticMatch<Number>(
				assign("o1", Number.class).then("+").then(assign("o2", Number.class)), m -> {
					Number n1 = (Number) m.get("o1");
					Number n2 = (Number) m.get("o2");
					return n1.intValue() + n2.intValue();
				});
		List<Object> lst = Arrays.asList(1, "or", 2, "or", 3, "*", 4, "+", 5);
		AllMatchParser<Object> m = new AllMatchParser<>();
		m.add(rule);
		m.add(rule2);
		m.add(rule3);
		System.out.println(m.parse(lst));
	}
}