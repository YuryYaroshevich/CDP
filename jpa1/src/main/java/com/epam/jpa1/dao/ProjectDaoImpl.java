package com.epam.jpa1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.jpa1.model.Employee;
import com.epam.jpa1.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Project addEmployeeToProject(Long projectId, Long employeeId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Project project = entityManager.find(Project.class, projectId);
			Employee employee = entityManager.find(Employee.class, employeeId);
			List<Employee> projectEmployees = project.getEmployees();
			projectEmployees.add(employee);
			employee.getProjects().add(project);
			entityManager.merge(project);
			return project;	
		} finally {
			tx.commit();
			entityManager.close();
		}
	}
}
