package com.dash.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dash.demoproject.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
