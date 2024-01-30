package com.healthify.api.controller;

import javax.validation.Valid;

//Java Program to Create Rest Controller that

//Defines various API for Sending Mail

//Importing required classes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.model.EmailDetails;
import com.healthify.api.service.EmailPasswordService;

//Annotation
@RestController
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailPasswordService emailPasswordService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public boolean sendMail(@RequestBody @Valid EmailDetails details) {
		return false;
	}
	

}
