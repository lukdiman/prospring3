package com.apress.prospring3.ch4.xml;

import com.apress.prospring3.ch4.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
	private Oracle oracle;
	
	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
		System.out.println(injectRef);
	}
	
	@Override
	public String toString() {
		return oracle.defineMeaningOfLife();
	}
}
