package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.PatientDao;
import com.healthify.api.entity.Patient;
import com.healthify.api.service.PatientService;

/**
 * @author RAM
 *
 */
@Service
public class PatientServiceImp implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public Patient addPatient(Patient patient) {
		return null;

	}

	@Override
	public boolean deletePatientById(String id) {
		return patientDao.deletePatientById(id);
	}

	@Override
	public Patient getPatientById(String id) {
		Patient patient = patientDao.getPatientById(id);
		return patient;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}

	@Override
	public List<Patient> findByFirstnameContainingIgnoreCase(String patientname) {
		return patientDao.findByFirstnameContainingIgnoreCase(patientname);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDao.getAllPatients();
	}

	@Override
	public Long getPatientsCount() {
		return patientDao.getPatientsCount();
	}

	@Override
	public Long getPatientsCountByDate(Date registerDate) {
		return patientDao.getPatientsCountByDate(registerDate);
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		return patientDao.getTop5PatientAddedByDate();
	}

	@Override
	public List<String> getAllPatientsIds() {
		return patientDao.getAllPatientsIds();
	}

}
