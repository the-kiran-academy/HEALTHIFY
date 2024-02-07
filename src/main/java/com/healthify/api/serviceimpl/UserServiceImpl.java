package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.InvalidCredentialsException;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.security.CustomUserDetail;
import com.healthify.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;

	@Value("${user.roles}")
	private String[] roles;

	@Override

	public boolean addUser(User user) {
		
		
		
		 
			String password = user.getPassword();
			
			user.setPassword(passwordEncoder.encode(password));
			
			 user.setCreatedDate(Date.valueOf(LocalDate.now()));
			 
			  // Handle the specialties association
	            if (user.getSpecialties() != null) {
	                user.getSpecialties().forEach(specialty -> {
	                    specialty.setUser(user);
	                });
	            } 
			
		
		
		
		 boolean isAdded = dao.addUser(user);

	        if (isAdded) {
	            LOG.info("User added successfully: {}", user.getUsername());
	            // Additional logic for success, if needed
	            return true;
	        } else {
	            LOG.error("Failed to add user: {}", user.getUsername());
	            // Additional logic for failure, if needed
	            return false;
	        }
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
		return dao.deleteUserById(id);
	}

	@Override
	public User getUserById(String id) {
		User user = dao.getUserById(id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		return null;

	}

	@Override
	public User updateUser(User user) {
		return null;

	}

	@Override
	public Long getUsersTotalCounts() {
		return dao.getUsersTotalCounts();
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		return dao.getUsersTotalCounts(type);
	}

	@Override
	public Long getUserCountByDateAndType(Date registereddate, String type) {
		return dao.getUserCountByDateAndType(registereddate, type);
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		return dao.getUserByFirstName(firstName);
	}

	@Override
	public Role addRole(Role role) {

		return null;

	}

	@Override
	public Role getRoleById(int roleId) {

		return dao.getRoleById(roleId);
	}

	@Override
	public String generateReport() {
		
		return "generated";
	}

}
