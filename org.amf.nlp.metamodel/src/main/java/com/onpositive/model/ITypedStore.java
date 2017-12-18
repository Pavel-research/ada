package com.onpositive.model;

import java.util.Collection;

import com.onpositive.clauses.ISelector;

public interface ITypedStore {

	Collection<ITypedEntity>allInstances();
	
	IType get(String name);

	Collection<Object>execute(ISelector selector);

	IUniverse universe();
}
