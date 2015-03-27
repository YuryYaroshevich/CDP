package com.epam.jpa1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.jpa1.model.Employee;
import com.epam.jpa1.model.Unit;

@Repository
public class UnitDaoImpl implements UnitDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Unit addEmployeeToUnit(Long unitId, Long employeeId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Unit unit = entityManager.find(Unit.class, unitId);
			Employee employee = entityManager.find(Employee.class, employeeId);
			List<Employee> unitEmployees = unit.getEmployees();
			unitEmployees.add(employee);
			employee.setUnit(unit);
			entityManager.merge(unit);
			return unit;
		} finally {
			tx.commit();
			entityManager.close();
		}
	}
}
