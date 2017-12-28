package com.onpositive.clauses;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.clauses.impl.AndSelector;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.clauses.impl.OrSelector;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public interface ISelector extends IHasDomain{
	
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
	
	default List<IProperty>properties(){
		IType domain = domain();
		if (domain instanceof IClass){
			return ((IClass) domain).properties();
		}
		return Collections.emptyList();
	}
}