package com.onpositive.ada.core.dialog;

import java.util.Collection;

public class OutgoingMessage {

	protected String header;
	
	public String getHeader() {
		return header;
	}

	public Collection<Object> getResults() {
		return results;
	}

	protected Collection<Object>results;
	
	public OutgoingMessage(String header, Collection<Object> results) {
		super();
		this.header = header;
		this.results = results;
	}
}
