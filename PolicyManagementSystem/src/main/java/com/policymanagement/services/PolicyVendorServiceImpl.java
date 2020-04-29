package com.policymanagement.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.policymanagement.dao.PolicyDao;
import com.policymanagement.dao.PolicyVendorDao;
import com.policymanagement.models.Policy;
import com.policymanagement.models.PolicyVendor;
import com.policymanagement.models.PolicyVendorLogin;
@Service
@Component
public class PolicyVendorServiceImpl implements PolicyVendorService{
	@Autowired
	private PolicyVendorDao policyvendordao;
	@Autowired
	private PolicyDao policydao;
	@PostConstruct
	public void init() {
		long count=policyvendordao.count();
		System.out.println(count);
		if(count==0) {
			PolicyVendor p=new PolicyVendor();
			p.setVendorId(3000);
			policyvendordao.save(p);
		}
	}
	@Override
	public boolean vlogin(PolicyVendorLogin policyvendorLogin) {
		PolicyVendor u = policyvendordao.findByVendorId(policyvendorLogin.getVendorId());
		if(u!=null)
		{
			return u.getPassword().equals(policyvendorLogin.getPassword());
		}
		return false;
	}

	@Override
	public int createPolicyVendor(@Valid PolicyVendor policyvendor) {
		PolicyVendor u=policyvendordao.findByVendorId(policyvendor.getVendorId());
		if(u==null)
		{	
			
			PolicyVendor u1=policyvendordao.save(policyvendor);
			if(u1!=null)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		return 0;
	}

	@Override
	public PolicyVendor getPolicyVendor(int vendorId) {
		
		return policyvendordao.findByVendorId(vendorId);
	}

	@Override
	public boolean addPolicy(Policy policy) {
		
		Policy p= policydao.save(policy);
		if(p!=null) {
			return true;
		}
		return false;
	}

	@Override
	public int nextvendotId() {
				return policyvendordao.nextvendoId();
	}

	
	@Override
	public List<PolicyVendor> getAll() {
		
		return policyvendordao.findAll();
	}
	@Override
	public List<Policy> getAllpolicies() {
		
		return policydao.findAll();
	}
	@Override
	public Policy getpolbyid(int policyid) {
		
		return policydao.findByPolicyId(policyid);
	}
	

	

}