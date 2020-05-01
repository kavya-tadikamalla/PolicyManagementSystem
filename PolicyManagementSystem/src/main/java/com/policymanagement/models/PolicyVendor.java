package com.policymanagement.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class PolicyVendor {
		
	    @Id
		@Generated(value="assigned")
		private int vendorId;
	    @Column
		private String policyvendorname;
	    @Column
	    private String policyvendorregno;
	    @Column
		private String policytype;
	    @Column
	    private String address;
	    @Column
	    private String country;
	    @Column
	    private int zipcode;
	    @Column
	    private String state;
	    @Column
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dateOfBirth;
	    @Column
		private String  emailaddress;
	    @Column
		private String contactnumber;
	    @Column
	    private String website;
	    @Column
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private  Date certificateissueddate;
	    @Column
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private  Date certificatevaliditydate;
	    @Column
	    private String yearofestablishment;
	    @Column
	    private String password;
	    @Column
	    private String status;
	    @Column
	    private double balance;
		public int getVendorId() {
			return vendorId;
		}
		public void setVendorId(int vendorId) {
			this.vendorId = vendorId;
		}
		public String getPolicyvendorname() {
			return policyvendorname;
		}
		public void setPolicyvendorname(String policyvendorname) {
			this.policyvendorname = policyvendorname;
		}
		public String getPolicyvendorregno() {
			return policyvendorregno;
		}
		public void setPolicyvendorregno(String policyvendorregno) {
			this.policyvendorregno = policyvendorregno;
		}
		public String getPolicytype() {
			return policytype;
		}
		public void setPolicytype(String policytype) {
			this.policytype = policytype;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getEmailaddress() {
			return emailaddress;
		}
		public void setEmailaddress(String emailaddress) {
			this.emailaddress = emailaddress;
		}
		public String getContactnumber() {
			return contactnumber;
		}
		public void setContactnumber(String contactnumber) {
			this.contactnumber = contactnumber;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		
		public String getYearofestablishment() {
			return yearofestablishment;
		}
		public void setYearofestablishment(String yearofestablishment) {
			this.yearofestablishment = yearofestablishment;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getCertificateissueddate() {
			return certificateissueddate;
		}
		public void setCertificateissueddate(Date certificateissueddate) {
			
			this.certificateissueddate = certificateissueddate;
		}
		public Date getCertificatevaliditydate() {
			return certificatevaliditydate;
		}
		public void setCertificatevaliditydate(Date certificatevaliditydate) {
			
			this.certificatevaliditydate = certificatevaliditydate;
		}
		public int getZipcode() {
			return zipcode;
		}
		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
		public Date getDateOfBirth(){
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "PolicyVendor [vendorId=" + vendorId + ", policyvendorname=" + policyvendorname
					+ ", policyvendorregno=" + policyvendorregno + ", policytype=" + policytype + ", address=" + address
					+ ", country=" + country + ", zipcode=" + zipcode + ", state=" + state + ", dateOfBirth="
					+ dateOfBirth + ", emailaddress=" + emailaddress + ", contactnumber=" + contactnumber + ", website="
					+ website + ", certificateissueddate=" + certificateissueddate + ", certificatevaliditydate="
					+ certificatevaliditydate + ", yearofestablishment=" + yearofestablishment + ", password="
					+ password + ", status=" + status + ", balance=" + balance + "]";
		}
		
				
		

}
