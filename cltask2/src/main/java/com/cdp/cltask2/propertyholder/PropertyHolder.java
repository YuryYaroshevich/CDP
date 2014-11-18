package com.cdp.cltask2.propertyholder;

import java.util.ResourceBundle;

public final class PropertyHolder {
	private static final PropertyHolder INSTACNE = new PropertyHolder();
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	private PropertyHolder() {
	}
	
	public static PropertyHolder getInstance() {
		return INSTACNE;
	}
	
	public String getProperty(String key) {
		return bundle.getString(key);
	}	
}
