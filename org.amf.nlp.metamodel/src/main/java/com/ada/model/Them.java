package com.ada.model;

import java.util.Collections;
import java.util.List;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class Them implements IHasDomain{

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}

	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

	@Override
	public IType domain() {
		// TODO Auto-generated method stub
		return null;
	}

}
