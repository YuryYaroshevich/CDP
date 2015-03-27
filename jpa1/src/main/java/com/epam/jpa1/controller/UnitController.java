package com.epam.jpa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.jpa1.dao.CommonDao;
import com.epam.jpa1.dao.UnitDao;
import com.epam.jpa1.model.Unit;
import com.epam.jpa1.model.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	private CommonDao commonDao;
	@Autowired
	private UnitDao unitDao;
	
	@RequestMapping(method = RequestMethod.POST)
	@JsonView(View.Subdivision.class)
	public Unit create(@RequestBody Unit unit) {
		return (Unit) commonDao.create(unit);
	}
	
	@RequestMapping(value = "/{unitId}/{employeeId}", method = RequestMethod.PUT)
	@JsonView(View.Subdivision.class)
	public Unit addEmployee(@PathVariable("unitId") Long unitId,
			@PathVariable("employeeId") Long employeeId) {
		return unitDao.addEmployeeToUnit(unitId, employeeId);
	}
}
