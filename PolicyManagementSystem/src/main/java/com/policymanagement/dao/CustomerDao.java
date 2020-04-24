package com.policymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policymanagement.models.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	public Customer findByUserId(int customerId);

}
