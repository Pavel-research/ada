package com.onpositive.clauses.impl;

import com.onpositive.clauses.IClause;
import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.Multiplicity;
import com.onpositive.model.Builtins;

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
	public ISelector produce(ISelector s) {
		if (s.multiplicity()==Multiplicity.SINGLE){
			return null;
		}
		if (mode==Mode.COUNT){
			return new ClauseSelector(s, Builtins.INTEGER, Multiplicity.SINGLE, this);
		}
		if (!s.domain().isOrdered()){
			return null;
		}
		if (mode==Mode.SUM){
			if (!s.domain().isSummable()){
				return null;
			}	
		}
		return new ClauseSelector(s, s.domain(), Multiplicity.SINGLE, this);
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

}
