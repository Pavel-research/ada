package com.ada.model;

import java.util.Set;
import java.util.stream.Collectors;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.clauses.impl.ClauseSelector;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.model.IProperty;

public class SimpleRelativeComparison extends Comparison {

	protected final IHasDomain compareTo;

	public SimpleRelativeComparison(Comparative compare, IHasDomain source, IHasDomain compareTo) {
		super(source, compare);
		this.compareTo = compareTo;
	}

	public Comparison solve(IProperty p) {
		ISelector produce = new MapByProperty(p).produce((ISelector) compareTo);
		if (produce != null) {
			return new SimpleRelativeComparison(comparative, comparisonTarget, produce);
		}
		return null;
	}

	@Override
	public String toString() {
		return "relative(" + comparative.toString() + "," + comparisonTarget.toString() + "," + compareTo.toString();
	}

	public SimpleRelativeComparison negate() {
		SimpleRelativeComparison comparison = new SimpleRelativeComparison(
				new Comparative(comparative.operation.negate(), "not " + comparative.text), comparisonTarget,
				compareTo);
		comparison.setNotSolved(notSolved);
		return comparison;
	}

	private Set<Object> vl;

	@Override
	public boolean match(Object property, IContext ct) {
		ISelector comparisonTarget2 = (ISelector) this.comparisonTarget;
		
		if (vl == null) {
			if (this.compareTo instanceof ISelector){
				 vl=((ISelector) this.compareTo).values(ct).collect(Collectors.toSet());
			}
			else vl = ClauseSelector
					.produce(comparisonTarget2, compareTo.domain(), Multiplicity.MULTIPLE, (IClause) this.compareTo)
					.values(ct).collect(Collectors.toSet());
		}
		return comparative.operation.op(property, vl);

	}
}
