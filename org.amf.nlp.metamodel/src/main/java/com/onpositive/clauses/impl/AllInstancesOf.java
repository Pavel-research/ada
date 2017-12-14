package com.onpositive.clauses.impl;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IType;

public class AllInstancesOf implements ISelector{

	protected IType tp;
	
	public AllInstancesOf(IType tp) {
		super();
		this.tp = tp;
	}

	@Override
	public IType domain() {
		return tp;
	}

	@Override
	public Multiplicity multiplicity() {
		return Multiplicity.MULTIPLE;
	}
	
	@Override
	public String toString() {
		return tp.name();
	}

}
