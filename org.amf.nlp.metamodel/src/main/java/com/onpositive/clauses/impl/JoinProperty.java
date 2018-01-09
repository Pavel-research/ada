package com.onpositive.clauses.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class JoinProperty implements IProperty{

	protected List<IProperty>path;

	public List<IProperty> getPath() {
		return path;
	}

	public void setPath(List<IProperty> path) {
		this.path = path;
	}

	public JoinProperty(List<IProperty> path) {
		super();
		this.path = path;
	}

	@Override
	public String name() {
		return path.toString();
	}

	@Override
	public IClass domain() {
		return path.get(0).domain();
	}

	@Override
	public IType range() {
		return path.get(path.size()-1).range();
	}

	@Override
	public String id() {
		return path.stream().map(x->x.id()).collect(Collectors.toList()).toString();
	}

	@Override
	public int complexity() {
		int min=Integer.MAX_VALUE;
		for (IProperty p:path){
			int c=p.complexity();
			if (min>c){
				min=c;
			}
		}
		return min+1;
	}

	@Override
	public String toString() {
		return "join("+path+")";
	}

	@Override
	public boolean multiValue() {
		return path.stream().anyMatch(x->x.multiValue());
	}

}
