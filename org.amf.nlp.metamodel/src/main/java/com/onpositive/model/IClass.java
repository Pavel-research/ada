package com.onpositive.model;

import java.util.List;

public interface IClass extends IType{
 
	List<IProperty>properties();

	List<IProperty>allProperties();
}
