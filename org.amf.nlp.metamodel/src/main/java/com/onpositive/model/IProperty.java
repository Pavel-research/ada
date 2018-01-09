package com.onpositive.model;

public interface IProperty extends INamed{
	
	IClass domain();
	
	IType range();
	
	String id();
	
	int complexity();
	
	default boolean hasCompatibleRange(IType t){
		return this.range().isSubtypeOf(t);
	}

	boolean multiValue();
}
