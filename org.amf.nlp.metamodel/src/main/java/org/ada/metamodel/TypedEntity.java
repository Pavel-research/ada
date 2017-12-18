package org.ada.metamodel;

import org.raml.store.StoreEntity;

import com.onpositive.model.IClass;
import com.onpositive.model.ITypedEntity;

public class TypedEntity implements ITypedEntity{

	protected StoreEntity entity;
	protected EntityClass clazz;
	
	public TypedEntity(StoreEntity entity, EntityClass clazz) {
		super();
		this.entity = entity;
		this.clazz = clazz;
	}
	
	@Override
	public String id() {
		return entity.iri();
	}
	@Override
	public IClass type() {
		return clazz;
	}
	@Override
	public String toString() {
		return "E:"+name();
	}

	@Override
	public String name() {
		Object property = entity.property("name");
		if (property!=null){
			return property.toString();
		}
		return id();
	}

	@Override
	public String kind() {
		return clazz.id;
	}
}
