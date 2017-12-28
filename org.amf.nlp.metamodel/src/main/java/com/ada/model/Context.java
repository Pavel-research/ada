package com.ada.model;

import com.onpositive.clauses.ISelector;

public class Context implements Cloneable{

	private ISelector them;

	public ISelector getThem() {
		return them;
	}

	public void setThem(ISelector them) {
		this.them = them;
	}
	
	public Context clone() {
		try {
			return (Context) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException();
		}
		
	}
}
