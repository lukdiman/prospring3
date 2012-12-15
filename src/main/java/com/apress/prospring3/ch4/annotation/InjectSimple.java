package com.apress.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	@Value("John Smith")
	private String name;
	@Value("35")
	private int age;
	@Value("1.78")
	private float height;
	@Value("true")
	private boolean programmer;
	@Value("1103760000")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
		System.out.println(simple);
	}
	
	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height="
				+ height + ", programmer=" + programmer + ", ageInSeconds="
				+ ageInSeconds + "]";
	}
}
