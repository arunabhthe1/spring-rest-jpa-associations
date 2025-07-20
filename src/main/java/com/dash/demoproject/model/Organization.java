package com.dash.demoproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORGANIZATION")
@Entity 
public class Organization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orgId;
	@Column(name="org_name")
	private String orgName;
	private Long orgCode;
	private String orgHeadName;

	private Long numberOfEmp;

	private String createdBy;
	private String status;
	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName + ", orgCode=" + orgCode + ", orgHeadName="
				+ orgHeadName + ", numberOfEmp=" + numberOfEmp + ", createdBy=" + createdBy + "]";
	}

	//@Temporal(TemporalType.DATE)
	//private java.util.Date innagurationDt;
	//private java.sql.Date innagurationDt;

	private java.sql.Date innagurationDt;
	//@CreationTimestamp
	//private java.sql.Date createdDt;
	//@UpdateTimestamp
	//private java.sql.Date updatedDt;
	
}
