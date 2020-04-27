package com.policymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policymanagement.models.PolicyVendor;

@Repository
public interface PolicyVendorDao extends JpaRepository<PolicyVendor, Integer>{
	public PolicyVendor findByVendorId(int vendorId);
	@Query("select max(vendorId) from PolicyVendor")
	public Integer nextvendoId();
	
}
