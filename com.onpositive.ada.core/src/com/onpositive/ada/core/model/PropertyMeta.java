package com.onpositive.ada.core.model;

import java.util.List;

public class PropertyMeta {

	
	private List<String>sameAs;
	private List<String>related;
	private boolean recognizeValues;
	private boolean multiValue=true;
	private String getAs;
	
	public String getGetAs() {
		return getAs;
	}

	public void setGetAs(String getAs) {
		this.getAs = getAs;
	}

	public boolean isMultiValue() {
		return multiValue;
	}

	public void setMultiValue(boolean multiValue) {
		this.multiValue = multiValue;
	}

	public boolean isRecognizeValues() {
		return recognizeValues;
	}

	public void setRecognizeValues(boolean recognizeValues) {
		this.recognizeValues = recognizeValues;
	}

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
