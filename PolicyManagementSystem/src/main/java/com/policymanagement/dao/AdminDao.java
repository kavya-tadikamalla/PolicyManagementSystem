package com.policymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policymanagement.models.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	public Admin findByAdminId(int adminId);
}
