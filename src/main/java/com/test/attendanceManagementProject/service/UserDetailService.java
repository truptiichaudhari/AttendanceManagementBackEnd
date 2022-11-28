package com.test.attendanceManagementProject.service;

import java.util.List;

import com.test.attendanceManagementProject.entity.UserDetail;

public interface UserDetailService {

	public List<UserDetail> getAllUsers();
	UserDetail findUserById(String username);
	void deleteAllUser();
	void updateUser(UserDetail userdetail);
	UserDetail addSingleUser(UserDetail userdetail);
	void deleteSingleUser(String username);
}