package com.healthify.api.dao;

import java.sql.Date;

import com.healthify.api.entity.DoctorsTimeOff;

public interface ReceptionistDao {
	public DoctorsTimeOff checkDoctorTimeOff(String doctorName, Date date);
}
