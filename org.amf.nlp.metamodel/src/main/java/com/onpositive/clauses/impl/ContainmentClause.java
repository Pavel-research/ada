package com.onpositive.clauses.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.ada.model.Comparative;
import com.ada.model.Comparative.Kind;
import com.ada.model.Comparison;
import com.ada.model.IParsedEntity;
import com.ada.model.Measure;
import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IComparison;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IProperty;

public class ContainmentClause implements IClause{

	protected IComparison contained;
	
	protected boolean in;

	private IProperty property;
	
	public IProperty getProperty() {
		return property;
	}

	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contained == null) ? 0 : contained.hashCode());
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
		ContainmentClause other = (ContainmentClause) obj;
		if (contained == null) {
			if (other.contained != null)
				return false;
		} else if (!contained.equals(other.contained))
			return false;
		return true;
	}

	public ContainmentClause(IHasDomain contained,boolean in,IProperty property) {
		super();
		this.property=property;
		this.in=in;
		if (!(contained instanceof IComparison)){
			this.contained=new Comparison(contained, new Comparative(contained instanceof Measure?Kind.EQUAL:Kind.IN, "in"));
		}
		else{
		this.contained = (IComparison) contained;
		}
	}

	@Override
	public ISelector produce(ISelector s) {
		if (this.contained.isNotSolved()){
			return null;
		}
		return ClauseSelector.produce(s, s.domain(), Multiplicity.MULTIPLE, this);
	}

	@Override
	public String toString() {
		if (this.in){
			return "IN("+contained+")";
		}
		return "WITH("+contained+")";
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.singletonList(contained);
	}

	@Override
	public List<IProperty> usedProperties() {
		if (property==null){
			return Collections.emptyList();
		}
		return Collections.singletonList(property);
	}

	@Override
	public Stream<Object> perform(Stream<Object> selector, IContext ct) {
		return PropertyFilter.propertyFilter(property, this.contained).perform(selector, ct);
	}
}
