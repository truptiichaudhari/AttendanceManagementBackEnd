package com.test.attendanceManagementProject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.attendanceManagementProject.entity.AttendanceDetail;
import com.test.attendanceManagementProject.entity.UserDetail;
import com.test.attendanceManagementProject.repository.AttendanceRepository;


@Transactional
@Service("attendanceservice")
public class AttendanceService {
	
	private AttendanceRepository attendancerepository;
	
	@Autowired
	public AttendanceService(AttendanceRepository attendancerepository) {
		super();
		this.attendancerepository = attendancerepository;
	}

	public ResponseEntity<String> addAttendance(AttendanceDetail attendence) {	
		try {	
			AttendanceDetail isAttendence = this.attendancerepository.findByUserAndDate(attendence.getUser(), attendence.getDate());
			if(isAttendence == null) {
				attendancerepository.save(attendence);
				return ResponseEntity.status(HttpStatus.OK).body("Attendence on " + attendence.getDate() + " has been marked successfully.");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendence is already marked for " + attendence.getDate() );
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "Failed to save the attendence." );
		}
	}
	
	public ResponseEntity<String> updateAttendence(AttendanceDetail attendence) {	
		try {	
			AttendanceDetail isAttendence = this.attendancerepository.findByUserAndDate(attendence.getUser(), attendence.getDate());
			if(isAttendence == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attendence is not valid to update." );
			}
			isAttendence.setDate(attendence.getDate());
			isAttendence.setIntime(attendence.getIntime());
			isAttendence.setOuttime(attendence.getOuttime());
			attendancerepository.save(isAttendence);
			return ResponseEntity.status(HttpStatus.OK).body("Attendence on " + attendence.getDate() + " has been updated successfully.");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( "Failed to save the attendence." );
		}
	}
	
	public ResponseEntity<String> deleteByid(int id) {
		try {
			AttendanceDetail attendenceDetain = attendancerepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("User is added successfully");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete attendence");
		}
	}
	
	public List<AttendanceDetail> getListOfAttendenceByUser(String username) {
		List<AttendanceDetail> attendanceList = attendancerepository.findAllByUserDetail(username);
		if (attendanceList != null) {
			return attendanceList;
		}
		return null;
	}

//	public List<AttendanceDetail> findAllUser() {
//		return (List<AttendanceDetail>) attendancerepository.findAll();
//		        
//	}
//
//	public List <AttendanceDetail> findByid(int id) {
//	List<AttendanceDetail> attendanceList =  attendancerepository.findById(id);
//        if (attendanceList != null) {
//            return attendanceList;
//        }
//        return null;
//  }
    
//	public AttendanceDetail findBydate(Date date) {
//		AttendanceDetail attendanceList = (AttendanceDetail) attendancerepository.findByDate(date);
//
//		if (attendanceList != null) {
//			return attendanceList;
//		}
//		return null;
//	}
//
//	public String updateUser(int id, Date date) {
//		AttendanceDetail attendanceList = (AttendanceDetail) attendancerepository.findByIdAndDate(id, date);
//		;
//		if (attendanceList != null) {
//
//			return "User updated Successfully";
//		}
//		return "User update Failed";
//	}

}

	
