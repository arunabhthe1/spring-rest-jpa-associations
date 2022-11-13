package com.dash.demoproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dash.demoproject.model.Customer;
import com.dash.demoproject.service.CustomerService;

@RestController
public class CustomerContoller {
	
	private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;
	@GetMapping(value="/customers")
	public List<Customer> getAllCustomer(){
		LOGGER.info(" This is the get all Customer");
		return customerService.getAllCustomers();
	}

	@PostMapping(value="/customers")
	public Customer saveCustomer(@RequestBody Customer customer){
		LOGGER.info(" This is save Customer");
		customer.getRetailBankAccount().setCustomer(customer);
		return customerService.saveOrUpdateCustomer(customer);
	}

}
