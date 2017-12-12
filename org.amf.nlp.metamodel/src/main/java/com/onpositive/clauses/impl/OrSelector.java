package com.onpositive.clauses.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IType;

public class OrSelector implements ISelector {

	@Override
	public String toString() {
		return "or " + selector + "";
	}

	private Set<ISelector> selector;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((selector == null) ? 0 : selector.hashCode());
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
		OrSelector other = (OrSelector) obj;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		return true;
	}

	public OrSelector(Set<ISelector> sel) {
		this.selector = sel;
	}

	@Clause("or")
	public static ISelector or(List<ISelector> prop) {
		LinkedHashSet<ISelector> s = new LinkedHashSet<>();
		for (ISelector f : prop) {
			if (f instanceof OrSelector) {
				s.addAll(((OrSelector) f).selector);
			} else {
				s.add(f);
			}
		}
		if (s.size() == 1) {
			return s.iterator().next();
		}
		return new OrSelector(s);
	}

	@Override
	public IType domain() {
		return selector.iterator().next().domain();
	}

	@Override
	public Multiplicity multiplicity() {
		if (selector.stream().allMatch(r -> r.multiplicity() == Multiplicity.MULTIPLE)) {
			return Multiplicity.MULTIPLE;
		}
		if (selector.stream().allMatch(r -> r.multiplicity() == Multiplicity.SINGLE)) {
			return Multiplicity.SINGLE;
		}
		return Multiplicity.UNKNOWN;
	}
}