package com.onpositive.clauses;

import com.ada.model.conditions.IHasDomain;
import com.onpositive.model.IProperty;

public interface IComparison extends IHasDomain{

	IComparison negate();

	boolean isNotSolved();

	IComparison solve(IProperty prop);

}
