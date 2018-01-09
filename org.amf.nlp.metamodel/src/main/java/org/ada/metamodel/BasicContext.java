package org.ada.metamodel;

import com.onpositive.clauses.IContext;
import com.onpositive.model.IProperty;
import com.onpositive.model.ITypedStore;

public class BasicContext implements IContext{

	private TypedStore store;

	public BasicContext(TypedStore typedStore) {
		this.store=typedStore;
	}

	@Override
	public ITypedStore store() {
		return store;
	}

}
