package com.test.attendanceManagementProject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "departmentdetail")
public class DepartmentDetail {

	@Id
	@Column(name = "departmentName")
	String departmentName;

	@Column(name = "noOfEmployee")
	int noOfEmployee;

	
// ---------------------------	
	
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public DepartmentDetail(int departmentId, String departmentName, int noOfEmployee, List<UserDetail> user) {
		super();
		this.departmentName = departmentName;
		this.noOfEmployee = noOfEmployee;
	}

	public DepartmentDetail() {
		super();
	}

}
