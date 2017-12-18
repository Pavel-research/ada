package com.onpositive.model;

import com.onpositive.nlp.lexer.IHasKind;

public interface ITypedEntity extends IHasKind{

	String id();
	
	IClass type();

	String name();
}
