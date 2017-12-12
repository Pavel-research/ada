package com.onpositive.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuiltinType implements IType{

	private final String name;
	private Set<IType> types;
	private boolean ordered;
	private boolean summable;
	
	public Set<IType> superTypes(){
		return types;
	}
	
	public BuiltinType(String name,boolean ordered,IType...superTypes) {
		super();
		this.name = name;
		this.types=new HashSet<IType>(Arrays.asList(superTypes));
		this.ordered=ordered;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public boolean isOrdered() {
		return this.ordered;
	}
	public void setSummable(boolean sum){
		this.summable=sum;
	}

	@Override
	public boolean isSummable() {
		return summable||this.superTypes().stream().anyMatch(x->x.isSummable());
	}

	@Override
	public boolean isSubtypeOf(IType domain) {
		if (domain==this)return true;
		return this.superTypes().stream().anyMatch(x->x.isSubtypeOf(domain));
	}
}