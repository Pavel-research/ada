package com.onpositive.ada.core.model;

import java.util.List;

public class PropertyMeta {

	
	private List<String>sameAs;
	private List<String>related;

	public List<String> getRelated() {
		return related;
	}

	public void setRelated(List<String> related) {
		this.related = related;
	}

	public List<String> getSameAs() {
		return sameAs;
	}

	public void setSameAs(List<String> sameAs) {
		this.sameAs = sameAs;
	}
}
