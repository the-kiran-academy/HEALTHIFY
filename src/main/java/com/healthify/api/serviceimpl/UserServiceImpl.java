package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.security.CustomUserDetail;
import com.healthify.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;

	@Override
	public boolean addUser(User user) {
		return false;

	}

	@Override
	public User loginUser(User user) {

		return dao.loginUser(user);
	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		return dao.loadUserByUserId(userId);
	}

	@Override
	public boolean deleteUserById(String id) {
		dao.deleteUserById(id);
		
		return false;
		
	}

	@Override
	public User getUserById(String id) {
		return null;
		
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> allUsers=dao.getAllUsers();
		
		if(allUsers.isEmpty())
		{
			throw new ResourceNotFoundException("Users Not found.");
		}

		return allUsers;
	}

	@Override
	public User updateUser(User user) {
		return null;

	}

	@Override
	public Long getUsersTotalCounts() {
		return null;
		
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return null;
		
	}

	@Override
	public Long getUserCountByDateAndType(Date registereddate, String type) {
		return null;
		
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return null;
		
	}

	@Override
	public Role addRole(Role role) {

		return null;

	}

	@Override
	public Role getRoleById(int roleId) {
		return null;

		
	}

	@Override
	public String generateReport() {
		return null;
		
	}

}
