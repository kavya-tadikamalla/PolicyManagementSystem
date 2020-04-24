package com.policymanagement.controllers;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.policymanagement.models.Admin;
import com.policymanagement.models.AdminLogin;
import com.policymanagement.models.Customer;
import com.policymanagement.services.AdminService;
@Controller
@RequestMapping("/admin")
public class AdminController
{
	
	@Autowired
	private AdminService adminservice;
	@GetMapping("/")
	public String adminloginform(Model model)
	{
		model.addAttribute("adlogin",new AdminLogin());
		return "adminLogin";
	}
	@PostMapping("/adminlogin")
	public String adminLogin(@ModelAttribute("adlogin") AdminLogin adminlogin ,BindingResult result, Model model,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "adminLogin";
		}
		else
		{
			boolean status = adminservice.login(adminlogin);
			if(status)
			{
				/*
				 Customer cust=custser.getCustomer(customerlogin.getUserId());
				session.setAttribute("username",cust.getFirstName());
				session.setAttribute("userId", customerlogin.getUserId());
				 */
				Admin adm=adminservice.getAdmin(adminlogin.getAdminId());
				session.setAttribute("username",adm.getFirstName());
				session.setAttribute("userId", adminlogin.getAdminId());
				return "adminHome";
			}
		else
		{
			model.addAttribute("message","Invalid Username OR password");
			return "adminLogin";
		}
		
		}
	}
	@GetMapping("/register")
	public String adminRegisterForm(Model model)
	{
		model.addAttribute("adreg",new Admin());
		return "adminRegistration";
	}
	@PostMapping("/adminreg")
	public String adminRegister(@Valid @ModelAttribute("adreg") Admin admin,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "adminRegistration";
		}
		
		else {
	
			model.addAttribute("adlogin",new AdminLogin());			
			int res = adminservice.createAdmin(admin);
			
		if(res==0)
		{
			model.addAttribute("message", admin.getFirstName().toUpperCase()+" You are already registered");
		
		
		}
		else if(res==1)
		{
			model.addAttribute("message", admin.getFirstName().toUpperCase()+"Congrats your registration is successfull");
		
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
		
		}
		return "adminLogin";
		}
	}
	


	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "<h1>Logged Out Successfully <a href='/admin/'>Login Again</a>";
	}


}
