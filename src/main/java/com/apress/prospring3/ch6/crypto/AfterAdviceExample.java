package com.apress.prospring3.ch6.crypto;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
    public static void main(String[] args) {
        KeyGenerator generator = getKeyGenerator();

        for (int i = 0; i < 10; i++) {
            try {
                long key = generator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException ex) {
                System.out.println("Weak Key Generated!"); // Сгенерирован слабый ключ
            }
        }
    }

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());

        return (KeyGenerator) factory.getProxy();
    }
}
