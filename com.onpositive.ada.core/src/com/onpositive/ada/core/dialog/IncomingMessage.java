package com.onpositive.ada.core.dialog;

import java.util.Date;

public class IncomingMessage {

	protected final String from;
	protected final String text;
	protected final String channelId;
	protected final Date when;

	public IncomingMessage(String channelId,String from, String text) {
		super();
		this.from = from;
		this.channelId=channelId;
		this.text = text;
		this.when = new Date();
	}
	
	public String getChannelId() {
		return channelId;
	}

	public String getFrom() {
		return from;
	}

	public String getText() {
		return text;
	}

	public Date getWhen() {
		return when;
	}
}
