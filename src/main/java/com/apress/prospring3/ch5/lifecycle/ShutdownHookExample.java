package com.apress.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/disposeInterface.xml");
		ctx.registerShutdownHook();
		ctx.refresh();
		
		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
	}
}
