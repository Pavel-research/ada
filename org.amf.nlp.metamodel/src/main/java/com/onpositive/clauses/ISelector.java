package com.onpositive.clauses;

import com.onpositive.model.IType;

public interface ISelector {
	
	IType domain(); 
	
	Multiplicity multiplicity();
}