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

import com.policymanagement.models.Customer;
import com.policymanagement.models.CustomerLogin;
import com.policymanagement.services.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerService custser;
	@GetMapping("/")
	public String customerlogin(Model model) {
		model.addAttribute("custml", new CustomerLogin());
		return "customerLogin";
	}
	@PostMapping("/customlogin")
	public String verifyClogin(@Valid @ModelAttribute("custml")CustomerLogin customerlogin,Model model,BindingResult result,HttpSession session) {
		
		if(result.hasErrors()) {
			//model.addAttribute("message,result");
			return "customerLogin";
		}
		else {
			boolean b= custser.verifyLogin(customerlogin);
			if(b==true) {
				Customer cust=custser.getCustomer(customerlogin.getUserId());
				session.setAttribute("username",cust.getFirstName());
				session.setAttribute("userId", customerlogin.getUserId());
				return "customerHome";
			}else {
				model.addAttribute("message","Invalid UserName or Password");
				return "customerLogin";
			}
		}
	}
	@GetMapping("/custregister")
	public String customerReg(Model model) {
		model.addAttribute("customerreg",new Customer());
		return "customerRegistration";
	}
	
	@PostMapping("/customerregistration")
	public String verifyCustReg(@Valid @ModelAttribute("customerreg")Customer customer,Model model,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("message",result);
			return "customerRegistration";
		}
		else {
			int res=custser.createCustomer(customer);
			if(res==0) {
				model.addAttribute("message",customer.getFirstName().toUpperCase()+ "You are already register");
			}
			else if(res==1) {
				model.addAttribute("message",customer.getFirstName().toUpperCase()+ "Registeration Successfull");
			}
			else if(res==2) {
				model.addAttribute("message","something went wrong");
			}
			model.addAttribute("custml", new CustomerLogin());
			return "customerLogin";
		}
	}
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "<h1>Logged Out Successfully <a href='/customer/'>Login Again</a>";
	}
	
}
