package com.ada.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IComparison;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class OrComparison implements IComparison{

	protected List<Comparison>cm;
	protected IType domain;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cm == null) ? 0 : cm.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
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
		OrComparison other = (OrComparison) obj;
		if (cm == null) {
			if (other.cm != null)
				return false;
		} else if (!cm.equals(other.cm))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		return true;
	}

	public OrComparison(List<Comparison> cm, IType domain) {
		super();
		this.cm = cm;
		this.domain = domain;
	}

	@Override
	public IType domain() {
		return domain;
	}
	
	@Override
	public String toString() {
		return "or("+cm.toString()+")";
	}

	@Override
	public IComparison negate() {
		return new AndComparison(cm.stream().map(x->x.negate()).collect(Collectors.toList()), domain);
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
	public List<? extends IParsedEntity> children() {
		return cm;
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

}
