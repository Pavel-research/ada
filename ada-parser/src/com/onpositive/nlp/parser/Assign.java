package com.onpositive.nlp.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Assign implements SyntacticPredicate {

	protected String name;
	protected Class<?>val;
	
	public Assign(String name2, Class<?> cl) {
		this.name=name2;
		this.val=cl;
	}

	@SuppressWarnings("unchecked")
	public int tryParse(List<?>v,int pos,HashMap<String,Object>vars){
		if (pos>=v.size()){
			return  -1;
		}
		Object obj = v.get(pos);
		if (val.isInstance(obj)){
			Object m=vars.get(name);
			if (m!=null){
				if (m instanceof List){
					List<Object>z=(List<Object>) m;
					z.add(obj);
					return 1;
				}
				else{
				ArrayList<Object>val=new ArrayList<Object>();
				val.add(m);
				val.add(obj);
				vars.put(name,val);
				return 1;
				}
			}
			else{
				vars.put(name, obj);
				return 1;
			}
		}
		return -1;
	}

	@Override
	public void gatherLiterals(Consumer<String> c) {
		
	}
}
