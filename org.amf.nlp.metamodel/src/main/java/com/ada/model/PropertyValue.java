package com.ada.model;

import java.util.Collections;
import java.util.List;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.IScalarValue;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class PropertyValue implements IScalarValue{

	protected final Object value;
	protected final IProperty property;
	
	public IProperty getProperty() {
		return property;
	}

	public PropertyValue(Object value, IProperty property) {
		super();
		this.value = value;
		this.property = property;
	}
	
	public Object getValue(){
		return value;
	}

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	@Override
	public IType domain() {
		return property.range();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((property == null) ? 0 : property.hashCode());
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
		PropertyValue other = (PropertyValue) obj;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
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
		return "PV:"+value.toString();
	}
}
