package com.onpositive.clauses.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.ada.model.IParsedEntity;
import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class SingleSelector implements ISelector {

	private Object value;

	String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		SingleSelector other = (SingleSelector) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (label!=null){
			return label;
		}
		return value.toString();
	}

	private IType type;

	public SingleSelector(Object value, IType tp) {
		super();
		this.value = value;
		this.type = tp;
	}
	@SuppressWarnings("unchecked")
	public Collection<Object> getValue(){
		if (value instanceof Collection<?>){
			return (Collection<Object>) value;
		}
		else{
			return Collections.singleton(value);
		}
		
	}

	@Override
	public IType domain() {
		return type;
	}

	@Override
	public Multiplicity multiplicity() {
		return Multiplicity.SINGLE;
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Stream<Object> values(IContext ct) {
		if (this.value instanceof Collection<?>){
			return ((Collection) this.value).stream();
		}
		return Stream.of(this.value);
	}

}
