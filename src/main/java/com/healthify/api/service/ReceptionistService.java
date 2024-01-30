package com.healthify.api.service;

import java.sql.Date;

import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.entity.DoctorsTimeOff;

@Transactional
public interface ReceptionistService {
	
	public DoctorsTimeOff checkDoctorTimeOff(String doctorName,Date date);

}
