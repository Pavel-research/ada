package com.onpositive.ada.github;

import com.onpositive.ada.core.model.CoreEngine;

public class Github {

	
	static String[] grammar=new String[]{"/grammar/basic.rules"};
	
	private static final CoreEngine CORE_ENGINE = new CoreEngine("debug","/github.yaml",grammar,"/meta.yaml");

	public static CoreEngine getEngine(){
		return  CORE_ENGINE;
	}
}
