package com.epam.jpa1.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Address {
	@JsonView({View.Employee.class, View.Subdivision.class})
	private String city;
	
	@JsonView({View.Employee.class, View.Subdivision.class})
	private String street;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
