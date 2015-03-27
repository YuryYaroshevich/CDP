package com.epam.jpa1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "unit")
public class Unit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({View.Employee.class, View.Subdivision.class})
	private long id;
	
	@JsonView({View.Employee.class, View.Subdivision.class})
	private String name;
	
	@OneToMany(targetEntity = Employee.class, 
			mappedBy = "unit", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JsonView(View.Subdivision.class)
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
