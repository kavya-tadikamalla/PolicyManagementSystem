package com.policymanagement.services;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.policymanagement.dao.AdminDao;
import com.policymanagement.models.Admin;
import com.policymanagement.models.AdminLogin;
@Service
@Component
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao admindao;
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

}
