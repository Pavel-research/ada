package org.ada.metamodel;

import java.util.Collection;
import java.util.HashMap;

import com.onpositive.model.IClass;
import com.onpositive.model.IUniverse;


public class Universe extends HasMeta<Universe> implements IUniverse{

	public Universe(String id) {
		super(id,"");
	}

	protected HashMap<String,EntityClass>types=new HashMap<String, EntityClass>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection<IClass>classes(){
		return (Collection)types.values();
	}


}
