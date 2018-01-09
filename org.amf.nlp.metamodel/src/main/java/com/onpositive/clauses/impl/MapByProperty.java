package com.onpositive.clauses.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

import com.ada.model.IParsedEntity;
import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class MapByProperty implements IClause,IHasDomain{

	private IProperty property;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MapByProperty other = (MapByProperty) obj;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

	public MapByProperty(IProperty property) {
		super();
		this.property = property;
	}
	
	public IProperty property(){
		return this.property;
	}

	@Override
	public ISelector produce(ISelector s) {
		if (!s.domain().isSubtypeOf(property.domain())){
			if (s.domain().isSubtypeOf(property.range())){
				return new MapByProperty(InverseProperty.createInverseProperty(property)).produce(s);
			}
			return null;
		}
		
		return ClauseSelector.produce(s, property.range(), multiplicity(s.multiplicity(),property), this);
	}
	
	private Multiplicity multiplicity(Multiplicity multiplicity, IProperty property2) {
		if (property2.multiValue()){
			return Multiplicity.MULTIPLE;
		}
		return multiplicity;
	}

	@Clause("MAP")
	public static MapByProperty map(IProperty prop){
		return new MapByProperty(prop);		
	}

	@Override
	public IType domain() {
		return property.range();
	}
	
	@Override
	public String toString() {
		return "map("+property.toString()+")";
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.singletonList(property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Stream<Object> perform(Stream<Object> selector, IContext ct) {
		LinkedHashSet<Object>rs=new LinkedHashSet<>();
		selector.forEach(v->{
			Object property2 = ct.store().property(v,property);
			if (property2 instanceof Collection){
				rs.addAll((Collection)property2);
			}
			else if (property2!=null){
				rs.add(property2);
			}
		});
		return rs.stream();
	}

	
}
