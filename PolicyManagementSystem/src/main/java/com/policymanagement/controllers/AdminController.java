package com.policymanagement.controllers;
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

import com.policymanagement.dao.AdminDao;
import com.policymanagement.dao.HelpDao;
import com.policymanagement.dao.PolicyVendorDao;
import com.policymanagement.models.Admin;
import com.policymanagement.models.AdminLogin;
import com.policymanagement.models.ForgotUid;
import com.policymanagement.models.Help;
import com.policymanagement.models.PolicyVendor;

import com.policymanagement.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController
{

	@Autowired
	private AdminDao admindao;
	@Autowired
	private AdminService adminservice;
	@Autowired
	private PolicyVendorDao policyvendordao;
	@Autowired
	private HelpDao helpdao;
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
	public String adminRegisterForm(Model model,Model secmodel)
	{
		int aid=adminservice.nextadminId();
		Admin admin=new Admin();
		admin.setAdminId(aid+1);
		model.addAttribute("adreg",admin);
		//Security secure = new Security();
		//secmodel.addAttribute("securityque", secure);
		return "adminRegistration";
	}
	@PostMapping("/adminreg")
	public String adminRegister(
			@Valid @ModelAttribute("adreg") Admin admin/* ,@ModelAttribute("securityque") SecurityQ sec */,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "adminRegistration";
		}
		
		else {
			//sec.setUserId(admin.getAdminId());
			//admin.setSecurity(sec);
	
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
	@GetMapping("/listvendors")
	public String findAllVendors(HttpSession session,Model model) {
		List<PolicyVendor> vendor=adminservice.getAll();
		
		System.out.println(vendor);
		model.addAttribute("vendorlist",vendor);
		return "adminHome";
	}
	@GetMapping("/activate")
	public String activateS(@RequestParam("vendorid")int vid,Model model)
	{
		PolicyVendor policyvendor=policyvendordao.findByVendorId(vid);
		String s=policyvendor.getStatus();
		
		if(!s.equals("activate")) {
		policyvendor.setStatus("activate");
		PolicyVendor pv=policyvendordao.save(policyvendor);
		
			model.addAttribute("message", pv.getPolicyvendorname()+""+vid+"sucesfully activate");
			return "adminHome";
		
			
		}
		
		else {
			model.addAttribute("message", policyvendor.getPolicyvendorname()+""+vid+" is already activate");
			return "adminHome";
		}
		
	}
	@GetMapping("/deactivate")
	public String deactivateS(@RequestParam("vendorid")int vid,Model model)
	{
		PolicyVendor policyvendor=policyvendordao.findByVendorId(vid);
		String s=policyvendor.getStatus();
		if(!s.equals("deactivate")) {
		policyvendor.setStatus("deactivate");
		PolicyVendor pv=policyvendordao.save(policyvendor);
		model.addAttribute("message", pv.getPolicyvendorname()+""+vid+"sucesfully deactivated");
		return "adminHome";
		}
		else {
			model.addAttribute("message", policyvendor.getPolicyvendorname()+""+vid+"is already deactivated");
		return "adminHome";
		}
	}
	@GetMapping("/sendforcorrection")
	public String sendforcorrectionS(@RequestParam("vendorid")int vid,Model model)
	{
		PolicyVendor policyvendor=policyvendordao.findByVendorId(vid);
		String s=policyvendor.getStatus();
		if(!s.equals("makecorrections")) {
		policyvendor.setStatus("makecorrections");
		PolicyVendor pv=policyvendordao.save(policyvendor);
		model.addAttribute("message", pv.getPolicyvendorname()+""+vid+" makecorrections");	
		return "adminHome";
	}
		else {
			model.addAttribute("message", policyvendor.getPolicyvendorname()+""+vid+"has already sent for scorrection");
		return "adminHome";
		}
	}
	@GetMapping("/helpreq")
	public String listofHelpReq(HttpSession session,Model model)
	{
		List<Help> helpL=adminservice.getAllh();
		model.addAttribute("helpList", helpL);
		return "adminHome";
	}
	@GetMapping("/respondhelp")
	public String reponsehelp(@RequestParam("helpid")int hId,Model model)
	{
		Help help=helpdao.findByHid(hId);
		String s=help.getStatus();
		if(!s.equals("solved")) {
			help.setStatus("solved");
			helpdao.save(help);
			model.addAttribute("message", "Issue Resolved");
			
		}
		return "adminHome";
	}
	
	@GetMapping("/forgotuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "forgotid";
	}
	@PostMapping("/forgotuid1")
	public int fid1(@ModelAttribute("name") ForgotUid fid,Model model)
	{
		int b=adminservice.fid(fid);
		if(b!=0)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return b;
	
	}
	@GetMapping("/forgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotpwd";
	}
	@PostMapping("/forgotpwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=adminservice.fpwd(fid);
		if(b==true)
		{
	  	  return "resetPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "resetPwd";
		}
	}
	@PostMapping("/updatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Admin ad =admindao.findByadminId(forgetUID.getUid());
		ad.setPassword(forgetUID.getPwd());
		admindao.save(ad);
		model.addAttribute("message","your password has been updated");
		return "resetPwd";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}


}
