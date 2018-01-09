package com.onpositive.ada.core.dialog;

import java.util.HashMap;

import com.onpositive.ada.core.model.CoreEngine;

public class ConversationManager {
	
	protected HashMap<String,Conversation>conversations=new HashMap<>();
	
	protected CoreEngine engine;

	public ConversationManager(CoreEngine engine) {
		this.engine=engine;
	}

	public OutgoingMessage handle(IncomingMessage message){
		Conversation conversation = conversations.get(message.channelId);
		if (conversation==null){
			conversation=new Conversation(this);
			conversations.put(message.getChannelId(), conversation);
		}
		return conversation.handle(message);		
	}
}
