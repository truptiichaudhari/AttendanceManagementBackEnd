package com.test.attendanceManagementProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDetail {
	@Id
	@Column(name = "username", length = 100)
	private String username;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Column(name = "emailId", unique = true)
	private String emailId;

	@OneToOne
	@JoinColumn(name = "department", referencedColumnName = "departmentName", nullable = false)
	private DepartmentDetail department;

// ---------------------------

	public UserDetail() {
		super();
	}

	public UserDetail(String username, String password, String emailId, DepartmentDetail department) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.department = department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public DepartmentDetail getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDetail department) {
		this.department = department;
	}

}
