package com.apress.prospring3.ch4.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
//		SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
		SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");
		
//		System.out.println("Parent:\n" + parent);
		System.out.println("Child:\n" + child);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Age: " + age;
	}
}
