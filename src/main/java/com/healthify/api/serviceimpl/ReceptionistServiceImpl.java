package com.healthify.api.serviceimpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.ReceptionistDao;
import com.healthify.api.entity.DoctorsTimeOff;
import com.healthify.api.service.ReceptionistService;

/**
 * @author RAM
 *
 */
@Service
public class ReceptionistServiceImpl implements ReceptionistService {

	@Autowired
	private ReceptionistDao dao;
	
	@Override
	public DoctorsTimeOff checkDoctorTimeOff(String doctorName, Date date) {
		
		return dao.checkDoctorTimeOff(doctorName, date);
	}

}
