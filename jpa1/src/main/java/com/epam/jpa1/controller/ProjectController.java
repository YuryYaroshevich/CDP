package com.epam.jpa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.jpa1.dao.CommonDao;
import com.epam.jpa1.dao.ProjectDao;
import com.epam.jpa1.model.Project;
import com.epam.jpa1.model.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CommonDao commonDao;
		
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@JsonView(View.Subdivision.class)
	public Project create(@RequestBody Project project) {
		return (Project) commonDao.create(project);
	}
	
	@RequestMapping(value = "/{projectId}/{employeeId}", method = RequestMethod.PUT)
	@JsonView(View.Subdivision.class)
	public Project addEmployee(@PathVariable("projectId") Long projectId,
			@PathVariable("employeeId") Long employeeId) {
		return projectDao.addEmployeeToProject(projectId, employeeId);
	}
}
