package com.onpositive.clauses;

import java.util.Set;

public interface ICompositeSelector extends ISelector{

	Set<ISelector>members();

}
