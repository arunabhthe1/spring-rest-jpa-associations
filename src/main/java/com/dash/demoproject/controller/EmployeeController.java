package com.dash.demoproject.controller;

import java.util.List;
import java.util.Optional;

import com.dash.demoproject.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dash.demoproject.model.Employee;
import com.dash.demoproject.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());
	
	public EmployeeController() {
		LOGGER.info(" This is the EmployeeController");
	}
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl; 
	
	@GetMapping(value="/employees")
	public List<Employee> getEmployees(){
		LOGGER.info("INSIDE THE GET EMPLOYEES");
		List<Employee> employees=employeeServiceImpl.getEmployees();
		LOGGER.info("Employees ::-->"+employees);
		return employees;
	}
	
	@PostMapping(value="/employees")
	public Employee saveEmployees(@RequestBody Employee employee){
		LOGGER.info("INSIDE THE SAVE EMPLOYEES");
		Employee emp=employeeServiceImpl.saveEmployees(employee);
		LOGGER.info("Persisted Employees ::-->"+emp);
		return emp;
	}
	
	@GetMapping(value="/employees/{firstname}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstname){
		LOGGER.info("INSIDE THE GET EMPLOYEES");
		List<Employee> employees=employeeServiceImpl.getEmpleeyByFirstName(firstname);
		LOGGER.info("Employees ::-->"+employees);
		return employees;
	}


	@PutMapping(value="/employees")
	public Customer updateEmployee(@RequestBody Customer customer){
		LOGGER.info(" This is update Customer");
		customer.getRetailBankAccount().setCustomer(customer);
		//return employeeServiceImpl.saveOrUpdateCustomer(customer);
		return null;
	}

	@DeleteMapping(value="/employees/{employeeId}")
	public String deleteEmployee(@PathVariable Long customerId){
		LOGGER.info(" This is delete Customer for customer id ",customerId);
		//customerService.deleteCustomerByCustId(customerId);
		return "SUCCESS";
	}
	
	@GetMapping(value="/employees/uniqueval")
	public List<Employee> getEmployeeByUniqueValues(@RequestParam Optional<String> firstname, @RequestParam Optional<String> lastname,@RequestParam Optional<String> empid){
		LOGGER.info("INSIDE THE getEmployeeByUniqueValues");
		List<Employee> employees=employeeServiceImpl.getEmpleeyByUniqueVlaues(firstname.orElse(""), lastname.orElse(""), empid.orElse(""));
		LOGGER.info("Employees getEmployeeByUniqueValues ::-->"+employees);
		return employees;
	}

	public EmployeeServiceImpl getEmployeeServiceImpl() {
		return employeeServiceImpl;
	}

	public void setEmployeeServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
		System.out.println(" This is the EmployeeController Setter");
		this.employeeServiceImpl = employeeServiceImpl;
	}
	
	
}
