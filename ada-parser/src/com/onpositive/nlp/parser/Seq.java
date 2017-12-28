package com.onpositive.nlp.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Seq implements SyntacticPredicate{

	protected ArrayList<SyntacticPredicate>preds=new ArrayList<>();
	
	public Seq(SyntacticPredicate ...p){
		for (SyntacticPredicate pr:p){
			preds.add(pr);
		}
	}
	public void addPredicate(SyntacticPredicate p){
		preds.add(p);
	}
	
	@Override
	public int tryParse(List<?> v, int pos, HashMap<String, Object> vars) {
		HashMap<String,Object>newMap=GroupPredicate.cloneMap(vars);
		int p1=pos;
		for (SyntacticPredicate p:preds){
			if (pos>=v.size()){
				return -1;
			}
			int i=p.tryParse(v, pos, newMap);
			if (i==-1){
				return i;
			}
			pos=pos+i;
			
		}
		vars.putAll(newMap);
		return pos-p1;
	}

	@Override
	public SyntacticPredicate then(SyntacticPredicate t) {
		this.preds.add(t);
		return this;
	}
	public int size() {
		return preds.size();
	}
	
	public SyntacticPredicate get(int pos){
		return preds.get(0);
	}
	@Override
	public void gatherLiterals(Consumer<String> c) {
		preds.forEach(m->m.gatherLiterals(c));
	}
	
}
