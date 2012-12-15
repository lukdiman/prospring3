package com.apress.prospring3.ch5.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DestructiveBean implements InitializingBean {
	private InputStream is = null;
	
	public String filePath = null;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean"); // ������������� ����
		
		if (filePath == null) {
			throw new IllegalArgumentException(
				"You must specify the filePath property of "
				// �������� filePath ������ ���� �����������.
				+ DestructiveBean.class);
		}
		
		is = new FileInputStream(filePath);
	}
	
	public void destroy() {
		System.out.println("Destroying Bean"); // ����������� ����
		
		if (is != null) {
			try {
				is.close();
				is = null;
			} catch (IOException ex) {
				// �� ����� �������� InputStream �������� ���������� IOException.
				System.err.println("WARN: An IOException occured trying to close the InputStream");
			}
		}
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/disposeMethod.xml");
		ctx.refresh(); // �������� ApplicationContext ����� �������� XML-����� ������������
		
		DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");
		System.out.println("Calling destroy()"); // ����� destroy()
		ctx.destroy();
		System.out.println("Called destroy()"); // destroy() ������
	}
}
