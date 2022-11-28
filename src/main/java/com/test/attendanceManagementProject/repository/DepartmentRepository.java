package com.test.attendanceManagementProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test.attendanceManagementProject.entity.DepartmentDetail;




	
	@Repository
	public interface DepartmentRepository extends CrudRepository<DepartmentDetail, String> {

		
	   DepartmentDetail findByDepartmentName(String departmentName);
	   
	   List<DepartmentDetail> findAll();

      // void save(DepartmentDetail departmentdetail);
	 //  @Transactional
	 //  void deleteBydepartmentId(String departmentId);	

	}	

