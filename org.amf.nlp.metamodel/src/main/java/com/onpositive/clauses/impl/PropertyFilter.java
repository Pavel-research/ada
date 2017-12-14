package com.onpositive.clauses.impl;

import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.Builtins;
import com.onpositive.model.IProperty;

public class PropertyFilter implements IClause {

	public enum PropertyFilterMode {
		HAS_GREATER, HAS_LESS, HAS_ANY, HAS_ALL, HAS_NOT_ANY, HAS_NOT_ALL, COUNT_GREATER, COUNT_LESS, COUNT_EQUAL,
	}

	protected final IProperty prop;
	protected final ISelector predicate;
	protected final PropertyFilterMode mode;

	private PropertyFilter(IProperty prop, ISelector predicate, PropertyFilterMode mode) {
		super();
		this.prop = prop;
		this.predicate = predicate;
		this.mode = mode;
	}
	
	public IProperty property(){
		return prop;		
	}
	
	public ISelector predicate(){
		return predicate;
	}
	
	public PropertyFilterMode mode(){
		return mode;
	}

	@Clause("FILTER")
	public static PropertyFilter propertyFilter(IProperty prop, ISelector predicate, PropertyFilterMode mode) {
		switch (mode) {
		case COUNT_EQUAL:
		case COUNT_GREATER:
		case COUNT_LESS:
			if (predicate.domain() != Builtins.INTEGER)
				return null;
			if (predicate.multiplicity() != Multiplicity.SINGLE) {
				return null;
			}
			break;
		case HAS_ALL:
		case HAS_ANY:
		case HAS_GREATER:
		case HAS_LESS:
		case HAS_NOT_ALL:
		case HAS_NOT_ANY:
			if (!predicate.domain().isSubtypeOf(prop.range())) {
				return null;
			}
		}
		return new PropertyFilter(prop, predicate, mode);
	}

	@Override
	public ISelector produce(ISelector s) {
		if (!s.domain().isSubtypeOf(prop.domain())) {
			return null;
		}
		return new ClauseSelector(s, s.domain(), null, this);
	}	
}