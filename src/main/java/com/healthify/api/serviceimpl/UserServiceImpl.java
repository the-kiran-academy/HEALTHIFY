package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.security.CustomUserDetail;
import com.healthify.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao dao;

	@Value("${user.roles}")
	private String[] roles;

	@Override
	public boolean addUser(User user) 
	{
        Calendar calendar = Calendar.getInstance();
        java.util.Date utilDate = calendar.getTime();
      
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(utilDate);
        
        user.setCreatedDate(Date.valueOf(formattedDate));
        
        String encodepass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodepass);
        
        
		boolean addedUser = dao.addUser(user);
		return addedUser;

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

	@Override
	public Long getUserCountByDateAndType(java.sql.Date registeredDate, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
