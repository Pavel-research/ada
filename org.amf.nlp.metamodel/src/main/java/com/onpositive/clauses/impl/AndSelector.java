package com.onpositive.clauses.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.onpositive.clauses.ICompositeSelector;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IType;

public class AndSelector implements ICompositeSelector {

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
		AndSelector other = (AndSelector) obj;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "and " + selector + "";
	}

	private Set<ISelector> selector;

	public AndSelector(Set<ISelector> sel) {
		this.selector = sel;
	}

	@Clause("and")
	public static ISelector and(List<ISelector> prop) {
		LinkedHashSet<ISelector> s = new LinkedHashSet<>(prop);
		if (s.size() == 1) {
			return s.iterator().next();
		}
		return new AndSelector(s);
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

	@Override
	public Set<ISelector> members() {
		return selector;
	}
}
