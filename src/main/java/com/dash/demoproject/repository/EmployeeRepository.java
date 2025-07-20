package com.dash.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dash.demoproject.model.Employee;
import java.util.*;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	public List<Employee> findByFirstname(String name);
	
	
	@Query("select emp from EMPLOYEE emp where upper(emp.firstname) like concat( upper(?1), '%') and upper(emp.lastname) like concat( upper(?2), '%') and upper(emp.empid) like concat((?3), '%')")
	List<Employee> findByUniqueValue(String fristname, String lastname,String empid);

}
