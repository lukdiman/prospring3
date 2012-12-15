package com.apress.prospring3.ch4.annotation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {
	@Value("#{injectSimpleConfig.name}")
	private String name;
	@Value("#{injectSimpleConfig.age + 1}")
	private int age;	
	@Value("#{injectSimpleConfig.height}")
	private float height;
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	@Value("#{injectSimpleConfig.ageInSeconds}")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimpleSpel simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
		System.out.println(simple);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}
	
	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	@Override
	public String toString() {
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height="
				+ height + ", programmer=" + programmer + ", ageInSeconds="
				+ ageInSeconds + "]";
	}
}
