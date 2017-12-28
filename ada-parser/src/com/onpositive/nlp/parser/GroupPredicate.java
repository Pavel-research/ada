package com.onpositive.nlp.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class GroupPredicate implements SyntacticPredicate{

	
	enum Mode{
		OPTIONAL,ANY,ONE_OR_MORE;
	}
	private SyntacticPredicate pred;
	private Mode mode;
	
	public GroupPredicate(SyntacticPredicate pr,Mode mode) {
		this.mode=mode;
		this.pred=pr;
	}
	
	@Override
	public int tryParse(List<?> v, int pos, HashMap<String, Object> vars) {
		HashMap<String,Object>mm=cloneMap(vars);
		boolean matched=false;
		int pa=pos;
		while (true){
			int p=pred.tryParse(v, pa, mm);
			if (p==-1){
				if (mode==Mode.OPTIONAL||mode==Mode.ANY){
					vars.putAll(mm);
					return pa-pos;
				}
				else 
					if (!matched) return -1;
					else{ 
						vars.putAll(mm);
						return pa-pos;
					}
			}
			else{
				pa=pa+p;
				matched=true;
			}
		}
	}

	static HashMap<String, Object> cloneMap(HashMap<String, Object> vars) {
		HashMap<String,Object> m = new HashMap<>();
		for (String s:vars.keySet()){
			Object v=vars.get(s);
			if (v instanceof ArrayList<?>){
				v=((ArrayList<?>)v).clone();
			}
			m.put(s, v);
		}
		return m;
	}

	@Override
	public void gatherLiterals(Consumer<String> c) {
		pred.gatherLiterals(c);
	}

}
