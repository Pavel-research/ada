package com.onpositive.nlp.parser;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public interface SyntacticPredicate {

	public int tryParse(List<?>v,int pos,HashMap<String,Object>vars);
	
	
	public static SyntacticPredicate text(String...strings ){return new TextMatch(strings);};
	public static SyntacticPredicate assign(String name,Class<?>cl){return new Assign(name,cl);};
	public static SyntacticPredicate group(SyntacticPredicate s,GroupPredicate.Mode m){return new GroupPredicate(s,m);};
	public static SyntacticPredicate optional(SyntacticPredicate s){return new GroupPredicate(s,GroupPredicate.Mode.OPTIONAL);};
	public static SyntacticPredicate oneOrMore(SyntacticPredicate s){return new GroupPredicate(s,GroupPredicate.Mode.ONE_OR_MORE);};
	public static SyntacticPredicate anyNumberOf(SyntacticPredicate s){return new GroupPredicate(s,GroupPredicate.Mode.ANY);};
	
	
	default SyntacticPredicate then(SyntacticPredicate t){
		return new Seq(this,t);
	}
	
	default SyntacticPredicate then(String... t){
		return then(text(t));
	}
	
	void gatherLiterals(Consumer<String>c);
}