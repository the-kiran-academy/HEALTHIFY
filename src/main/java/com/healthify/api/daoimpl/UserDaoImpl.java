package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.UserDao;
import com.healthify.api.entity.Otp;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.Specialty;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.exception.SomethingWentWrongException;
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
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	public boolean deleteUserById(String id) {
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

		try (Session session = sf.openSession()) {
			User existingUser = session.get(User.class, user.getUsername());

			if (existingUser != null) {

				User newUpdateUser = new User();
				newUpdateUser.setUsername(user.getUsername());
				newUpdateUser.setFirstname(user.getFirstname());
				newUpdateUser.setLastname(user.getLastname());
				newUpdateUser.setEmailid(user.getEmailid());

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encryptedPassword = passwordEncoder.encode(user.getPassword());

				newUpdateUser.setPassword(encryptedPassword);

				newUpdateUser.setMobileno(user.getMobileno());
				newUpdateUser.setStreet(user.getStreet());
				newUpdateUser.setCity(user.getCity());
				newUpdateUser.setPincode(user.getPincode());
				newUpdateUser.setQuestion(user.getQuestion());
				newUpdateUser.setAnswer(user.getAnswer());
				newUpdateUser.setCreatedDate(user.getCreatedDate());

				Set<Role> updatedRoles = new HashSet<>();
				for (Role role : user.getRoles()) {

					Role dbRole = session.get(Role.class, role.getId());

					if (dbRole == null) {
						throw new ResourceNotFoundException("Role with ID " + role.getId() + " not found for update.");
					}
					updatedRoles.add(dbRole);
				}
				newUpdateUser.setRoles(updatedRoles);

				Set<Specialty> updatedSpecialties = new HashSet<>();
				for (Specialty specialty : user.getSpecialties()) {
					Specialty dbSpecialty = session.get(Specialty.class, specialty.getId());
					if (dbSpecialty == null) {
						throw new ResourceNotFoundException(
								"Specialty with ID " + specialty.getId() + " not found for update.");
					}
					updatedSpecialties.add(dbSpecialty);
				}
				newUpdateUser.setSpecialties(updatedSpecialties);

				Transaction transaction = session.beginTransaction();

				session.merge(newUpdateUser);
				transaction.commit();

				return newUpdateUser;
			} else {
				throw new ResourceNotFoundException("User not found for update.");
			}
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong during updating user.");
		}
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
