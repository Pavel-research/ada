package com.onpositive.ada.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.SingleSelector;
import com.onpositive.model.ITypedStore;

public class QueryResult {

	protected String query;

	protected ArrayList<List<Object>> weirdQueries = new ArrayList<>();
	protected HashMap<Collection<Object>, ISelector> results = new HashMap<>();
	protected LinkedHashSet<Collection<Object>> ms = new LinkedHashSet<>();
	protected boolean single;

	private ITypedStore store;

	public QueryResult(ITypedStore store,String query, ArrayList<List<Object>> weirdQueries,
			HashMap<Collection<Object>, ISelector> results, LinkedHashSet<Collection<Object>> ms, boolean single) {
		super();
		this.query = query;
		this.weirdQueries = weirdQueries;
		this.results = results;
		this.ms = ms;
		this.single = single;
		this.store=store;
	}
	
	@Override
	public String toString() {
		return this.results.toString();
	}
	public Set<Object>propertyValues(String prop){
		return asSelector().map(prop).values(store).collect(Collectors.toSet());
	}

	public boolean isOkey() {
		return weirdQueries.size() == 1;
	}

	public boolean isAmbigous() {
		return ms.size() > 1;
	}
	
	public ISelector asSelector(){
		if (results.size()==1){
			return new SingleSelector(results(), results.values().iterator().next().domain());
		}
		throw new IllegalStateException();		
	}

	public Collection<Object> results() {
		if (ms.isEmpty()){
			return Collections.emptyList();
		}
		return ms.iterator().next();
	}

	public Map<Collection<Object>, ISelector> getMultiResults() {
		return results;
	}

	public int total() {
		if (ms.isEmpty()){
			return 0;
		}
		return ms.iterator().next().size();
	}
}
