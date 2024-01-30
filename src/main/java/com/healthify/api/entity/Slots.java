package com.healthify.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author RAM
 *
 */
@Entity
@Table(name = "slots")
public class Slots {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slotsId;

	@Column(nullable = false)
	private String startTime;

	@Column(nullable = false)
	private String endTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timeOffId")
    @JsonIgnore
    private DoctorsTimeOff doctorTimeOff;


	public Slots() {
		// TODO Auto-generated constructor stub
	}


	public long getSlotsId() {
		return slotsId;
	}


	public void setSlotsId(long slotsId) {
		this.slotsId = slotsId;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public DoctorsTimeOff getDoctorTimeOff() {
		return doctorTimeOff;
	}


	public void setDoctorTimeOff(DoctorsTimeOff doctorTimeOff) {
		this.doctorTimeOff = doctorTimeOff;
	}


	

	
}
