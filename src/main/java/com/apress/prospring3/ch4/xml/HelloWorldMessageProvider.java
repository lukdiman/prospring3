package com.apress.prospring3.ch4.xml;

import com.apress.prospring3.ch4.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
	@Override
	public String getMessage() {
		return "Hello World!";
	}
}
