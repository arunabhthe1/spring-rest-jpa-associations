package com.dash.demoproject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.demoproject.model.Customer;
import com.dash.demoproject.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@Transactional
	public Customer getCustomer(Long custId){
		return customerRepository.findById(custId).get();
	}
	@Transactional
	public Customer saveOrUpdateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Transactional
	public Optional<Customer> getCustomerByCustId(Long custID) {
		return customerRepository.findById(custID);
	}

	@Transactional
	public void deleteCustomerByCustId(Long custID) {
		 customerRepository.deleteById(custID);
	}
}
