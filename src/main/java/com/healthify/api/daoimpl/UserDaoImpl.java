package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Otp;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.exception.SomethingWentWrongException;
import com.healthify.api.security.CustomUserDetail;


@Repository
public class UserDaoImpl implements UserDao {
	private static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	String resourceExistError = "Resource already Exists";

	@Override
	public boolean addUser(User user) {
		Session session = sf.openSession();
		try 
		{
			List<User> list1 = getSupplierByUniqueFields(user.getUsername(),user.getEmailid(),user.getMobileno());
			if(list1.isEmpty())
			{
				session.save(user);
				session.beginTransaction().commit();
				return true;
			}
		}
		catch (RollbackException e)
		{
			throw new ResourceAlreadyExistsException(resourceExistError);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong While Adding User");
		}
		return false;
	}
	
	public List<User> getSupplierByUniqueFields(String username,String emailid,String mobileno)
	{
		Session session = sf.openSession();
		List list = null;
		try 
		{
			Criteria criteria = session.createCriteria(User.class);
			Criterion uname = Restrictions.eq("username", username);//temp
			Criterion eid = Restrictions.eq("emailid", emailid);
			Criterion mobile = Restrictions.eq("mobileno", mobileno);
			
			criteria.add(Restrictions.or(uname,eid,mobile));
			list = criteria.list();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong While Adding Product");
		}
		return list;
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
