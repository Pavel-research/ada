package com.onpositive.clauses.impl;

import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class InverseProperty implements IProperty{

	protected final IProperty original;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
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
		InverseProperty other = (InverseProperty) obj;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		return true;
	}
	public InverseProperty(IProperty original) {
		super();
		this.original = original;
	}
	public IProperty getProperty(){
		return original;
	}

	@Override
	public String name() {
		return "!"+original.name();
	}

	@Override
	public IClass domain() {
		return (IClass) original.range();
	}

	@Override
	public IType range() {
		return original.domain();
	}
	
	@Override
	public String toString() {
		return "!"+this.range()+"."+ original.name();
	}

	@Override
	public String id() {
		return "!"+original.id();
	}
	@Override
	public int complexity() {
		return 2*original.complexity();
	}

}
