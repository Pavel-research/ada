package com.onpositive.clauses.impl;

import java.util.Collections;
import java.util.List;

import com.ada.model.IParsedEntity;
import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.Builtins;
import com.onpositive.model.IProperty;

public class Aggregators implements IClause{

	public static enum Mode{
		COUNT,MIN,MAX,AVG,SUM
	}
	
	protected Mode mode;
	
	public Mode getMode() {
		return mode;
	}


	public Aggregators(Mode mode) {
		super();
		this.mode = mode;
	}
	
	
	@Override
	public String toString() {
		return mode.toString();
	}
	
	@Override
	public ISelector produce(ISelector s) {
		if (s.multiplicity()==Multiplicity.SINGLE){
			return null;
		}
		if (mode==Mode.COUNT){
			return ClauseSelector.produce(s, Builtins.INTEGER, Multiplicity.SINGLE, this);
		}
		if (!s.domain().isOrdered()){
			return null;
		}
		if (mode==Mode.SUM){
			if (!s.domain().isSummable()){
				return null;
			}	
		}
		return ClauseSelector.produce(s, s.domain(), Multiplicity.SINGLE, this);
	}
	
	@Clause("COUNT")
	public static final Aggregators COUNT=new Aggregators(Mode.COUNT);
	@Clause("MIN")	
	public static final Aggregators MIN=new Aggregators(Mode.MIN);
	@Clause("MAX")
	public static final Aggregators MAX=new Aggregators(Mode.MAX);
	@Clause("SUM")
	public static final Aggregators SUM=new Aggregators(Mode.SUM);
	@Clause("AVERAGE")
	public static final Aggregators AVG=new Aggregators(Mode.AVG);

	@Override
	public List<? extends IParsedEntity> children() {
		return Collections.emptyList();
	}


	@Override
	public List<IProperty> usedProperties() {
		return Collections.emptyList();
	}

}
