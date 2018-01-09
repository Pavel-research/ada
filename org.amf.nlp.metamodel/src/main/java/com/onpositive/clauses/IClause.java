package com.onpositive.clauses;

import java.util.stream.Stream;

import com.ada.model.IParsedEntity;

public interface IClause  extends IParsedEntity{
	
	ISelector produce(ISelector s);

	
	Stream<Object> perform(Stream<Object> selector,IContext ct);
}
