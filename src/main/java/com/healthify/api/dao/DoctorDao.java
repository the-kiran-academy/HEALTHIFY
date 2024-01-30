package com.healthify.api.dao;

import java.sql.Date;
import java.util.List;

import com.healthify.api.entity.DoctorsTimeOff;

public interface DoctorDao {

	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername);
	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername, Date Date);
	public int setTimeOff (DoctorsTimeOff doctorsTimeOff);

}
