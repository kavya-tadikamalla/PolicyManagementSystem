package com.policymanagement.services;

import com.policymanagement.models.Customer;
import com.policymanagement.models.CustomerLogin;

public interface CustomerService {
	public int createCustomer(Customer customer);
	public boolean verifyLogin(CustomerLogin customerLogin);
	public Customer getCustomer(int custid);
}
