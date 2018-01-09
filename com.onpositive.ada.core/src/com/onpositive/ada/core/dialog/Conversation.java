package com.onpositive.ada.core.dialog;

import java.util.Collection;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Collections;

import com.onpositive.ada.core.model.CoreEngine;
import com.onpositive.ada.core.model.ParsedQuery;
import com.onpositive.ada.core.model.QueryResult;

public class Conversation {

	protected ConversationManager owner;

	protected CoreEngine getEngine(){
		return owner.engine;
	}
	
	public Conversation(ConversationManager owner) {
		super();
		this.owner = owner;
	}

	@SuppressWarnings("unchecked")
	public OutgoingMessage handle(IncomingMessage message) {
		String text = message.getText();
		ParsedQuery parse = getEngine().parse(text);
		QueryResult execute = parse.execute();
		Collection<Object> results = execute.results();
		if (results.size()>0){
			return new OutgoingMessage(text, results);
		}
		return new OutgoingMessage(text, Collections.emptyList());
	}
}
