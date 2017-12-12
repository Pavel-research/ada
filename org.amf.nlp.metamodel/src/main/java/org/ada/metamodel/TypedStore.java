package org.ada.metamodel;

import java.util.ArrayList;
import java.util.Collection;

import org.raml.store.IResolvableEntityType;
import org.raml.store.Store;

import com.onpositive.model.ITypedEntity;
import com.onpositive.model.ITypedStore;

public class TypedStore implements ITypedStore{
 
	protected Store ts;
	protected Universe universe;
	protected ArrayList<ITypedEntity>all;
	
	
	@Override
	public Collection<ITypedEntity> allInstances() {
		if (all==null){
			all=new ArrayList<>();
			ts.entities().forEach(e->{
				IResolvableEntityType type = e.type();
				all.add(new TypedEntity(e,getType(type)));
			});
		}
		return all;
	}


	private EntityClass getType(IResolvableEntityType type) {
		//universe.types.
		return null;		
	}
}
