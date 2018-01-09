package com.onpositive.model;

import java.util.Collection;
import java.util.stream.Stream;

import com.onpositive.clauses.IContext;
import com.onpositive.clauses.ISelector;

public interface ITypedStore extends IContext{

	Collection<ITypedEntity>allInstances();
	
	Stream<ITypedEntity>allInstancesOf(IType t);
	
	IType get(String name);

	Collection<Object>execute(ISelector selector);

	IUniverse universe();
	
	Object property(Object x, IProperty property);
}
