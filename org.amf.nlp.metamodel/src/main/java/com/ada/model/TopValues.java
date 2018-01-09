package com.ada.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.ada.model.Comparative.Kind;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.clauses.impl.ClauseSelector;
import com.onpositive.model.Builtins;
import com.onpositive.model.IProperty;

public class TopValues implements IClause{

	protected final IProperty property;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
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
		TopValues other = (TopValues) obj;
		if (direction != other.direction)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

	protected final Comparative.Kind direction;
	
	public TopValues(IProperty property,Comparative.Kind dir) {
		super();
		this.property = property;
		this.direction=dir;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IProperty> usedProperties() {
		return Collections.singletonList(property);
	}

	@Override
	public ISelector produce(ISelector s) {
		return ClauseSelector.produce(s, s.domain(), Multiplicity.SINGLE, this);
	}

	
	Double toDouble(Object vl){
		Number m=(Number) vl;
		return Double.valueOf(m.doubleValue());
	}
	@Override
	public Stream<Object> perform(Stream<Object> selector, IContext ct) {
		
		return selector.sorted(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				int vl=0;
				Object property1 = ct.store().property(o1, property);
				Object property2 = ct.store().property(o2, property);
				if (property1==null){
					property1=0.0;
				}
				if (property2==null){
					property2=0.0;
				}
				if (property1 instanceof Collection && property2 instanceof Collection){
					if (property.range()==Builtins.NUMBER||property.range()==Builtins.INTEGER){
						property1=sum((Collection) property1);
						property2=sum((Collection) property2);
					}
				}
				if (property1 instanceof Number && property2 instanceof Number){
					vl= toDouble(property1).compareTo(toDouble(property2));
				}
				else if (property1 instanceof Comparable&&property2 instanceof Comparable){
					int compareTo = ((Comparable<Object>) property1).compareTo(property2);
					vl= compareTo;
				}
				
				else vl= property1.toString().compareTo(property2.toString());
				return direction==Kind.MIN?vl:-vl;
			}

			private Object sum(Collection property1) {
				double v=0.0;
				for (Object o:property1){
					Number n=(Number) o;
					v=n.doubleValue()+v;
				}
				return v;
			}
		}).limit(1);
	}

	
	@Override
	public String toString() {
		return "PC("+property.toString()+","+direction.toString()+")";
	}
	
}
