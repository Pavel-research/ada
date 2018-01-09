package org.ada.metamodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

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

	public IClass getClass(String k) {
		Optional<EntityClass> findAny = this.types.values().stream().filter(x->x.name.equals(k)).findAny();
		if (findAny.isPresent()){
			return findAny.get();
		}
		return types.get(k);
	}


}
