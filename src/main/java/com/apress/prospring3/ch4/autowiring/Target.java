package com.apress.prospring3.ch4.autowiring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
	private Foo foo;
	private Foo foo2;
	private Bar bar;

	public Target() {

	}

	public Target(Foo foo) {
		System.out.println("Target(Foo) called"); // Вызван метод Target(Foo)
	}

	public Target(Foo foo, Bar bar) {
		System.out.println("Target(Foo, Bar) called"); // Вызван метод
														// Target(Foo, Bar)
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Property foo set"); // Установлено свойство foo
	}

	public void setFoo2(Foo foo) {
		this.foo2 = foo;
		System.out.println("Property foo2 set"); // Установлено свойство foo2
	}

	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Property bar set"); // Установлено свойство bar
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:autowiring.xml");
		ctx.refresh();

		Target t = null;
		System.out.println("Using byName:\n"); // использование byName
		t = (Target) ctx.getBean("targetByName");
		System.out.println("\nUsing byType:\n"); // использование byType
		t = (Target) ctx.getBean("targetByType");
		System.out.println("\nUsing constructor:\n"); // использование
														// конструктора
		t = (Target) ctx.getBean("targetConstructor");
	}
}
