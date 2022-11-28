package com.test.attendanceManagementProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@Column(name = "username", length = 100)
	private String username;
	
	@Column(name = "emailId", unique = true)
	private String emailId;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
// ---------------------------

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String emailId, String password) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
