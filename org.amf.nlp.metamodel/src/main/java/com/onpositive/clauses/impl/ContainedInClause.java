package com.onpositive.clauses.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ada.model.IParsedEntity;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class ContainedInClause implements IClause{

	protected ISelector contained;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contained == null) ? 0 : contained.hashCode());
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
		ContainedInClause other = (ContainedInClause) obj;
		if (contained == null) {
			if (other.contained != null)
				return false;
		} else if (!contained.equals(other.contained))
			return false;
		return true;
	}

	public ContainedInClause(ISelector contained) {
		super();
		this.contained = contained;
	}

	@Override
	public ISelector produce(ISelector s0) {
		IType domain = s0.domain();
		if (domain instanceof IClass){
			IClass cl=(IClass) domain;
			List<IProperty> filter =cl.allProperties().stream().filter(v->v.range().isSubtypeOf(contained.domain())).collect(Collectors.toList());
			if (!filter.isEmpty()){
				return ClauseSelector.produce(s0, s0.domain(), Multiplicity.MULTIPLE, this);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "CONTAINED_IN("+contained+")";
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.singletonList(contained);
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}
}
