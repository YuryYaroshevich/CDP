package com.cdp.testing1.bank.model;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = -3384815419819773361L;
	
	private String name;

	public Person(String name) {
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
		return "Person [name=" + name + "]";
	}
}
