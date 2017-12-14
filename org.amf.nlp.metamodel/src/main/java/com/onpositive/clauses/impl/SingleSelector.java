package com.onpositive.clauses.impl;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IType;

public class SingleSelector implements ISelector {

	private Object value;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		SingleSelector other = (SingleSelector) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	private IType type;

	public SingleSelector(Object value, IType tp) {
		super();
		this.value = value;
		this.type = tp;
	}
	public Object getValue(){
		return value;
	}

	@Override
	public IType domain() {
		return type;
	}

	@Override
	public Multiplicity multiplicity() {
		return Multiplicity.SINGLE;
	}

}
