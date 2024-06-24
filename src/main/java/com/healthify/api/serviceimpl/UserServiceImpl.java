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
import com.healthify.api.exception.UserNotFoundException;
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
		User user1 = dao.findByUsername(user.getUsername());
        if (user1 == null) {
            throw new UserNotFoundException("Username not found");
        }

        if (user.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user1.setPassword(encodedPassword);
        }
        if (user.getEmailid() != null) {
            user1.setEmailid(user.getEmailid());
        }
        if (user.getFirstname() != null) {
            user1.setFirstname(user.getFirstname());
        }
        if (user.getLastname() != null) {
            user1.setLastname(user.getLastname());
        }
        if (user.getMobileno() != null) {
            user1.setMobileno(user.getMobileno());
        }
        if (user.getStreet() != null) {
            user1.setStreet(user.getStreet());
        }
        if (user.getCity() != null) {
            user1.setCity(user.getCity());
        }
        if (user.getPincode() != null) {
            user1.setPincode(user.getPincode());
        }
        if (user.getQuestion() != null) {
            user1.setQuestion(user.getQuestion());
        }
        if (user.getAnswer() != null) {
            user1.setAnswer(user.getAnswer());
        }
        if (user.getSpecialties() != null) {
            user1.setSpecialties(user.getSpecialties());
        }
        if (user.getRoles() != null) {
            user1.setRoles(user.getRoles());
        }
        if(user.getCreatedDate() != null) {
        	user1.setCreatedDate(user.getCreatedDate());
        }
        return dao.updateUser(user1);
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
