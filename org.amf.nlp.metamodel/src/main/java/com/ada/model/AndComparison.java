package com.ada.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.onpositive.clauses.IComparison;
import com.onpositive.clauses.IContext;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class AndComparison implements IComparison {

	protected List<Comparison> cm;
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
		AndComparison other = (AndComparison) obj;
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

	public AndComparison(List<Comparison> cm, IType domain) {
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
		return "and(" + cm.toString() + ")";
	}

	@Override
	public IComparison negate() {
		return new OrComparison(cm.stream().map(x -> x.negate()).collect(Collectors.toList()), domain);
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

	@Override
	public boolean match(Object property, IContext ct) {
		for (Comparison c : cm) {
			if (!c.match(property, ct)) {
				return false;
			}
		}
		return true;
	}

}
