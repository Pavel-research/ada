package com.onpositive.model;

public class Builtins {

	public static final BuiltinType NUMBER=new BuiltinType("number",true);


	public static final BuiltinType STRING=new BuiltinType("number",false);

	
	public static final BuiltinType INTEGER=new BuiltinType("integer",true,NUMBER);
	public static final BuiltinType FLOAT=new BuiltinType("float",true,NUMBER);
	
	public static final BuiltinType BOOLEAN=new BuiltinType("boolean",false);

	public static final BuiltinType DATETIME=new BuiltinType("datetime",true);

	public static final BuiltinType DATE=new BuiltinType("date",true,DATETIME);

	public static final BuiltinType TIME=new BuiltinType("time",true,DATETIME);

	public static final BuiltinType DURATION=new BuiltinType("duration",true);
	
	
	static{
		NUMBER.setSummable(true);
	}

}
