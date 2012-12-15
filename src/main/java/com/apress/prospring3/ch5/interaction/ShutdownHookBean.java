package com.apress.prospring3.ch5.interaction;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		if (ctx instanceof GenericXmlApplicationContext) {
			((GenericXmlApplicationContext)ctx).registerShutdownHook();
		}
	}
}
