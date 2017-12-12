package com.onpositive.model;

public interface IProperty extends INamed{
	
	IClass domain();
	
	IType range();
}
