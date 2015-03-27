package com.epam.jpa1.dao;

import com.epam.jpa1.model.Project;

public interface ProjectDao {
	Project addEmployeeToProject(Long projectId, Long employeeId);
}
