package com.test.attendanceManagementProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.test.attendanceManagementProject.entity.Admin;
import com.test.attendanceManagementProject.entity.AttendanceDetail;
import com.test.attendanceManagementProject.service.AdminServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {

	@Autowired
	private AdminServiceImpl adminservice;

	@PostMapping("/adminLogin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) throws Exception {
		return adminservice.getAdminDetail(admin);
	}
	
	@PostMapping(path = "/registerAdmin")
	@ResponseBody
	public Admin registerAdmin(@RequestBody Admin admin) {
		return adminservice.saveAdmin(admin);
	}
}
