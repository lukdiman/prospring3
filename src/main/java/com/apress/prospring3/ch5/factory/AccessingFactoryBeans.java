package com.apress.prospring3.ch5.factory;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.security.MessageDigest;

public class AccessingFactoryBeans {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:factory/factory.xml");
		ctx.refresh();
		
		MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
		
		MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
		try {
			MessageDigest shaDigest = factoryBean.getObject();
			System.out.println(shaDigest.digest("Hello World!".getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
