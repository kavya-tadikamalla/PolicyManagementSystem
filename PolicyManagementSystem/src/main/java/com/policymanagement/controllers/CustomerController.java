package com.policymanagement.controllers;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.policymanagement.dao.CustomerDao;
import com.policymanagement.dao.PaymentsDao;
import com.policymanagement.dao.PolicyVendorDao;
import com.policymanagement.models.Customer;
import com.policymanagement.models.CustomerLogin;
import com.policymanagement.models.Help;
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
	@Autowired
	private PaymentsDao paydao;
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
			customer.setBalance(200000);
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
		System.out.println(poli2);
		List<Policy> p4=new ArrayList<Policy>();
		for(Policy p3:poli2) {
			
				if(p3.getPolicytype().toLowerCase().contains(t.toLowerCase())) {
					model.addAttribute("searchli",c);
					p4.add(p3);
					model.addAttribute("searchlist",p4);
				}
				else if(p3.getPolicyName().toLowerCase().contains(t.toLowerCase())) {
					model.addAttribute("searchli",c);
					p4.add(p3);
					model.addAttribute("searchlist",p4);
				}
				else {
					model.addAttribute("message","no search results found");
					
				}
				System.out.println(p3);
			
		}
		
		return "customerHome";
		
	}
	@GetMapping("/buypolicy")
	public String buyPolicy(@RequestParam("policyid")int id,HttpSession session, Model model) {
		
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
		
	  @PostMapping("/cardpayment") 
	  public String paycard(@ModelAttribute("payment")Payments pay,Model model) {
		 boolean status=custser.buypolicy(pay);
		 Policy pol=custser.getpolbyid(pay.getPolicyId());
		 PolicyVendor pv=policyvendorser.getPolicyVendor(pol.getPolicyvendorId());
		 Customer cus=custser.getCustomer(pay.getUserId());
		 double cb=cus.getBalance()-pay.getTotalamount();
		 cus.setBalance(cb);
		 custdao.save(cus);
		 double pvb=pv.getBalance()+pay.getTotalamount();
		 pv.setBalance(pvb);
		 policyvendordao.save(pv);
		  LocalDate date = LocalDate.now(); 
		  System.out.println("Current Date: " +date); 
		  date = date.plusDays(pay.getPaymentperiod());
		  System.out.println("Date after Increment: " + date); 
		  Date date1 =Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		  System.out.println("Date after Increment: " + date1);
		  pay.setNextpayDate(date1);
		  pay.setPaystatus("paid");
		 paydao.save(pay);
		 java.util.Date date5=new java.util.Date();
		 
		  if(status) {
			 model.addAttribute("message","Successfully paid");
			 return "customerHome";
		 }
		 else {
			 model.addAttribute("message","Payment failed,try again");
			 return "cardpayments";
		 }
	  
	  }
	  @GetMapping("/listofmypolicies")
		public String findmyPolicies(HttpSession session,Model model)
			{
			List<Payments> pay=paydao.findAll();
			int uid=(Integer)session.getAttribute("userId");
			
			List<Policy> pl= custser.getAll();
			List<Policy> p2=new ArrayList<Policy>();
			List<Payments> pay1=new ArrayList<Payments>();
			for(Payments p:pay) {
				for(Policy p1:pl) {
					if(p.getPolicyId()==p1.getPolicyId()&&p.getUserId()==uid) {
						p2.add(p1);
						pay1.add(p);
					}
					model.addAttribute("mypol",p2);
					model.addAttribute("mypol1", pay1);
				}
			}
			
			return "customerHome";
			}
	  @GetMapping("/notify")
	  public String getnotify(HttpSession session,Model model) {
		  List<Payments> pay=paydao.findAll();
		  List<Policy> pl; 
		  List<Policy> p2=new ArrayList<Policy>();
			List<Payments> pay1=new ArrayList<Payments>();
			int uid=(Integer)session.getAttribute("userId");
			Date d,d1;
			LocalDate dl,dl1;// LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));
			for(Payments p1:pay) {
				if(p1.getUserId()==uid) {
					int i=p1.getNextpayDate().compareTo(p1.getLastpaid());
					System.out.println(i);
				if(i>0)//next day is after last day
					{
					d=p1.getLastpaid();
					dl=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));
					d1=p1.getNextpayDate();
					dl1=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d1));
					long days=ChronoUnit.DAYS.between(dl, dl1);
					p1.setFineamount(0);
					paydao.save(p1);
					if(days<=30) {
						pay1.add(p1);
						p2.add(custser.getpolbyid(p1.getPolicyId()));
						model.addAttribute("noofdays",days);
						model.addAttribute("notify", pay1);
						model.addAttribute("notify1",p2);
					}
					else if(days>30)
					{
						model.addAttribute("noofdays1","No dues left");
					}
					
					
				}
				else if(i<0)//next day is before last day 
					{
					d=p1.getLastpaid();
					dl=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d));
					d1=p1.getNextpayDate();
					dl1=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(d1));
					long days=ChronoUnit.DAYS.between(dl1, dl);
					double fd=(p1.getFineperday())*(days);
					p1.setFineamount(fd);
					paydao.save(p1);
					pay1.add(p1);
					p2.add(custser.getpolbyid(p1.getPolicyId()));
					model.addAttribute("noofdays",days);
					model.addAttribute("notify", pay1);
					model.addAttribute("notify1",p2);
					System.out.println(days);
					
				}
				}
				
			}
			
			System.out.println(p2);
			System.out.println(pay1);
			return "customerHome";
	  }
	  @GetMapping("/beforehelp")
	  public String help(Model model) {
		  model.addAttribute("help", new Help());
		  return "customerHelp";
	  }
	  @PostMapping("/afterhelp")
	  public String help1(@ModelAttribute("help") Help h,BindingResult result,Model model) 
	  {
		  if(result.hasErrors()) {
			  return "customerHelp";
		  }
		  else {
			  int status =custser.help(h);
			  if(status==1) {
				  model.addAttribute("message", "Your Issue is Registered");
				  return "customerHome";
			  }
			  else {
				  model.addAttribute("message", "Something went wrong");
				  return "customerHelp";
			  }
		  }
	  }
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
	
}
