package com.apress.prospring3.ch5.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
	private static final long serialVersionUID = -6148515976822215161L;
	
	private String msg;
	
	public MessageEvent(Object source, String msg) {
		super(source);
		
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
