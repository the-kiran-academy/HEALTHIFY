package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Otp;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.security.CustomUserDetail;

@Repository
public class UserDaoImpl implements UserDao {
	private static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	
	public boolean addUser(User user) {
		
		Session session = sf.getCurrentSession();
		

		// Check for duplicate user ID before attempting to save the user
        User existingUserById = session.createQuery("FROM User WHERE UserName = :userId", User.class)
                .setParameter("userId", user.getUsername())
                .uniqueResult();

        if (existingUserById != null) {
            LOG.error("Error adding user due to duplicate user ID: {}", user.getUsername());
            throw new ResourceAlreadyExistsException("User with ID already exists: " + user.getUsername());
        }

        // Check for duplicate email ID before attempting to save the user
        User existingUserByEmail = session.createQuery("FROM User WHERE EmailId = :email", User.class)
                .setParameter("email", user.getEmailid())
                .uniqueResult();

        if (existingUserByEmail != null) {
            LOG.error("Error adding user due to duplicate email ID: {}", user.getEmailid());
            throw new ResourceAlreadyExistsException("User with email ID already exists: " + user.getEmailid());
        }

        // Check for duplicate mobile number before attempting to save the user
        User existingUserByMobile = session.createQuery("FROM User WHERE MobileNo = :mobileNumber", User.class)
                .setParameter("mobileNumber", user.getMobileno())
                .uniqueResult();

        if (existingUserByMobile != null) {
            LOG.error("Error adding user due to duplicate mobile number: {}", user.getMobileno());
            throw new ResourceAlreadyExistsException("User with mobile number already exists: " + user.getMobileno());
        }

        try {
           

        	  session.save(user);
              return true;
         
           
        } catch (Exception e) {
           
            LOG.error("Error adding user. Exception details: {}", e.getMessage(), e);
         // Rollback the transaction in case of an exception
            throw new RuntimeException("Error adding user", e);
           
        }
		
	}
	

	@Override
	public User loginUser(User user) {
		Session session = sf.getCurrentSession();
		User usr = null;
		try {
			usr = session.get(User.class, user.getUsername());
			boolean matches = passwordEncoder.matches(user.getPassword(), usr.getPassword());
			if (matches) {
				return usr;
			} else {
				usr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;

	}

	@Override
	public CustomUserDetail loadUserByUserId(String userId) {
		Session session = sf.getCurrentSession();
		CustomUserDetail user = new CustomUserDetail();
		User usr = null;
		try {
			usr = session.get(User.class, userId);
			if (usr != null) {
				user.setUserid(usr.getUsername());
				user.setPassword(usr.getPassword());
				user.setRoles(usr.getRoles());
			}
			System.out.println("load user ..." + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean deleteUserById(String id){
		Session session = sf.getCurrentSession();
		
		try {
	        User user = session.get(User.class, id);
	        
	        if (user != null) {
	            session.delete(user);
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserById(String id) {
		Session session = sf.getCurrentSession();
		User user = null;
		try {
			user = session.get(User.class, id);
		} catch (Exception e) {
			LOG.info(e.getMessage());

		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getUsersTotalCounts() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getUsersTotalCounts(String type) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getUserCountByDateAndType(Date registeredDate, String type) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveOtp(Otp otp) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Otp getOtpByUser(String userId) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role addRole(Role role) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role getRoleById(int roleId) {
		Session session = sf.getCurrentSession();
		Role role = null;
		try {
			role = session.get(Role.class, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

}
