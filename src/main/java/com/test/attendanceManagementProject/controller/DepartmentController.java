package com.test.attendanceManagementProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.attendanceManagementProject.entity.DepartmentDetail;
import com.test.attendanceManagementProject.service.DepartmentService;

@Controller
//@RequestMapping(path = "/departmentdetail")
@CrossOrigin(origins = "http://localhost:4200")

public class DepartmentController {

	@Autowired
	DepartmentService departmentservice;

	@PostMapping(path = "/adddepartment")
	@CrossOrigin
	@ResponseBody
	public ResponseEntity<String> adddepartment(@RequestBody DepartmentDetail departmentdetail) {
		return departmentservice.adddepartment(departmentdetail);
	}

	@GetMapping(path = "/findalldepartment")
	@CrossOrigin
	@ResponseBody
	public List<DepartmentDetail> findalldepartment() {
		return departmentservice.findalldepartment();
	}
}
