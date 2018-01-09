package org.ada.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class EntityClass extends HasMeta<EntityClass> implements IClass{
	
	protected ArrayList<IProperty>properties=new ArrayList<IProperty>();
	protected ArrayList<IProperty>returning=new ArrayList<>();
	
	protected LinkedHashSet<EntityClass>contained=new LinkedHashSet<>();
	protected LinkedHashSet<EntityClass>containedIn=new LinkedHashSet<>();
	
	public EntityClass(String id,String name) {
		super(id,name);
	}

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public String toString() {
		return "C:"+name;
	}
	
	@Override
	public boolean isSummable() {
		return false;
	}

	@Override
	public boolean isSubtypeOf(IType domain) {
		if (this.equals(domain)){
			return true;
		}
		for (EntityClass c:this.parents){
			if (c.isSubtypeOf(domain)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String name() {
		return this.name;
	}

	@Override
	public List<IProperty> properties() {
		return properties;
	}
	
	public List<IProperty>propertiesReturningThisType(){
		return this.returning;
	}

	@Override
	public List<IProperty> allProperties() {
		ArrayList<IProperty>props=new ArrayList<>();
		this.parents.forEach(p->{
			props.addAll(p.allProperties());
		});
		props.addAll(this.properties);
		return properties;
	}

	public void addProperty(Property property) {
		this.properties.add(property);
	}

	public void addReturning(Property property) {
		this.returning.add(property);
	}

	public void recordContained(EntityClass clazz) {
		this.contained.add(clazz);
		clazz.containedIn.add(this);
	}

	@Override
	public boolean isPartOf(IClass b) {
		return containedIn.contains(b);
	}

	@Override
	public Collection<? extends IClass> contained() {
		return this.contained; 
	}

}
