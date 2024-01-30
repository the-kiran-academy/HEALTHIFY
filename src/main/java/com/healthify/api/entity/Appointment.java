package com.healthify.api.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 *
 */
@Entity
public class Appointment {
	@Id
	@Column(name = "AppointmentPatientId")
	private String appointmentpatientid;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]+[a-zA-Z0-9]*$", message = "First name not valid")
	@Column(nullable = false)
	private String firstName;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]+[a-zA-Z0-9]*$", message = "Last name valid")
	@Column(nullable = false)
	private String lastName;
	
	
	@Column(nullable = false)
	private String gender;
	
	@Size(min = 10, max = 10, message = "Mobile Number Should Be 10 Digit")
	@Pattern(regexp = "^[0-9]+$", message = "Invalid Mobile Number")
	@Column(nullable = false)
	private String phone;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]+[a-zA-Z0-9]*$", message = "City not valid")
	@Column(nullable = false)
	private String address;
	
	@Email(message = "Mail not valid")
	private String email;
	
	@Column(nullable = false)
	private boolean appliedBefore;
	
	@NotBlank(message = "Appointment reason is required")
	@Column(nullable = false)
	private String appointmentReason;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bithdate;
	
	@NotNull(message ="DoctorId Is Required")
	private String doctorId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date appointmentTakenDate;
	
	@Column(name = "AppointmentTakenTime")
	private String appointmentTakenTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "AppointmentDate Is Requird")
	private Date appointmentDate;
	
	@NotNull(message = "AppointmentTime Is Requird")
	private String appointmentStartTime;
	
	@NotNull(message = "AppointmentTime Is Requird")
	private String appointmentEndTime;
	
	@NotNull(message = "ProblemDescription Is Requird")
	private String problemdescription;
	
	
	public Appointment() {
		
	}


	public String getAppointmentpatientid() {
		return appointmentpatientid;
	}


	public void setAppointmentpatientid(String appointmentpatientid) {
		this.appointmentpatientid = appointmentpatientid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAppliedBefore() {
		return appliedBefore;
	}


	public void setAppliedBefore(boolean appliedBefore) {
		this.appliedBefore = appliedBefore;
	}


	public String getAppointmentReason() {
		return appointmentReason;
	}


	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}


	public Date getBithdate() {
		return bithdate;
	}


	public void setBithdate(Date bithdate) {
		this.bithdate = bithdate;
	}


	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}


	public Date getAppointmentTakenDate() {
		return appointmentTakenDate;
	}


	public void setAppointmentTakenDate(Date appointmentTakenDate) {
		this.appointmentTakenDate = appointmentTakenDate;
	}


	public String getAppointmentTakenTime() {
		return appointmentTakenTime;
	}


	public void setAppointmentTakenTime(String appointmentTakenTime) {
		this.appointmentTakenTime = appointmentTakenTime;
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}


	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}


	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}


	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}


	public String getProblemdescription() {
		return problemdescription;
	}


	public void setProblemdescription(String problemdescription) {
		this.problemdescription = problemdescription;
	}
	
	
}
