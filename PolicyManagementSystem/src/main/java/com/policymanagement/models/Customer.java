package com.policymanagement.models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Customer {
		@Id
	@Generated(value="assigned")
	private int userId;
	@Column
	//@NotEmpty(message = "First Name is required")
	private String firstName;
	@Column
	//@NotEmpty(message = "Last Name is required")
	private String lastName;
	@Column
	//@NotEmpty(message = "ContactNumber is required")
	//@Pattern(regexp = "[6789][0-9]{9}",message = "Invalid Mobile")
	private String contactNumber;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	
	private Date dateOfBirth;
	@Column
	private String email;
	@Column
	//@NotEmpty(message = "Password is required")
	private String password;
	@Column
	//@NotEmpty(message = "Select your Gender")
	private String gender;
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
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + "]";
	}
	
	
	

}
