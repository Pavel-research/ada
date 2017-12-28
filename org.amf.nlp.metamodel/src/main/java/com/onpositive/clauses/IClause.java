package com.onpositive.clauses;

import com.ada.model.IParsedEntity;

public interface IClause  extends IParsedEntity{
	
	ISelector produce(ISelector s);

}
