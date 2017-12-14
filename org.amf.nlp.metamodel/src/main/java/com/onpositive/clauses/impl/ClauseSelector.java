package com.onpositive.clauses.impl;

import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IType;

public final class ClauseSelector implements ISelector{

	protected final ISelector parent;
	protected final IType type;
	protected final Multiplicity multiplicity;
	protected final IClause clause;
	
	
	public ClauseSelector(ISelector parent, IType type, Multiplicity multiplicity, IClause clause) {
		super();
		this.parent = parent;
		this.type = type;
		this.multiplicity = multiplicity;
		this.clause = clause;
	}
	
	public IClause clause(){
		return clause;
	}
	public ISelector parent(){
		return parent;
	}
	
	@Override
	public IType domain() {
		return type;
	}

	@Override
	public Multiplicity multiplicity() {
		if (this.multiplicity!=null){
			return this.multiplicity;
		}
		return parent.multiplicity();
	}
}
