package com.onpositive.clauses.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ada.model.Context;
import com.ada.model.IParsedEntity;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public final class ClauseSelector implements ISelector {

	protected final ISelector parent;
	protected final IType type;
	protected final Multiplicity multiplicity;
	protected final IClause clause;

	private ClauseSelector(ISelector parent, IType type, Multiplicity multiplicity, IClause clause) {
		super();
		this.parent = parent;
		this.type = type;
		this.multiplicity = multiplicity;
		this.clause = clause;
	}
	
	public ClauseSelector cloneWithNewRoot(ISelector newRoot){
		if (this.parent instanceof ClauseSelector){
			return new ClauseSelector(((ClauseSelector) parent).cloneWithNewRoot(newRoot), type, multiplicity, clause);
		}
		else{
			return new ClauseSelector(newRoot, type, multiplicity, clause);
		}
	}
	
	@Override
	public IType originalDomain() {
		return getRoot().parent().domain();
	}

	public static ClauseSelector produce(ISelector parent, IType type, Multiplicity m, IClause c) {
		if (c instanceof PropertyFilter&&parent.multiplicity()==Multiplicity.SINGLE){
			return null;
		}
		return new ClauseSelector(parent, type, m, c);
	}
	

	@Override
	public String toString() {
		return parent.toString() + "=>" + clause.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clause == null) ? 0 : clause.hashCode());
		result = prime * result + ((multiplicity == null) ? 0 : multiplicity.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClauseSelector other = (ClauseSelector) obj;
		if (clause == null) {
			if (other.clause != null)
				return false;
		} else if (!clause.equals(other.clause))
			return false;
		if (multiplicity != other.multiplicity)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public IClause clause() {
		return clause;
	}

	public ISelector parent() {
		return parent;
	}

	@Override
	public IType domain() {
		return type;
	}

	@Override
	public Multiplicity multiplicity() {
		if (this.multiplicity != null) {
			return this.multiplicity;
		}
		return parent.multiplicity();
	}

	public ClauseSelector getRoot() {
		ClauseSelector p = this;
		while (p.parent instanceof ClauseSelector) {
			p=(ClauseSelector) p.parent;
		}
		return p;
	}

	@Override
	public List<? extends IParsedEntity> children() {
		ArrayList<IParsedEntity> chld = new ArrayList<>();
		ISelector p = parent;
		while (true) {
			if (p instanceof ClauseSelector) {
				ClauseSelector cl = (ClauseSelector) p;
				chld.add(cl.clause());
				p = cl.parent();
			} else {
				chld.add(p);
				break;
			}
		}
		chld.add(this.clause);
		return chld;
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	@Override
	public void initFromContext(Context ct) {
		if (ct.getThem() == null) {
			ct.setThem(getRoot());
		}
		ISelector.super.initFromContext(ct);
	}

	Collection<Object>vl=null;
	@Override
	public Stream<Object> values(IContext ct) {
		if (vl!=null){
			return vl.stream();
		}
		Stream<Object> perform = this.clause.perform(this.parent.values(ct),ct);
		vl=perform.collect(Collectors.toSet());
		return vl.stream();		
	}

	public IClause getClause() {
		return clause;
	}
}
