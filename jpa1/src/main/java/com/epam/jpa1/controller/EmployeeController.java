package com.epam.jpa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.jpa1.dao.CommonDao;
import com.epam.jpa1.model.Employee;
import com.epam.jpa1.model.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private CommonDao commonDao;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@JsonView(View.Employee.class)
	public Employee create(@RequestBody Employee employee) {
		return (Employee) commonDao.create(employee);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@JsonView(View.Employee.class)
	public Employee get(@PathVariable("id") Long id) {
		return (Employee) commonDao.find(Long.valueOf(id), Employee.class);
	}
	
	@JsonView(View.Employee.class)
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Employee update(@RequestBody Employee employee) {
		employee.getEmployeePersonalInfo().setEmployee(employee);
		return (Employee) commonDao.update(employee);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Message delete(@PathVariable("id") Long id) {
		commonDao.delete(id, Employee.class);
		return new Message("Employee with id = " + id + " has been removed.");
	}
}
