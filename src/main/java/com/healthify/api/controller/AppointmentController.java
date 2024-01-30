package com.healthify.api.controller;

import java.sql.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Appointment;
import com.healthify.api.service.AppointmentService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;

	private static Logger LOG = LogManager.getLogger(AppointmentController.class);

		@GetMapping(value = "check-doctor-availibility", produces = "application/json")
		public ResponseEntity<String> doctorAvailibilityChecker(@RequestParam String doctorId, @RequestParam Date date,
				@RequestParam String startTime, @RequestParam String endTime) {
					
			return null;
	}

	@PostMapping(value = "/schedule-appointment", produces = "application/json")
	public ResponseEntity<String> scheduleAppointment(@RequestBody Appointment appointment) {
		return null;
		
	}

	@PutMapping(value = "/update-appointment", produces = "application/json")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-id/{id}", produces = "application/json")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-ids/{ids}", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAppointmentsByPatientsIds(@PathVariable List<String> ids) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-drid-apointmentdate/{drid}/{date}", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@PathVariable String drid,
			@PathVariable Date date) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-drid-and-apointmentdate-and-time", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorIdAndAppointmentDate(@RequestParam String doctorId,
			@RequestParam Date appointmentDate, @RequestParam String appointmentTime) {
		return null;
	}

	@GetMapping(value = "/get-appointment-by-apointmentdate", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAppointmentsByDate(@RequestParam Date appointmentDate) {
		return null;
	}

	@GetMapping(value = "/get-count-by-appointment-date", produces = "application/json")
	public ResponseEntity<Long> getCountByAppointmentDate(@RequestParam Date date) {
		Long count = service.getCountByAppointmentDate(date);
		return null;
	}

	@GetMapping(value = "/get-appointment-by-billingdate", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAppointmentsByBillingDate(@RequestParam Date billingDate) {
		return null;
	}

	@GetMapping(value = "/get-count-of-appointments", produces = "application/json")
	public ResponseEntity<Long> getAppointmentsTotalCount() {
		return null;
	}

	@GetMapping(value = "/get-count-by-appointmenttaken-date", produces = "application/json")
	public ResponseEntity<Long> getCountByAppointmentTakenDate(@RequestParam Date appointmentTakenDate) {
		return null;
	}

	@GetMapping(value = "/get-count-by-treatmentstatus-and billingdate", produces = "application/json")
	public ResponseEntity<Long> getCountByTreatmentStatusAndBillingDate(@RequestParam String treatmentStatus,
			@RequestParam Date billingDate) {
		return null;
	}

	@GetMapping(value = "/get-all-appointments", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		return null;
	}

	@GetMapping(value = "/get-top5-appointments", produces = "application/json")
	public ResponseEntity<List<Appointment>> getTop5AppointmentsByDate(@RequestParam Date date) {
		return null;
	}
}
