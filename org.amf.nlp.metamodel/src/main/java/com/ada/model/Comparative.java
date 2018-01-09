package com.ada.model;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

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

		public boolean op(Object property, Object comparisonTarget) {
			Set<Object> set = toSet(comparisonTarget);
			Number n=toNumber(property);
			Number n2=toNumber(comparisonTarget);
			switch (this) {
			case IN:
				if (property instanceof Collection){
					Collection<?>m=(Collection<?>) property;
					for (Object z:m){
						if (set.contains(z)){
							return true;
						}
					}
					return false;
				}
				else return set.contains(property);
			case NOT_IN:
				if (property instanceof Collection){
					Collection<?>m=(Collection<?>) property;
					for (Object z:m){
						if (set.contains(z)){
							return false;
						}
					}
					return true;
				}
				return !set.contains(property);	
			case EQUAL:
				if (property==null){
					property=n;
					//return comparisonTarget==null;
				}
				return property.equals(comparisonTarget)||n.equals(n2);
			case LESS:
				return n.doubleValue()<n2.doubleValue();
			case LESS_EQ:
				return n.doubleValue()<=n2.doubleValue();
			case MAX:
			case MIN:
			case MORE:
				return n.doubleValue()>n2.doubleValue();
			case MORE_EQ:
				return n.doubleValue()>=n2.doubleValue();
			case NEAREST:
			case NOT_EQUAL:
				return !property.equals(comparisonTarget);
			case NOT_MAX:
			case NOT_MIN:
			case NOT_NEAREST:
			default:
				break;
			}
			throw new UnsupportedOperationException();
			
		}

		private Number toNumber(Object property) {
			if (property instanceof Number){
				return (Number) property;
			}
			if (property instanceof Collection){
				Collection<?>c=(Collection<?>) property;
				return c.size();
			}
			return 0;
		}
	}
	
	protected final Kind operation;
	
	public Kind getOperation() {
		return operation;
	}

	public static Set<Object> toSet(Object comparisonTarget) {
		if (comparisonTarget instanceof Set<?>){
			return (Set<Object>) comparisonTarget;
		}
		return Collections.singleton(comparisonTarget);
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
