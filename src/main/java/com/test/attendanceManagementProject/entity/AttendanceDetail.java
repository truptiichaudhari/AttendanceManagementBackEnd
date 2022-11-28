package com.test.attendanceManagementProject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "attendancedetail")
public class AttendanceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
	UserDetail user;

	private Date date;

	private String intime;

	private String outtime;

// ---------------------------
	public AttendanceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceDetail(int id, UserDetail user, Date date, String intime, String outtime) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.intime = intime;
		this.outtime = outtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

}
