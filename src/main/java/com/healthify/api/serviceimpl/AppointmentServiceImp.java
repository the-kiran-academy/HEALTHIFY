package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.AppointmentDao;
import com.healthify.api.dao.DoctorDao;
import com.healthify.api.entity.Appointment;
import com.healthify.api.service.AppointmentService;

/**
 * @author RAM
 *
 */
@Service()
public class AppointmentServiceImp implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private DoctorDao dao;

	@Override
	public int doctorAvailibilityChecker(String doctorId, Date date, String startTime, String endTime) {

		
		return 0;

		}
	
	@Override
	public int scheduleAppointment(Appointment appointment) {
		
		return 0;
		
	}

	private static boolean isOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
		return start1.isBefore(end2) && end1.isAfter(start2);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		
		return null;
	}

	@Override
	public Appointment getAppointmentById(String appointmentId) {
		Appointment appointment = appointmentDao.getAppointmentById(appointmentId);
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentsByPatientsIds(List<String> patientsId) {
		return null;

	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate) {
		return null;

	}

	@Override
	public List<Appointment> getAppointmentsByDoctorIdAndAppointmentDate(String doctorId, Date appointmentDate,
			String appointmentTime) {
		return null;

	}

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		List<Appointment> appointmentsByDate = appointmentDao.getAppointmentsByDate(date);
		return appointmentsByDate;
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;

	}

	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		List<Appointment> appointmentsByBillingDate = appointmentDao.getAppointmentsByBillingDate(billingDate);
		return appointmentsByBillingDate;
	}

	@Override
	public Long getAppointmentsTotalCount() {
		return null;

	}

	@Override
	public Long getCountByAppointmentTakenDate(Date appointmentTakenDate) {
		Long count = appointmentDao.getCountByAppointmentTakenDate(appointmentTakenDate);
		return count;
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;

	}

	@Override
	public List<Appointment> getAllAppointments() {
		return null;

	}

	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;

	}

	@Override
	public Appointment appointmentAvailibityChecker() {
		return null;

	}

}
