package com.apress.prospring3.ch5.pe;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] name = text.split("\\s");
		Name result = new Name(name[0], name[1]);
		
		setValue(result);
	}
}
