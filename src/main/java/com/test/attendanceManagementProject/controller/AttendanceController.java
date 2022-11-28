package com.test.attendanceManagementProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.attendanceManagementProject.entity.AttendanceDetail;
import com.test.attendanceManagementProject.entity.UserDetail;
import com.test.attendanceManagementProject.service.AttendanceService;

@RestController
//@RequestMapping(path="/attendancedetail")
@CrossOrigin(origins = "http://localhost:4200")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceservice;

	// add 1 user
	@PostMapping(path = "/addAttendence")
	public ResponseEntity<String>  addAttendence(@RequestBody AttendanceDetail attendancedetail) {
		return attendanceservice.addAttendance(attendancedetail);
	}
	
	@PutMapping(path = "/updateAttendence")
	public ResponseEntity<String>  updateAttendence(@RequestBody AttendanceDetail attendancedetail) {
		return attendanceservice.updateAttendence(attendancedetail);
	}
	
	@DeleteMapping(path = "/deleteUserAttendence/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable int id) {
		return attendanceservice.deleteByid(id);
	}
	
	@GetMapping(path = "/getAttendanceDetail/{username}")
	public List<AttendanceDetail> getListOfAttendenceByUserController(@PathVariable String username) {
		return attendanceservice.getListOfAttendenceByUser(username);
	}

//	// add more than 1 user
//	@GetMapping(path = "/findAlluser")
//	public List<AttendanceDetail> findAllUser() {
//		return attendanceservice.findAllUser();
//	}
//
//	@GetMapping(path = "/findByid/{id}")
//	public List<AttendanceDetail> findByid(@PathVariable int id) {
//		return attendanceservice.findByid(id);
//	}
//
//
//	@GetMapping(path = "/findBydate/{date}")
//	public AttendanceDetail findByDate(@PathVariable Date date) {
//		return attendanceservice.findBydate(date);
//	}
//
//	@PutMapping(path = "/updateUser/{id}/{date}")
//	public String updateUser(@PathVariable int id, Date date) {
//		return attendanceservice.updateUser(id, date);
//	}

}
