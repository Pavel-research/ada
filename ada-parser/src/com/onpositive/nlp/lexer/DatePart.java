package com.onpositive.nlp.lexer;

public abstract class DatePart implements Cloneable{

	int value;
	boolean shift;	
	int shiftAmount;
	private String name;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (relative ? 1231 : 1237);
		result = prime * result + (shift ? 1231 : 1237);
		result = prime * result + shiftAmount;
		result = prime * result + value;
		return result;
	}
	@Override
	public final String toString() {
		return name+":"+shift+':'+relative+":"+value+":"+shiftAmount;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatePart other = (DatePart) obj;
		if (relative != other.relative)
			return false;
		if (shift != other.shift)
			return false;
		if (shiftAmount != other.shiftAmount)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	boolean relative;
	
	public DatePart(String name,int value, boolean shift, boolean relative) {
		super();
		this.name=name;
		this.value = value;
		this.shift = shift;
		this.relative = relative;
	}

	public  DatePart shift(int i){
		DatePart datePart;
		try {
			datePart = (DatePart)super.clone();
			datePart.shiftAmount+=i;
			return datePart;
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		
	}
}
