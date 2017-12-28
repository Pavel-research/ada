package com.onpositive.ada.core.model;

import java.util.ArrayList;
import java.util.List;

public class ParsedQuery {

	
	protected ArrayList<List<Object>>queries=new ArrayList<>();

	public ParsedQuery(ArrayList<List<Object>> queries) {
		super();
		this.queries = queries;
	}
	
	@Override
	public String toString() {
		return queries.toString();
	}
}

