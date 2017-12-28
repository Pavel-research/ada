package com.onpositive.clauses.impl;

import java.util.Collections;
import java.util.List;

import com.ada.model.IParsedEntity;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.model.IProperty;

public class NotClause implements IClause{

	IClause original;
	
	public NotClause(IClause original) {
		super();
		this.original = original;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
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
		NotClause other = (NotClause) obj;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NOT("+original+")";
	}

	@Override
	public ISelector produce(ISelector s) {
		if (original.produce(s)==null){
			return null;
		}
		return ClauseSelector.produce(s,s.domain(),s.multiplicity(),this);
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.singletonList(original);
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	

}
