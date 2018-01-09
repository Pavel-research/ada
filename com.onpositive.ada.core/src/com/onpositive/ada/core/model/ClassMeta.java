package com.onpositive.ada.core.model;

import java.util.LinkedHashSet;

public class ClassMeta {

	protected LinkedHashSet<String> urlContainedIn=new LinkedHashSet<>();

	public LinkedHashSet<String> getUrlContainedIn() {
		return urlContainedIn;
	}

	public void setUrlContainedIn(LinkedHashSet<String> urlContainedIn) {
		this.urlContainedIn = urlContainedIn;
	}
}
