package com.epam.jpa1.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class EmployeePersonalInfo implements Serializable {	
	private static final long serialVersionUID = 2263980886911317212L;

	@JsonView({View.Employee.class, View.Subdivision.class})
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	@JsonView({View.Employee.class, View.Subdivision.class})
	private Sex sex;

	@JsonView({View.Employee.class, View.Subdivision.class})
	private short age;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@Id
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}
}
