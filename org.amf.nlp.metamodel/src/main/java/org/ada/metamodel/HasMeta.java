package org.ada.metamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class HasMeta<T extends HasMeta<T>> {

	public final String id;
	public final String name;
	public HasMeta(String id,String name) {
		super();
		this.id = id;
		this.name=name;
	}
	protected HashMap<Class<?>,Object>services=new HashMap<Class<?>, Object>();
	protected HashMap<String,Object>simpleProps=new HashMap<String, Object>();
	
	protected ArrayList<T>parents=new ArrayList<T>();
	protected ArrayList<T>subElements=new ArrayList<T>();
	
	@SuppressWarnings("unchecked")
	public void addParent(T parent){
		parents.add(parent);
		parent.subElements.add((T)this);
	}
	
	public void put(String key,Object object){
		this.simpleProps.put(key, object);
	}
	public <SC,A extends T> void  registerService(Class<SC> s,A object){
		this.services.put(s, object);
	}
	
	@SuppressWarnings("unchecked")
	public<V> V get(String value,V defaultValue){
		if (simpleProps.containsKey(value)){
			return (V) simpleProps.get(value);
		}
		for (T p:parents){
			V v = p.get(value, defaultValue);
			if (v!=null&&!v.equals(defaultValue)){
				return v;
			}
		}
		return defaultValue;		
	}
	public <C> C getService(Class<C>service){
		if (services.containsKey(service)){
			return service.cast(services.get(service));
		}
		for (T p:parents){
			C so = p.getService(service);
			if (so!=null){
				return so;
			}
		}
		return null;
	}
	
	String getString(String key){
		return get(key,"");
	}
	boolean getBoolean(String key){
		return get(key,false);
	}
}