package com.ada.model;

import java.util.Collections;
import java.util.List;

import com.onpositive.clauses.IComparison;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class PropertyComparison implements IComparison{

	protected final Comparative cmp;

	protected final IProperty prop;
	
	public PropertyComparison(Comparative cmp, IProperty prop) {
		super();
		this.cmp = cmp;
		this.prop = prop;
	}

	@Override
	public IType domain() {
		return prop.domain();
	}

	@Override
	public IComparison negate() {
		return new PropertyComparison(new Comparative(cmp.getOperation().negate(), "not "+cmp.text),prop);
	}

	@Override
	public boolean isNotSolved() {
		return false;
	}

	@Override
	public IComparison solve(IProperty prop) {
		return null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmp == null) ? 0 : cmp.hashCode());
		result = prime * result + ((prop == null) ? 0 : prop.hashCode());
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
		PropertyComparison other = (PropertyComparison) obj;
		if (cmp == null) {
			if (other.cmp != null)
				return false;
		} else if (!cmp.equals(other.cmp))
			return false;
		if (prop == null) {
			if (other.prop != null)
				return false;
		} else if (!prop.equals(other.prop))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "PC("+cmp.toString()+","+prop.toString()+")";
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}
}
