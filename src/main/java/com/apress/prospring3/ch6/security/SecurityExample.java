package com.apress.prospring3.ch6.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
	public static void main(String[] args) {
		// �������� ��������� ������������.
		SecurityManager mgr = new SecurityManager();
		
		// �������� ���.
		SecureBean bean = getSecureBean();
		
		// ����������� ����� ��� ������������ clarence.
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
		
		// ����������� ����� ��� ����������
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
