package com.apress.prospring3.ch2;

import java.util.Properties;
import java.io.FileInputStream;

public class MessageSupportFactory {
	private static MessageSupportFactory instance = null;
	private Properties props;
	private MessageRenderer renderer = null;
	private MessageProvider provider = null;
	
	private MessageSupportFactory() {
		props = new Properties();
		try {
			props.load(new FileInputStream("src/conf/msf.properties"));
			// Получить классы реализации
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			
			renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static {
		instance = new MessageSupportFactory();
	}
	
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	
	public MessageRenderer getMessageRenderer() {
		return renderer;
	}
	
	public MessageProvider getMessageProvider() {
		return provider;
	}
}
