package com.onpositive.model;

import java.util.List;
import java.util.Optional;

public interface IClass extends IType{
 
	List<IProperty>properties();

	List<IProperty>allProperties();
	
	default Optional<IProperty> property(String id) {
        return allProperties().stream().filter(x->x.name().equals(id)).findFirst();
    }
}
