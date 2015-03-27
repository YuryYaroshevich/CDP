package com.epam.jpa1.model;

import javax.persistence.PrePersist;

public class EmployeeEventListener {
	@PrePersist
	public void initEmployeePersonalInfo(Object o) {
		Employee employee = (Employee) o;
		employee.getEmployeePersonalInfo().setEmployee(employee);
	}
}
