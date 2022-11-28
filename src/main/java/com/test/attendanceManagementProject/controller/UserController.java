package com.test.attendanceManagementProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.test.attendanceManagementProject.entity.UserDetail;
import com.test.attendanceManagementProject.service.UserDetailServiceImpl;

import ExceptionHandler.IdNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserDetailServiceImpl userservice;

	@GetMapping("/getListOfUsers")
	public List<UserDetail> findAllUsers() {
		return (List<UserDetail>) userservice.getAllUsers();
	}

	@GetMapping("user/{username}")
	public UserDetail getUserById(@PathVariable String username) throws IdNotFoundException {
		UserDetail uId = userservice.findUserById(username);
		if (uId != null) {
			return uId;
		} else {
			throw new IdNotFoundException("Id not found");
		}
	}

	@PostMapping("/adduser")
	ResponseEntity<String> addsingleComment(@RequestBody UserDetail user) {
		try {
			userservice.addSingleUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("User is added successfully");
		} catch (Exception e) {
			System.out.println("register user error : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already exist");
		}
	}

//	@DeleteMapping("/deleteuser/{username}")
//	ResponseEntity<String> deletesingleUser(@PathVariable String username) {
//		userservice.deleteSingleUser(username);
//		return ResponseEntity.ok("Record Deleted");
//	}
//
//	@PutMapping("/updateuser/{username}")
//	public ResponseEntity<String> updateUser(@RequestBody UserDetail user, @PathVariable String username) {
//		UserDetail uid = userservice.findUserById(username);
//		uid.setEmailId(user.getEmailId());
//		uid.setPassword(user.getPassword());
//		uid.setUsername(user.getUsername());
//
//		userservice.updateUser(uid);
//
//		return ResponseEntity.ok("Record Updated");
//	}
//
//	@DeleteMapping("/deleteall/users")
//	public ResponseEntity<String> deleteAllComments() {
//		userservice.deleteAllUser();
//		return new ResponseEntity<String>("All record deleted", null, 200);
//	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserDetail loginUser(@RequestBody UserDetail user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		UserDetail userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = userservice.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);

		}
		if (userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}

	@PostMapping("/admin")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserDetail loginUser1(@RequestBody UserDetail user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		UserDetail userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = userservice.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);

		}
		if (userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
}
