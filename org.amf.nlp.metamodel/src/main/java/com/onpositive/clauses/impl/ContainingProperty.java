package com.onpositive.clauses.impl;

import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class ContainingProperty implements IProperty {

	protected final IClass targetClass;
	protected final IClass baseClass;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseClass == null) ? 0 : baseClass.hashCode());
		result = prime * result + ((targetClass == null) ? 0 : targetClass.hashCode());
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
		ContainingProperty other = (ContainingProperty) obj;
		if (baseClass == null) {
			if (other.baseClass != null)
				return false;
		} else if (!baseClass.equals(other.baseClass))
			return false;
		if (targetClass == null) {
			if (other.targetClass != null)
				return false;
		} else if (!targetClass.equals(other.targetClass))
			return false;
		return true;
	}



	public ContainingProperty(IClass targetClass, IClass baseClass) {
		super();
		this.targetClass = targetClass;
		this.baseClass = baseClass;
	}

	
	
	@Override
	public String name() {
		return baseClass.name()+"->"+targetClass.name();
	}

	@Override
	public IClass domain() {
		return baseClass;
	}

	@Override
	public IType range() {
		return targetClass;
	}

	@Override
	public String toString() {
		return name();
	}
	@Override
	public String id() {
		return name();
	}

	@Override
	public int complexity() {
		return 1;
	}

	@Override
	public boolean multiValue() {
		return true;
	}

}
