package com.test.attendanceManagementProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.attendanceManagementProject.entity.UserDetail;
import com.test.attendanceManagementProject.repository.UserDetailRepository;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailRepository reposiotry;

	@Override
	public List<UserDetail> getAllUsers() {
		List<UserDetail> list = reposiotry.findAll();
		return list;
	}

	@Override
	public UserDetail findUserById(String username) {
		Optional<UserDetail> cId = reposiotry.findById(username);
		if (cId.isPresent()) {
			return cId.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteAllUser() {
		reposiotry.deleteAll();

	}

	@Override
	public void updateUser(UserDetail userdetail) {
		reposiotry.save(userdetail);

	}

	@Override
	public UserDetail addSingleUser(UserDetail userdetail) {
		return reposiotry.save(userdetail);
	}

	@Override
	public void deleteSingleUser(String username) {
		reposiotry.deleteById(username);

	}

	public UserDetail save(UserDetail user) {
		return reposiotry.save(user);
	}

	public UserDetail fetchUserByEmailId(String email) {
		return reposiotry.findByEmailId(email);
	}

	public UserDetail fetchUserByEmailIdAndPassword(String email, String password) {
		return reposiotry.findByEmailIdAndPassword(email, password);
	}
}
