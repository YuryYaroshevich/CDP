package com.cdp.testing1.bank.model;

import java.io.Serializable;

public enum Currency implements Serializable {
	DOLLAR("dollar"), EURO("euro"), RUSSIAN_RUBLE("russian ruble");	
	
	private String name;

	private Currency(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + "]";
	}
}
