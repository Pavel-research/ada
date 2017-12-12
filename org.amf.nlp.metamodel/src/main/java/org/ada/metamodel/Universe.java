package org.ada.metamodel;

import java.util.Collection;
import java.util.HashMap;


public class Universe extends HasMeta<Universe>{

	public Universe(String id) {
		super(id,"");
	}

	protected HashMap<String,EntityClass>types=new HashMap<String, EntityClass>();

	public Collection<EntityClass>classes(){
		return types.values();
	}
}
