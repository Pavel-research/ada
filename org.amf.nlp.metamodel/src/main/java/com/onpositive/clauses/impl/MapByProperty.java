package com.onpositive.clauses.impl;

import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.model.IProperty;

public class MapByProperty implements IClause{

	private IProperty property;
	
	public MapByProperty(IProperty property) {
		super();
		this.property = property;
	}
	
	public IProperty property(){
		return this.property;
	}

	@Override
	public ISelector produce(ISelector s) {
		if (!s.domain().isSubtypeOf(property.domain())){
			return null;
		}
		return new ClauseSelector(s, property.range(), s.multiplicity(), this);
	}
	
	@Clause("MAP")
	public static MapByProperty map(IProperty prop){
		return new MapByProperty(prop);		
	}

}
