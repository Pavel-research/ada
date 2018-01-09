package com.onpositive.ada.core.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Meta {

	protected Map<String,PropertyMeta> properties=new LinkedHashMap<>();
	protected Map<String,ClassMeta> classes=new LinkedHashMap<>();

	public Map<String, ClassMeta> getClasses() {
		return classes;
	}

	public void setClasses(Map<String, ClassMeta> classes) {
		this.classes = classes;
	}

	public Map<String, PropertyMeta> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, PropertyMeta> properties) {
		this.properties = properties;
	}
}
