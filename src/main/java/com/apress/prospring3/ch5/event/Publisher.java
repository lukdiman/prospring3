package com.apress.prospring3.ch5.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:events/events.xml");
		
		Publisher publisher = (Publisher) ctx.getBean("publisher");
		publisher.publish("Hello world!");
		publisher.publish("The quick brown fox jumped over the lazy dog");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	
	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));
	}
}
