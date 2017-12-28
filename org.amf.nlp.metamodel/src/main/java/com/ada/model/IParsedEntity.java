package com.ada.model;

import java.util.List;

import com.onpositive.model.IProperty;

public interface IParsedEntity {

	List<? extends IParsedEntity> children();

	List<IProperty>usedProperties();
	
	default void initFromContext(Context ct){
		children().forEach(c->c.initFromContext(ct.clone()));
	}
}