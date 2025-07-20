package com.dash.demoproject.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long empid;
	private String firstname;
	private String lastname;
	private Long salary;
	
	@OneToMany(cascade=javax.persistence.CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="empid", referencedColumnName="empid")
	private Set<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "EMPLOYEE_DEPARTMENT_MAP", 
	  joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "empid")},
	  inverseJoinColumns = {@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")})

	private Set<Department> depatments;
	
	
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", salary=" + salary
				+ ", addresses=" + addresses + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empid, other.empid);
	}

	public Long getEmpid() {
		return empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Long getSalary() {
		return salary;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
	
}
