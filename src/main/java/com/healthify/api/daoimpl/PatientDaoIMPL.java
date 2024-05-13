package com.healthify.api.daoimpl;
import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;

/**
 * @author RAM
 *
 */
@Repository
@SuppressWarnings({ "deprecation", "unchecked" })
public class PatientDaoIMPL implements PatientDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Patient> findByFirstnameContainingIgnoreCase(String patientName) {

		Session session = sf.getCurrentSession();
		try 
		{

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getPatientsCount() {

		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getPatientsCountByDate(Date registeredDate) {
		
		 if (registeredDate == null) {
		        throw new IllegalArgumentException("Registered date cannot be null");
		    }
         Session sess = null;
		 try 
		 {
			Session session = sf.getCurrentSession();
			Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Patient WHERE registerDate = :registerDate", Long.class);
			query.setParameter("registerDate", registeredDate);
			Long Count = query.uniqueResult();
			 return Count != null ? Count : 0L; 
		 } 
		catch (HibernateException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while fetching patient count by date", e);
	    } finally {
	        if (sess != null && sess.isOpen()) {
	            sess.close(); 
	        }
	    }
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Patient addPatient(Patient patient) {

		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deletePatientById(String id) {

		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Patient getPatientById(String id) {

		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Patient updatePatient(Patient patient) {

		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getAllPatientsIds() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
