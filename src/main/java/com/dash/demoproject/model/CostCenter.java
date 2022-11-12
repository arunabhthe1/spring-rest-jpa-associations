package com.dash.demoproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="COSTCENTER")
public class CostCenter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COST_CENTER_ID")
	private Long costCenterId;
	//private Long departmentId;
	private String costCenterName;


	private Long cost;
	public String getCostCenterName() {
		return costCenterName;
	}
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
//	public Long getDepartmentId() {
//		return departmentId;
//	}
	public Long getCostCenterId() {
		return costCenterId;
	}
	public Long getCost() {
		return cost;
	}
//	public void setDepartmentId(Long departmentId) {
//		this.departmentId = departmentId;
//	}
	public void setCostCenterId(Long costCenterId) {
		this.costCenterId = costCenterId;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "CostCenter [costCenterName=" + costCenterName + ", costCenterId=" + costCenterId + "]";
	}

}
