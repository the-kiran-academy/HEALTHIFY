package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthify.api.dao.DoctorDao;
import com.healthify.api.entity.DoctorsTimeOff;
import com.healthify.api.service.DoctorService;
/**
 * @author RAM
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao dao;

	@Override
	public int setTimeOff(DoctorsTimeOff doctorsTimeOff) {

		return 0;

	}
	
	@Override
	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername, Date date) {
		return dao.getDoctorTimeOff(doctorUsername, date);
	}

	@Override
	public List<DoctorsTimeOff> getDoctorTimeOff(String doctorUsername) {
		
		return dao.getDoctorTimeOff(doctorUsername);
	}

	

	

}
