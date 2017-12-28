package com.ada.model;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.model.IProperty;

public class SimpleRelativeComparison extends Comparison{

	protected final IHasDomain compareTo;
	
	public SimpleRelativeComparison(Comparative compare, IHasDomain source, IHasDomain compareTo) {
		super(source,compare);
		this.compareTo = compareTo;
	}
	
	public Comparison solve(IProperty p){
		ISelector produce = new MapByProperty(p).produce((ISelector) compareTo);
		if (produce!=null){
		return new SimpleRelativeComparison(comparative,comparisonTarget, produce);    	
		}
		return null;
    }

	
	@Override
	public String toString() {
		return "relative("+comparative.toString()+","+comparisonTarget.toString()+","+compareTo.toString();
	}

	public SimpleRelativeComparison negate() {
		SimpleRelativeComparison comparison = new SimpleRelativeComparison(new Comparative(comparative.operation.negate(), "not "+comparative.text),comparisonTarget,compareTo);
		comparison.setNotSolved(notSolved);
		return comparison;
	}	
}
