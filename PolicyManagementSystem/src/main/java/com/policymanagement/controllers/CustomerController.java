package com.policymanagement.controllers;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.policymanagement.dao.CustomerDao;
import com.policymanagement.dao.PolicyVendorDao;
import com.policymanagement.models.Customer;
import com.policymanagement.models.CustomerLogin;
import com.policymanagement.models.Payments;
import com.policymanagement.models.Policy;
import com.policymanagement.models.PolicyVendor;
import com.policymanagement.models.SearchP;
import com.policymanagement.services.CustomerService;
import com.policymanagement.services.PolicyVendorService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerService custser;
	@Autowired
	private PolicyVendorService policyvendorser;
	@Autowired
	private PolicyVendorDao policyvendordao;
	@Autowired
	private CustomerDao custdao;
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
		
		int cid=custser.nextuserId();
		Customer customer=new Customer();
		customer.setUserId(cid+1);
		
		model.addAttribute("customerreg",customer);
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
	@GetMapping("/listofpolicies")
	public String findAllPolicies(HttpSession session,Model model)
		{
		List<PolicyVendor> pvl=policyvendorser.getAll();
		List<Policy> pl= custser.getAll();
		List<Policy> p2=new ArrayList<Policy>();	
		for(Policy p1:pl) {
			PolicyVendor pov=policyvendordao.findByVendorId(p1.getPolicyvendorId());
			
			boolean check=pov.getStatus().equals("activate");
			
			//System.out.println(check);
			if(check) {
				//System.out.println("------");
				p2.add(p1);	
			}
			model.addAttribute("policylist",p2);
			//System.out.println(p2);
		}
		return "customerHome";
		}
	@GetMapping("/searchp")
	public String searchPolicy(Model model,HttpSession session) {
		//Policy poli=new Policy();
		model.addAttribute("searchpo",new SearchP());
		return "searchPolicy";
	}
	@PostMapping("/searchpol")
	public String searchpolbyc(@ModelAttribute("searchpo")SearchP search,Model model) {
		String c=search.getCategory();
		String t=search.getText();
		List<Policy> poli2=custser.getAll();
		Policy poli=custser.getpolbyname(t);
		Policy poli1=custser.getpolbyname(c);
		System.out.println(poli);
		System.out.println(poli1);
		for(Policy p3:poli2) {
			
				if(p3.getPolicytype().toLowerCase().contains(t.toLowerCase())) {
					model.addAttribute("searchli",c);
					model.addAttribute("searchlist",p3);
				}
				else if(p3.getPolicyName().toLowerCase().contains(t.toLowerCase())) {
					model.addAttribute("searchli",c);
					model.addAttribute("searchlist",p3);
				}
				else {
					model.addAttribute("searchlist","no search results");
				}
			return "customerHome";
		}
		
		return "";
		
	}
	@GetMapping("/buypolicy")
	public String buyPolicy(@RequestParam("policyid")int id,HttpSession session, Model model) {
		/*
		 * System.out.println(id); int
		 * customerid=(Integer)session.getAttribute("userId"); Customer
		 * c=custser.getCustomer(customerid); List<Policy> polist=c.getPolicy();
		 * polist.add(custser.getpolbyid(id)); c.setPolicy(polist); boolean
		 * b=custser.updateCustomer(c);
		 */
		
		Policy p = custser.getpolbyid(id);
		int  customerid=(Integer)session.getAttribute("userId");
		
		Payments payment = new Payments();
		payment.setPolicyId(p.getPolicyId());
	 payment.setUserId(customerid);
	 payment.setFineperday(p.getFineperday());
	 payment.setAmount(p.getPremiumAmount());
		model.addAttribute("payment", payment);
		
		return "payment";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
	
}
