package com.test.attendanceManagementProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.test.attendanceManagementProject.entity.DepartmentDetail;
import com.test.attendanceManagementProject.repository.DepartmentRepository;



	@Service("departmentservice")
	public class DepartmentService {
		@Autowired
		DepartmentRepository departmentrepository;
			
		public ResponseEntity<DepartmentDetail> adddepartment(DepartmentDetail departmentdetail) {
			//System.out.println("HELLO"+departmentdetail.getDepartmentId());
			DepartmentDetail deptdetail = departmentrepository.findByDepartmentName(departmentdetail.getDepartmentName());
			if(deptdetail==null) {
			
				departmentrepository.save(departmentdetail);
			return ResponseEntity.status(HttpStatus.CREATED).body(deptdetail);
			}
			return null;
		}
			public List<DepartmentDetail> findalldepartment() {
				 List<DepartmentDetail> departmentList = (List<DepartmentDetail>) departmentrepository.findAll();

			        if (departmentList != null) {
			           return departmentList;
			        }

			       return null;
		}
	}


