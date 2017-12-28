package com.onpositive.clauses.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.ada.logic.BasicLogic;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;
import com.onpositive.model.IType;

public class Clauses {

	
	private static final Clauses CLAUSES = new Clauses();
	HashMap<String,Object>map=new HashMap<String,Object>();
	
	Clauses(){
		//proceed(Aggregators.class);
		//proceed(MapByProperty.class);
		//proceed(PropertyFilter.class);
		//proceed(OrSelector.class);
		//proceed(AndSelector.class);
		//proceed(Clauses.class);
		proceed(BasicLogic.class);
	}
	
	
	
	
	
	public boolean canCreate(String name,Object[]args){
		Object object = map.get(name);
		if (object==null){
			return false;
		}
		if (object instanceof Method){
			Method m=(Method) object;
			Class<?>[] parameterTypes = m.getParameterTypes();
			if (parameterTypes.length!=args.length){
				return false;
			}
			for (int i=0;i<args.length;i++){
				if (!parameterTypes[i].isInstance(args[i])){
					return false;
				}
			}
			return true;
		}
		else return args.length==0;
	}
	public Object create(String name,Object[]args){
		if (!canCreate(name, args)){
			return null;
		}
		Object object = map.get(name);
		if (object instanceof Method){
			Method m=(Method) object;
			try {
				return  m.invoke(null, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new IllegalStateException();
			}
		}
		return object;
	}
	
	protected void proceed(Class<?>clz){
		for (Method m :clz.getMethods()){
			if (Modifier.isStatic(m.getModifiers())){
				Clause annotation = m.getAnnotation(Clause.class);
				if (annotation!=null){
					map.put(annotation.value(), m);
				}
			}
		}
		for (Field f:clz.getFields()){
			if (Modifier.isStatic(f.getModifiers())){
				Clause annotation = f.getAnnotation(Clause.class);
				if (annotation!=null){
					map.put(annotation.value(), f);
				}
			}
		}
	}
	
	public static Clauses get(){
		return CLAUSES;
	}
}