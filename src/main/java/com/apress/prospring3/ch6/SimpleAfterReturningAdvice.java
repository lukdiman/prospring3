package com.apress.prospring3.ch6;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
	public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        // Создать прокси.
        ProxyFactory factory = new ProxyFactory();

        factory.setTarget(target);
        factory.addAdvice(new SimpleAfterReturningAdvice());

        MessageWriter proxy = (MessageWriter) factory.getProxy();

        // Записать сообщения.
        proxy.writeMessage();
    }

    @Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	    System.out.println("");
        System.out.println("After method: " + method.getName());
	}
}
