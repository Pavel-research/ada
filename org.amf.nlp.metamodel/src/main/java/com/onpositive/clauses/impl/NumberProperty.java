package com.onpositive.clauses.impl;

import com.onpositive.model.Builtins;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class NumberProperty implements IProperty{

	public final IProperty ps;
	
	public NumberProperty(IProperty ps) {
		super();
		this.ps = ps;
	}

	@Override
	public String name() {
		return "count of"+ps.name();
	}

	@Override
	public IClass domain() {
		return ps.domain();
	}

	@Override
	public IType range() {
		return Builtins.INTEGER;
	}

	@Override
	public String id() {
		return "count of"+ps.id();
	}

	@Override
	public String toString() {
		return "countOf("+ps.toString()+")";
	}

	@Override
	public int complexity() {
		return ps.complexity();
	}
}
