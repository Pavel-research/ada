package com.ada.model;

import java.io.IOException;
import java.util.Properties;

import com.onpositive.nlp.lexer.EntityRecognizer;
import com.onpositive.nlp.parser.ISplitPoint;

public final class Preposition implements ISplitPoint{

	
	public enum Kind{
		NORMAL
	}

	private final String text;
	
	public String getText() {
		return text;
	}

	public Kind getKnd() {
		return knd;
	}

	private final Kind knd;
	
	public Preposition(String text,Kind knd){
		this.text=text;
		this.knd=knd;
	}
	
	@Override
	public String toString() {
		return "PREPOSITION("+this.text+")";
	}
	
	public static void init(EntityRecognizer reg){
		try {
			Properties properties = new Properties();
			properties.load(Comparative.class.getResourceAsStream("/conjuctions.list"));
			for (Preposition.Kind o:Preposition.Kind.values()){
				String[] split = properties.getProperty(o.name()).split(",");
				for (String s:split){
					reg.addEntity(s.trim(), new Preposition(s, o));
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean includes() {
		return false;
	}
}
