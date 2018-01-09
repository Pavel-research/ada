package com.ada.model;

import java.util.Collections;
import java.util.List;

import com.onpositive.clauses.IScalarValue;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class NumberInDomain implements IScalarValue{

	IType t;
	public NumberInDomain(IType t, Number nmb) {
		super();
		this.t = t;
		this.nmb = nmb;
	}

	Number nmb;
	
	public Number getNmb() {
		return nmb;
	}
	@Override
	public String toString() {
		return nmb.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nmb == null) ? 0 : nmb.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
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
		NumberInDomain other = (NumberInDomain) obj;
		if (nmb == null) {
			if (other.nmb != null)
				return false;
		} else if (!nmb.equals(other.nmb))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
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
	public IType domain() {
		return t;
	}

}
