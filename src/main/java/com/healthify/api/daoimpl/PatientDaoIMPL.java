package com.healthify.api.daoimpl;
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;
import com.healthify.api.exception.ResourceAlreadyExistsException;

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

		Session session = sf.getCurrentSession();
		try 
		{
			Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Patient WHERE registerDate = :registerDate", Long.class);
			query.setParameter("registerDate", registeredDate);
			Long Count = query.uniqueResult();
			return Count;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		 return 0l;
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
	@Transactional
	public Patient addPatient(Patient patient) {
	    
	    Session session=sf.getCurrentSession();	    
	    Query<Long> countQuery = session.createQuery(
	        "SELECT COUNT(p) FROM Patient p WHERE p.mobileNo = :mobileNo OR (p.firstName = :firstName AND p.lastName = :lastName)",
	        Long.class
	    );
	    countQuery.setParameter("mobileNo", patient.getMobileNo());
	    countQuery.setParameter("firstName", patient.getFirstName());
	    countQuery.setParameter("lastName", patient.getLastName());
	    
	    Long count = countQuery.uniqueResult();
	    
	    if (count > 0) {
	        throw new ResourceAlreadyExistsException("Patient with the same mobile number or name already exists");
	    }
	    
	    // Save the patient
	    session.save(patient);
	    
	    return patient;
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
