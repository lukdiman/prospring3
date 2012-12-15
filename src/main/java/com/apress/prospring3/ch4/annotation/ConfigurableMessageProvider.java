package com.apress.prospring3.ch4.annotation;

import com.apress.prospring3.ch4.MessageProvider;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
	private String message;
	
	@Autowired
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
