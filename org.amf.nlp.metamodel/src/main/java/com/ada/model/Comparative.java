package com.ada.model;

import java.io.IOException;
import java.util.Properties;

import com.onpositive.nlp.lexer.EntityRecognizer;

public final class Comparative {
	
	public static enum Kind{		
		
		MORE(">"),
		MORE_EQ(">="),
		LESS("<"),
		LESS_EQ("<="),
		MAX(">>"),
		MIN("<<"),
		EQUAL("=="),
		NOT_EQUAL("=="),
		NEAREST("~="),
		IN("in"),
		NOT_IN("not_in"), NOT_MAX("not_max"), NOT_MIN("not_min"), NOT_NEAREST("!~=");
		private final String name;
		
		Kind(String name){
			this.name=name;
		}
		
		@Override
		public String toString() {
			return name;
		}

		Kind negate(){
			switch (this) {
			case MORE:
				return LESS_EQ;
			case EQUAL:
				return Kind.NOT_EQUAL;
			case IN:
				return Kind.NOT_IN;
			case LESS:
				return Kind.MORE_EQ;
			case LESS_EQ:
				return MORE;
			case MAX:
				return NOT_MAX;
			case MIN:
				return NOT_MIN;
			case MORE_EQ:
				return LESS;
			case NEAREST:
				return NOT_NEAREST;
			case NOT_EQUAL:
				return EQUAL;
			case NOT_IN:
				return IN;
			case NOT_MAX:
				return MAX;
			case NOT_MIN:
				return MIN;
			case NOT_NEAREST:
				return Kind.NEAREST;

			default:
				break;
			}
			return null;
		}
	}
	
	protected final Kind operation;
	
	public Kind getOperation() {
		return operation;
	}

	protected final String text;

	public Comparative(Kind operation, String text) {
		super();
		this.operation = operation;
		this.text = text;
	}
	
	
	
	@Override
	public String toString() {
		return "COMP("+text+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comparative other = (Comparative) obj;
		if (operation != other.operation)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	public static void init(EntityRecognizer reg){
		try {
			Properties properties = new Properties();
			properties.load(Comparative.class.getResourceAsStream("/comparatives.list"));
			for (Kind o:Kind.values()){
				String property = properties.getProperty(o.name());
				if (property==null){
					continue;
				}
				String[] split = property.split(",");
				for (String s:split){
					reg.addEntity(s.trim(), new Comparative(o, s));
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}
	
}
