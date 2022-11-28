package com.test.attendanceManagementProject.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.attendanceManagementProject.entity.AttendanceDetail;
import com.test.attendanceManagementProject.entity.UserDetail;
@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceDetail, Integer>{

	//List<AttendanceDetail> addAllUser();
	
//	List<AttendanceDetail> findById(int id);
	
	 
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM attendancedetail WHERE username = :username ORDER BY date " , nativeQuery = true)
	List<AttendanceDetail> findAllByUserDetail(@Param("username") String username);
	
//	AttendanceDetail[] findByDepartmentid(int deptid);
	
//	AttendanceDetail[] findAllByUserDetails_username(String username);
	
//	@Transactional
//	@Modifying
//	@Query(value="SELECT * FROM attendancedetail WHERE username = :username AND date=:date ORDER BY date " , nativeQuery = true)
//	AttendanceDetail findByUsernameAndDate(String username, Date date);
	
	AttendanceDetail findByDate(Date date);

	AttendanceDetail findByIdAndDate(int id, Date date);

	AttendanceDetail deleteById(int id);


	AttendanceDetail findByUserAndDate(UserDetail user, Date date);

	

	

	
	
}
