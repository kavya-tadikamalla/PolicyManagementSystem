package com.policymanagement.models;

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
	    //@NotEmpty(message="required")
		private String policyvendorname;
	    @Column
	    //@NotEmpty(message="required")
	    private String policyvendorregno;
	    @Column
	    //@NotEmpty(message="required")
		private String policytype;
	    @Column
	    //@NotEmpty(message="required")
	    private String address;
	    @Column
	    //@NotEmpty(message="required")
	    private String country;
	    @Column
	    private int zipcode;
	    @Column
	   // @NotEmpty(message="required")
	    private String State;
	    @Column
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date dateOfBirth;
	    @Column
	    //@NotEmpty(message="required")
		private String  emailaddress;
	    @Column
	    //@NotEmpty(message="required")
	    //@Pattern(regexp = "(\\6|7|8|9)[0-9]{9})",message="Invalid Mobile")
		private String contactnumber;
	    @Column
	    //@NotEmpty(message="required")
	    private String website;
	    @Column
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    //@NotEmpty(message="required")
		private  Date certificateissueddate;
	    @Column
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    //@NotEmpty(message="required")
		private  Date certificatevaliditydate;
	    @Column
	    //@NotEmpty(message="required")
	    private String yearofestablishment;
	    @Column
	    //@NotEmpty(message="required")
	    private String password;
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
			return State;
		}
		public void setState(String state) {
			State = state;
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
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		@Override
		public String toString() {
			return "PolicyVendor [vendorId=" + vendorId + ", policyvendorname=" + policyvendorname
					+ ", policyvendorregno=" + policyvendorregno + ", policytype=" + policytype + ", address=" + address
					+ ", country=" + country + ", zipcode=" + zipcode + ", State=" + State + ", dateOfBirth="
					+ dateOfBirth + ", emailaddress=" + emailaddress + ", contactnumber=" + contactnumber + ", website="
					+ website + ", certificateissueddate=" + certificateissueddate + ", certificatevaliditydate="
					+ certificatevaliditydate + ", yearofestablishment=" + yearofestablishment + ", password="
					+ password + "]";
		}
		
		

}
