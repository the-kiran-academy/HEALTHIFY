package com.healthify.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.healthify.api.entity.DoctorsTimeOff;

/**
 * @author RAM
 *
 */
@Transactional
public interface DoctorService {

	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername);

	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername, Date Date);

	public int setTimeOff(DoctorsTimeOff doctorsTimeOff);

}
