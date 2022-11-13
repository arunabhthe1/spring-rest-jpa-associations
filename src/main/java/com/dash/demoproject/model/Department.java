package com.dash.demoproject.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	private String departmentName;
	@OneToOne(cascade=javax.persistence.CascadeType.ALL)
	@JoinColumn(name="COST_CENTER_ID", referencedColumnName="COST_CENTER_ID")
	private CostCenter costCenter;
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", costcenter="+costCenter +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash( departmentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return  Objects.equals(departmentId, other.departmentId);
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}
	
	
	

}
