package com.healthify.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.service.UserService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static Logger LOG = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	
	


@GetMapping(value = "get-user-by-id/{id}", produces = "application/json")
public ResponseEntity<User> getUserById(@PathVariable String id) {
	User user = userService.getUserById(id);
	if (user != null) {
		return new ResponseEntity<User>(user, HttpStatus.OK);
	} else {
		throw new ResourceNotFoundException("User Not Found For ID : " + id);
	}
}}
