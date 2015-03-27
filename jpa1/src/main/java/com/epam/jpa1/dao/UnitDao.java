package com.epam.jpa1.dao;

import com.epam.jpa1.model.Unit;

public interface UnitDao {
	Unit addEmployeeToUnit(Long unitId, Long employeeId);
}
