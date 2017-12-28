package org.ada.metamodel;

import java.util.ArrayList;
import java.util.List;

import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class Property extends HasMeta<Property> implements IProperty{

	private IClass domain;
	private IType range;

	public Property(String id,String name,EntityClass domain,IType range) {
		super(id,name);
		this.domain=domain;
		this.range=range;
		if (range==null){
			throw new IllegalStateException();
		}
		if (range instanceof EntityClass){
			EntityClass ec=(EntityClass) range;
			ec.addReturning(this);
		}
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public IClass domain() {
		return domain;
	}

	@Override
	public IType range() {
		return range;
	}

	@Override
	public String id() {
		return name;
	}

	@Override
	public String toString() {
		return "P:"+domain.name()+"."+name;
	}

	@Override
	public int complexity() {
		return 1;
	}

	private ArrayList<IProperty>related=new ArrayList<>();
	
	public void recordRelated(IProperty iProperty) {
		related.add(iProperty);
		if (iProperty instanceof Property){
			Property pr=(Property) iProperty;
			pr.related.add(this);
		}
	}
	
	public List<IProperty> getRelated(){
		return related;
	}
}
