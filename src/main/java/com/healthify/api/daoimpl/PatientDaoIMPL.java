package com.healthify.api.daoimpl;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;
import com.healthify.api.exception.ResourceNotFoundException;

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
	    public Long getPatientsCountByDate(Date registerDate) {
	        Session session =sf.getCurrentSession();
	        try {
	            org.hibernate.Criteria criteria = session.createCriteria(Patient.class);
	            criteria.add(Restrictions.eq("registerDate", registerDate));
	            criteria.setProjection(Projections.rowCount());     //to retrieve the count of results.
	            Long count=(Long) criteria.uniqueResult();          //to get the count of patients.
	            
	            if (count == null) {
	                throw new ResourceNotFoundException("No patients found registered on: " + registerDate);
	            }
	            
	            return count;
	        } catch (Exception e) {
	            throw new RuntimeException("Error while retrieving patients count by date", e);
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
