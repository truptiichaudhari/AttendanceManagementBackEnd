package com.test.attendanceManagementProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.test.attendanceManagementProject.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
	public UserDetail findByEmailId(String emailId);
	public UserDetail findByEmailIdAndPassword(String emailId, String password);
}