package com.healthify.api.daoimpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.AppointmentDao;
import com.healthify.api.entity.Appointment;
import com.healthify.api.entity.DoctorsTimeOff;
import com.healthify.api.entity.Slots;

/**
 * @author RAM
 *
 */
@Repository
public class AppointmentDaoIMPL implements AppointmentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public int scheduleAppointment(Appointment appointment) {
		return 0;
		
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return null;
	}

	@Override
	public Appointment getAppointmentById(String patientId) {
		return null;
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
		return null;
	}

	@Override
	public Long getCountByAppointmentDate(Date appointmentDate) {
		return null;
	}

	@Override
	public List<Appointment> getAppointmentsByBillingDate(Date billingDate) {
		return null;
	}

	@Override
	public Long getAppointmentsTotalCount() {
		return null;
	}

	@Override
	public Long getCountByAppointmentTakenDate(Date appointmentTakenDate) {
		return null;
		
	}

	@Override
	public Long getCountByTreatmentStatusAndBillingDate(String treatmentStatus, Date billingDate) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAllAppointments() {
		return null;
	}

	@Override
	public List<Appointment> getTop5AppointmentsByDate(Date date) {
		return null;
	}
	
	@Override
	public int doctorAvailibilityChecker(String doctorId, Date date, String timeFrom, String timeTo) {
	    Session session = sf.openSession();
	    try {
	        // Check for conflicting appointments
	        Criteria appointmentCriteria = session.createCriteria(Appointment.class);
	        appointmentCriteria.add(Restrictions.eq("doctorId", doctorId));
	        appointmentCriteria.add(Restrictions.eq("appointmentDate", date));
	        appointmentCriteria.add(Restrictions.or(
	            Restrictions.and(
	                Restrictions.le("appointmentStartTime", timeFrom),
	                Restrictions.ge("appointmentEndTime", timeFrom)
	            ),
	            Restrictions.and(
	                Restrictions.le("appointmentStartTime", timeTo),
	                Restrictions.ge("appointmentEndTime", timeTo)
	            ),
	            Restrictions.and(
	                Restrictions.ge("appointmentStartTime", timeFrom),
	                Restrictions.le("appointmentEndTime", timeTo)
	            )
	        ));

	        List<Appointment> conflictingAppointments = appointmentCriteria.list();
	        boolean isAnySlotAvailable = false;

	        // Check if there are any available slots within the specified time range
	        if (conflictingAppointments != null && !conflictingAppointments.isEmpty()) {
	            for (Appointment appointment : conflictingAppointments) {
	                // Check if there is a gap between appointments
	                if (appointment.getAppointmentStartTime().compareTo(timeFrom) > 0) {
	                    isAnySlotAvailable = true;
	                    break;
	                }
	                timeFrom = appointment.getAppointmentEndTime(); // Update the start time
	            }
	        } else {
	            isAnySlotAvailable = true; // No conflicting appointments, all slots available
	        }

	        // Check doctor's time off
	        Criteria timeOffCriteria = session.createCriteria(DoctorsTimeOff.class);
	        timeOffCriteria.add(Restrictions.eq("doctorUserame", doctorId));
	        timeOffCriteria.add(Restrictions.eq("timeOffDate", date));
	        List<DoctorsTimeOff> doctorsTimeOffList = timeOffCriteria.list();

	        // Check if any time off slots overlap with the requested time range
	        for (DoctorsTimeOff timeOff : doctorsTimeOffList) {
	            if (timeOff.getDayOff()) {
	                return 2; // Doctor is on a day off
	            }
	            if (timeOff.getUnavailableTimeSlots() != null) {
	                for (Slots slot : timeOff.getUnavailableTimeSlots()) {
	                    if ((slot.getStartTime().compareTo(timeFrom) <= 0 && slot.getEndTime().compareTo(timeFrom) >= 0) ||
	                        (slot.getStartTime().compareTo(timeTo) <= 0 && slot.getEndTime().compareTo(timeTo) >= 0) ||
	                        (slot.getStartTime().compareTo(timeFrom) >= 0 && slot.getEndTime().compareTo(timeTo) <= 0)) {
	                        return 3; // Doctor has a time off slot during the requested time
	                    }
	                }
	            }
	        }

	        return isAnySlotAvailable ? 0 : 1; // Return 0 if any slot is available, otherwise 1
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1; // Error occurred
	    } finally {
	        session.close();
	    }
	}



}
