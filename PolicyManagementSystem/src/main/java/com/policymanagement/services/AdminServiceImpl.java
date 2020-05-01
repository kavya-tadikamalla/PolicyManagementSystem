package com.policymanagement.services;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.policymanagement.dao.AdminDao;
import com.policymanagement.dao.HelpDao;
import com.policymanagement.dao.PolicyVendorDao;
import com.policymanagement.models.Admin;
import com.policymanagement.models.AdminLogin;
import com.policymanagement.models.Customer;
import com.policymanagement.models.Help;
import com.policymanagement.models.PolicyVendor;

@Service
@Component
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao admindao;
	@Autowired
	private PolicyVendorDao policyvendordao;
	@Autowired
	private HelpDao helpdao;
	@PostConstruct
	public void init() {
		long count=admindao.count();
		System.out.println(count);
		if(count==0) {
			Admin a=new Admin();
			a.setAdminId(1000);
			admindao.save(a);
		}
	}
	
	 
	@Override
	public boolean login(AdminLogin adminLogin) 
	{
		Admin a=admindao.findByAdminId(adminLogin.getAdminId());
		if(a!=null)
		{
			return a.getPassword().equals(adminLogin.getPassword());
		}
		return false;
	}

	@Override
	public int createAdmin(@Valid Admin admin)
	{
		Admin a=admindao.findByAdminId(admin.getAdminId());
		if(a==null)
		{
			Admin ad=admindao.save(admin);
			if(ad!=null)
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
	public Admin getAdmin(int adminId) {
		
		return admindao.findByAdminId(adminId);
	}

	@Override
	public List<PolicyVendor> getAll() {
		
		return policyvendordao.findAll();
	}

	@Override
	public int nextadminId() {
		
		return admindao.nextadminId();
	}


	@Override
	public List<Help> getAllh() {
		
		return helpdao.findAll();
	}


		

}
