package com.apress.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DestructiveBeanWithJSR250 {
	private InputStream in;
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		
		if (filePath == null) {
			throw new IllegalArgumentException(
				"You must specify the filePath property of "
				+ DestructiveBeanWithJSR250.class);
		}
		
		in = new FileInputStream(filePath);
	}
	
	@PreDestroy()
	public void destroy() throws Exception {
		System.out.println("Destroying Bean");
		
		if (in != null) {
			try {
				in.close();
				in = null;
			} catch (IOException ex) {
				System.err.println("WARN: An IOException occured trying to close the InputStream");
			}
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/disposeJSR250.xml");
		ctx.refresh();
		
		DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");
		
		System.out.println("Calling destroy()");
		ctx.destroy();
		System.out.println("Called destroy()");
	}
}
