package com.dash.demoproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Entity(name="CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	private Long custId;
	private String custName;
	private String custType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private CustomerAddress customerAddress;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private RetailBankAccount retailBankAccount;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_TRADING_ACCOUNT_MAP", 
    joinColumns = 
      { @JoinColumn(name = "cust_id", referencedColumnName = "cust_id") },
    inverseJoinColumns = 
      { @JoinColumn(name = "trading_id", referencedColumnName = "trading_id") })
	private TradingAccount tradingAccount;
}
