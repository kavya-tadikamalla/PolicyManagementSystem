package com.policymanagement.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table
public class Customer {
	@Id
	@Generated(value="assigned")
	private int userId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String contactNumber;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String gender;
	@Column
	private double balance;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "pay_table",joinColumns = {@JoinColumn(name="userId",referencedColumnName = "userId")},inverseJoinColumns ={@JoinColumn(name="policyId", referencedColumnName ="policyId" )})
	private List<Policy> policy;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		
			this.dateOfBirth =dateOfBirth ;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Policy> getPolicy() {
		return policy;
	}
	public void setPolicy(List<Policy> policy) {
		this.policy = policy;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", balance=" + balance + ", policy=" + policy + "]";
	}
	
	
	
	
	

}
