package com.test.attendanceManagementProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.attendanceManagementProject.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	public Admin findByUsername(String username);
    public Admin findByEmailId(String adminEmailId);
    public Admin findByEmailIdAndPassword(String adminEmailId, String adminPassword);
}