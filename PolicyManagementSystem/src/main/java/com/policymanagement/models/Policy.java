package com.policymanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Entity
@Table
public class Policy {
	@SequenceGenerator(name = "elPolicySeq",initialValue = 3030, allocationSize = 1, sequenceName = "EL_POLICY_SEQ")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elPolicySeq")
	private int  policyId;
	@Column
	private String policyName;
	@Column
	private int durationOfPolicy;
	@Column
	private double premiumAmount;
	@Column
	private int policyvendorId;
	@Column
	private String policytype;
	@Column
	private double fineperday;
	
	public int getPolicyvendorId() {
		return policyvendorId;
	}
	public void setPolicyvendorId(int policyvendorId) {
		
		this.policyvendorId = policyvendorId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public int getDurationOfPolicy() {
		return durationOfPolicy;
	}
	public void setDurationOfPolicy(int durationOfPolicy) {
		this.durationOfPolicy = durationOfPolicy;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPolicytype() {
		return policytype;
	}
	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}
	public double getFineperday() {
		return fineperday;
	}
	public void setFineperday(double fineperday) {
		this.fineperday = fineperday;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", durationOfPolicy=" + durationOfPolicy
				+ ", premiumAmount=" + premiumAmount + ", policyvendorId=" + policyvendorId + ", policytype="
				+ policytype + ", fineperday=" + fineperday + "]";
	}
	
	
	


}
