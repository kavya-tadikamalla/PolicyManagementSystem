package com.policymanagement.controllers;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.policymanagement.dao.PolicyDao;
import com.policymanagement.models.Policy;
import com.policymanagement.models.PolicyVendor;
import com.policymanagement.models.PolicyVendorLogin;
import com.policymanagement.services.PolicyVendorService;
@Controller
@RequestMapping("/policyvendor")


public class PolicyVendorController {
	
		@Autowired
		private PolicyDao policydao;
		@Autowired
		private PolicyVendorService policyvendorService;
		@GetMapping("/")
		public String policyvendorHome(Model model)
		{
			
			model.addAttribute("policyvendor", new PolicyVendorLogin());
			return "policyvendorLogin";
		}
		
		@PostMapping("/policyvendorlogin")
		public String policyvendorLogin(@ModelAttribute("policyvendor") PolicyVendorLogin policyvendorLogin,BindingResult result, Model model,HttpSession session)
		{
			//System.out.println(stLogin);
			if(result.hasErrors())
			{
				return "policyvendorLogin";
			}
			else
			{
				boolean status = policyvendorService.vlogin(policyvendorLogin);
				if(status)
				{
					
					PolicyVendor p1=policyvendorService.getPolicyVendor(policyvendorLogin.getVendorId());
					String pname=p1.getPolicyvendorname();
					session.setAttribute("username", pname);
					session.setAttribute("ptype", p1.getPolicytype());
					session.setAttribute("userId", policyvendorLogin.getVendorId());
					return "policyvendorHome";
				}
			else
			{
				model.addAttribute("message","Invalid Username OR password");
				return "policyvendorLogin";
			}
			
			}
		}
		
		
		@GetMapping("/policyvendorreg")
		public String userpolicyRegisterForm(Model model)
		{
			int pid=policyvendorService.nextvendotId();
			PolicyVendor policyvendor = new PolicyVendor();
			
			policyvendor.setVendorId(pid+1);
			model.addAttribute("policyvendorreg", policyvendor);
			
			return "policyvendorRegistration";
		}

		
		@PostMapping("/policyvendorreg")
		public String registerVendor(@Valid @ModelAttribute("policyvendorreg") PolicyVendor policyvendor,BindingResult result,Model model)
		{
			if(result.hasErrors())
			{
				return "policyvendorRegistration";
			}
			
			else {
				PolicyVendorLogin policyvendorlogin = new PolicyVendorLogin();
				model.addAttribute("policyvendor",policyvendorlogin);
				policyvendor.setStatus("not yet activated");
				int res = policyvendorService.createPolicyVendor(policyvendor);
				
			if(res==0)
			{
				model.addAttribute("message", policyvendor.getPolicyvendorname().toUpperCase()+" You are already registered");		
			}
			else if(res==1)
			{
				model.addAttribute("message", policyvendor.getPolicyvendorname().toUpperCase()+"Congrats your registration is successfull");
			
			
			}
			else
			{
				model.addAttribute("message", "Some thing went wrong");
			
			}
			
			model.addAttribute("userId",policyvendor.getVendorId());
			return "policyvendorLogin";
			}
		}
		@GetMapping("/addpolicy1")
		public String addPolicy(Model model,HttpSession session) 
		{
			String name=(String)session.getAttribute("username");
			int vid=(Integer)session.getAttribute("userId");
			if(vid == 0||name==null) {
				model.addAttribute("newpolicy", new Policy());
				model.addAttribute("message","please Login First < a href='/policyvendor'>");
				return "policyvendorHome";
				
			}
			model.addAttribute("newpolicy", new Policy());
			return "addPolicy";
		}
		@PostMapping("/addpolicy")
		public String createPolicy(@ModelAttribute("newpolicy")Policy policy,Model model) {
			boolean status=policyvendorService.addPolicy(policy);
			if(status) {
				model.addAttribute("message","Policy Created");
				return "policyvendorHome";
			}
			else {
				model.addAttribute("message","Policy not Created, something went wrong");
				return "policyvendorHome";
			}
		}
		
		@GetMapping("/listpolicies")
		public String listmypolicies(HttpSession session,Model model) {
			List<Policy> policy=policyvendorService.getAllpolicies();
			int id=(Integer)session.getAttribute("userId");
			for(Policy p3:policy) {
				if(p3.getPolicyvendorId()==id)
				{
					model.addAttribute("policyl",p3);
				}
			}
			return "policyvendorHome";
		}
		
		@GetMapping("/editpolicy")
		public String editpolicydetails(@RequestParam("policyid")int pid,Model model,HttpSession session)
		{
			session.setAttribute("polid", pid);
			Policy p=policyvendorService.getpolbyid(pid);
			model.addAttribute("policy",p);
			return "editPolicy";
		}
		@PostMapping("/addeditpolicy")
		public String editedPolicy(@ModelAttribute("policy")Policy pol,Model model) {
			
			boolean status=policyvendorService.addPolicy(pol);
			if(status) {
				model.addAttribute("message","Policy edited Created");
				return "policyvendorHome";
			}
			else {
				model.addAttribute("message","Policy not Created, something went wrong");
				return "policyvendorHome";
			}
			
		}
		@GetMapping("/logout")
		
		public String logout(HttpSession session)
		{
			session.invalidate();
			return "redirect:/";
		}


	}