package com.ada.model;

import java.util.List;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.onpositive.clauses.IScalarValue;
import com.onpositive.clauses.ISelector;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

//repositories with 5 issues
//repositories with more then 5 issues
public final class Measure  implements IScalarValue{

	protected final Number amount;
	
	protected final ISelector selector;

	public Number getAmount() {
		return amount;
	}

	public ISelector getSelector() {
		return selector;
	}

	public Measure(Number amount, ISelector selector) {
		super();
		this.amount = amount;
		this.selector = selector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
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
		Measure other = (Measure) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "D["+amount.toString()+","+selector.toString()+"]";
	}

	@Override
	public IType domain() {
		return selector.domain();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.singletonList(selector);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}
}
