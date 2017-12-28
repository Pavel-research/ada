package com.ada.model.conditions;

import java.util.List;
import java.util.Optional;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.ada.model.IParsedEntity;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public interface IHasDomain extends IParsedEntity{

	IType domain();

	default Optional<IClass>clazz(){
		if (domain() instanceof IClass){
			return Optional.of((IClass)domain());
		}
		return Optional.empty();
	}
	
	@SuppressWarnings("unchecked")
	default List<IProperty>properties(){
		return clazz().map(x->x.allProperties()).orElse(Collections.emptyList());
	}
}
