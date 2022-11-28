package com.test.attendanceManagementProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.attendanceManagementProject.entity.Admin;
import com.test.attendanceManagementProject.repository.AdminRepository;



@Service
public class AdminServiceImpl {
    @Autowired
     private AdminRepository repo;



public Admin saveAdmin(Admin admin) {
     return repo.save(admin);
}
public ResponseEntity<Admin> getAdminDetail(Admin admin) {
	if (admin.getUsername() != null && admin.getPassword() != null) {
		Admin myadmin = repo.findByUsername(admin.getUsername());
		
		if (myadmin.getPassword().equals(admin.getPassword())) {
			return ResponseEntity.status(HttpStatus.OK).body(myadmin);
		}		
	} 
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(admin);
	
}
public Admin fetchUserByEmailIdAndPassword(String email, String password)
{
     return repo.findByEmailIdAndPassword(email, password);
}
}