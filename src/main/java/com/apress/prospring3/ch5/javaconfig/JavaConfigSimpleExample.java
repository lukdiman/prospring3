package com.apress.prospring3.ch5.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigSimpleExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MessageRenderer renderer = (MessageRenderer) ctx.getBean("messageRenderer");
		renderer.render();
	}
}
