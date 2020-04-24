package com.policymanagement.services;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.policymanagement.models.Admin;
import com.policymanagement.models.AdminLogin;

@Service
@Component
public interface AdminService {
	public boolean login(AdminLogin adminLogin);

	public int createAdmin(@Valid Admin admin);
	public Admin getAdmin(int adminId);
}
