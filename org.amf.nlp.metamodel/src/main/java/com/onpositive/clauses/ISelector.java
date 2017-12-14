package com.onpositive.clauses;

import java.util.Arrays;
import java.util.LinkedHashSet;

import com.onpositive.clauses.impl.AndSelector;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.clauses.impl.OrSelector;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public interface ISelector {
	
	IType domain(); 
	
	Multiplicity multiplicity();
	
	default ISelector map(IProperty pr){
		return MapByProperty.map(pr).produce(this);
	}


	default ISelector or(ISelector pr){
		return new OrSelector(new LinkedHashSet<>(Arrays.asList(new ISelector[]{this,pr})));
	}
	default ISelector and(ISelector pr){
		return new AndSelector(new LinkedHashSet<>(Arrays.asList(new ISelector[]{this,pr})));
	}
}