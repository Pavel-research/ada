package com.onpositive.clauses.impl;

import java.util.Collections;
import java.util.List;

import com.ada.model.IParsedEntity;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;
import com.onpositive.nlp.parser.ISplitPoint;

public class AllInstancesOf implements ISelector,ISplitPoint{

	protected IType tp;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tp == null) ? 0 : tp.hashCode());
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
		AllInstancesOf other = (AllInstancesOf) obj;
		if (tp == null) {
			if (other.tp != null)
				return false;
		} else if (!tp.equals(other.tp))
			return false;
		return true;
	}

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
		return "C:"+tp.name();
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	@Override
	public boolean includes() {
		return true;
	}

}
