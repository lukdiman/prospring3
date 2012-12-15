package com.apress.prospring3.ch6.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
	public static void main(String[] args) {
		// Получить диспетчер безопасности.
		SecurityManager mgr = new SecurityManager();
		
		// Получить бин.
		SecureBean bean = getSecureBean();
		
		// Попробовать войти как пользователь clarence.
		mgr.login("clarence", "pwd");
		bean.writeSecureMessage();
		mgr.logout();
		
		try {
			mgr.login("janm", "pwd");
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		} finally {
			mgr.logout();
		}
		
		// Попробовать войти без полномочий
		try {
			bean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		}
	}
	
	private static SecureBean getSecureBean() {
		ProxyFactory factory = new ProxyFactory();
		
		factory.setTarget(new SecureBean());
		factory.addAdvice(new SecurityAdvice());
		
		return (SecureBean) factory.getProxy();
	}
}
