package com.dash.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dash.demoproject.model.Employee;
import com.dash.demoproject.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl Constuctor");
	}

	@Autowired
	private EmployeeRepository employeerepository;
	
	public List<Employee> getEmployees(){
		return employeerepository.findAll();
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public Employee saveEmployees(Employee employee){
		return employeerepository.save(employee);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmpleeyByFirstName(String name){
		return employeerepository.findByFirstname(name);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmpleeyByUniqueVlaues(String fristname, String lastname,String empid){
		return employeerepository.findByUniqueValue(fristname,lastname,empid);
	}
}
