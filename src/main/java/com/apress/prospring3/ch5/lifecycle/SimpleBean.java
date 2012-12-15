package com.apress.prospring3.ch5.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	private static final String DEFAULT_NAME = "Luke Skywalker";

	private String name = null;

	private int age = Integer.MIN_VALUE;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void init() {
		System.out.println("Initializing bean"); // инициализация бина
		if (name == null) {
			System.out.println("Using default name"); // использование имени по
														// умолчанию
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type "
					// Должно быть установлено свойство age любого бина этого
					// типа.
							+ SimpleBean.class);
		}
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/initMethod.xml");
		ctx.refresh(); // Обновить ApplicationContext после загрузки XML-файла конфигурации
		
		SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
		SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
	}

	private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("An error occured in bean configuration: "
					+ ex.getMessage()); // В конфигурации бина обнаружена
										// ошибка.
			return null;
		}
	}
}
