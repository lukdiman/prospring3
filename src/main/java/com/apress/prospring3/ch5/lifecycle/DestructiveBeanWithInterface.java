package com.apress.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {
	private InputStream is;
	public String filePath = null;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean"); // инициализация бина
		
		if (filePath == null) {
			throw new IllegalArgumentException(
				"You must specify the filePath property of "	
				+ DestructiveBeanWithInterface.class);
		}
		
		is = new FileInputStream(filePath);
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Bean");
		
		if (is != null) {
			try {
				is.close();
				is = null;
			} catch (IOException ex) {
				System.err.println("WARN: An IOException occured trying to close the InputStream");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/disposeInterface.xml");
		ctx.refresh();
		
		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
		System.out.println("Calling destroySingletons()");
		ctx.destroy();
		System.out.println("Called destroySingletons()");
	}
}
