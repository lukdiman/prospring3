package com.apress.prospring3.ch5.jsr330;

public interface MessageRenderer {
	public void render();
	
	public void setMessageProvider(MessageProvider provider);
	
	public MessageProvider getMessageProvider();
}
