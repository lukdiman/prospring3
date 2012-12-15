package com.apress.prospring3.ch5.factory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:factory/factoryMethod.xml");
		ctx.refresh();
		
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hello World!");
	}
}
