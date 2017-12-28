package com.onpositive.ada.core.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Meta {

	protected Map<String,PropertyMeta> properties=new LinkedHashMap<>();

	public Map<String, PropertyMeta> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, PropertyMeta> properties) {
		this.properties = properties;
	}
}
