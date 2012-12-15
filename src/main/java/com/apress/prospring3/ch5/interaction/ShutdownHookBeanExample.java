package com.apress.prospring3.ch5.interaction;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.apress.prospring3.ch5.lifecycle.DestructiveBeanWithInterface;

public class ShutdownHookBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:interaction/shutdownHook.xml");
		ctx.refresh();
		
		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
	}
}