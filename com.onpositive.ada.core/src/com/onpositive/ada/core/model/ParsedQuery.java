package com.onpositive.ada.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import com.onpositive.clauses.ISelector;

public class ParsedQuery {

	protected CoreEngine engine;
	protected ArrayList<List<Object>> queries = new ArrayList<>();
	private String query;

	public ParsedQuery(String query,CoreEngine eng, ArrayList<List<Object>> queries) {
		super();
		this.queries = queries;
		this.engine = eng;
		this.query=query;
	}

	@Override
	public String toString() {
		return queries.toString();
	}

	public QueryResult execute() {
		ArrayList<List<Object>> weirdQueries = new ArrayList<>();
		LinkedHashSet<Collection<Object>> ms = new LinkedHashSet<>();
		HashMap<Collection<Object>,ISelector>results=new HashMap<>();
		for (List<Object> q : queries) {
			if (q.size() > 1) {
				weirdQueries.add(q);
			} else {
				Object option = q.get(0);
				if (option instanceof ISelector) {
					ISelector sl = (ISelector) option;
					Collection<Object> execute = engine.store.execute(sl);
					if (execute.size() > 0) {
						ms.add(execute);
						results.put(execute, sl);
					}
				} else {
					weirdQueries.add(q);
				}
			}
		}
		
		return new QueryResult(engine.getStore(),query, weirdQueries, results, ms, ms.size()==1||ms.isEmpty()&&weirdQueries.isEmpty());
	}
}
