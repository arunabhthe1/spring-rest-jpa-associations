package com.dash.demoproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dash.demoproject.model.Department;
import com.dash.demoproject.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());

	@GetMapping(value="/departments")
	public List<Department> getDepartments() {
		LOGGER.info("INSIDE THE GET DEPARTMENT");
		List<Department> departemtns=departmentService.getDepartments();
		LOGGER.info("DEPARTMENTS ::-->"+departemtns);
		return departemtns;
	}
	
	@PostMapping(value="/departments")
	public Department saveDepartment(@RequestBody Department department ) {
		LOGGER.info("INSIDE THE SAVE DEPARTMENT");
		Department departemtn=departmentService.saveDepartments(department);
		LOGGER.info("DEPARTMENTS ::-->"+departemtn);
		return departemtn;
	}
}
