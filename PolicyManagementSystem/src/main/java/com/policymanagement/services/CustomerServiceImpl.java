package com.policymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.policymanagement.dao.CustomerDao;
import com.policymanagement.models.Customer;
import com.policymanagement.models.CustomerLogin;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custdao;
	@Override
	public int createCustomer(Customer customer) {
		Customer c=custdao.findByUserId(customer.getUserId());
		if(c==null) {
			Customer c1=custdao.save(customer);
			if(c1!=null)
			{
				return 1;
			}
			else {
				return 0;
			}
		}
		return 2;
	}

	@Override
	public boolean verifyLogin(CustomerLogin customerlogin) {
		
		Customer c2=custdao.findByUserId(customerlogin.getUserId());
		if(c2!=null) {
			return c2.getPassword().equals(customerlogin.getPassword());
		}
		
		return false;
	}

	@Override
	public Customer getCustomer(int custid) {
		
		return custdao.findByUserId(custid);
	}

}
