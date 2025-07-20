package com.dash.demoproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="RETAIL_BANK_ACCOUNT")
public class RetailBankAccount {
	@Id
	@Column(name="cust_id")
	private Long custId;
	private Long accNo;
	private String ifscCode;
    @OneToOne
    @MapsId
    @JoinColumn(name = "cust_id")
	@JsonIgnore
    private Customer customer;
}
