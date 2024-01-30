package com.healthify.api.controller;


import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.service.ReceptionistService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/receptionist")
public class ReceptionistController {

	@Autowired
	private ReceptionistService service;

	private static Logger log = LogManager.getLogger(ReceptionistController.class);

	@GetMapping(value = "/check-doctor-timeoff/{doctorUsername}/{date}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object checkDoctorTimeOff(@PathVariable String doctorUsername, @PathVariable Date date) {
		return null;

	}
	
	

}
