package com.dash.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dash.demoproject.model.Department;
import com.dash.demoproject.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getDepartments(){
		return departmentRepository.findAll();
	}
	@Transactional
	public Department saveDepartments(Department department){
		return departmentRepository.save(department);
	}
}
