package com.epam.jpa1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@EntityListeners({EmployeeEventListener.class})
public class Employee implements Serializable {
	private static final long serialVersionUID = -9447971634797454L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({View.Employee.class, View.Subdivision.class})
	private long id;
	
	@Embedded
	@JsonView({View.Employee.class, View.Subdivision.class})
	private Address address;
	
	@Enumerated(EnumType.STRING)
	@JsonView({View.Employee.class, View.Subdivision.class})
	private EmployeeStatus status;
	
	@OneToOne(mappedBy = "employee", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JsonView(View.Employee.class)
	private EmployeePersonalInfo employeePersonalInfo;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	@JsonView(View.Employee.class)
	private Unit unit;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employees")
	@JsonView(View.Employee.class)
	private List<Project> projects;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	public EmployeePersonalInfo getEmployeePersonalInfo() {
		return employeePersonalInfo;
	}

	public void setEmployeePersonalInfo(
			EmployeePersonalInfo employeePersonalInfo) {
		this.employeePersonalInfo = employeePersonalInfo;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
