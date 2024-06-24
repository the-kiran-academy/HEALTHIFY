package com.healthify.api.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthify.api.aop.TrackExecutionTime;
import com.healthify.api.entity.Role;
import com.healthify.api.entity.User;
import com.healthify.api.service.UserService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	private static Logger LOG = LogManager.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value= "/add-user", produces = "application/json")
	public ResponseEntity<Boolean> registerUser(@RequestBody @Valid User user) {
		return null;

	}

	@DeleteMapping(value = "/delete-user/{id}", produces = "application/json")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
		return null;
		
	}

	@PutMapping(value="/update-user", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return null;
		

	}

	@GetMapping(value = "get-all-user", produces = "application/json")
	@TrackExecutionTime
	public ResponseEntity<List<User>> getAllAdmin() {
		
		List<User> allUsers = userService.getAllUsers();
		
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@PostMapping(value = "/add-role", produces = "application/json")
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		return null;
		
	}

	@GetMapping(value = "/get-role-by-id/{roleId}", produces = "application/json")
	public ResponseEntity<Object> getRoleById(@PathVariable int roleId) {
		Role role=userService.getRoleById(roleId);
		if(role!=null) {
			return  ResponseEntity.of(Optional.of(role));
		}else {
			 String errorMessage = "Role with ID " + roleId + " not found";
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                 .body(errorMessage);
		 
		}
	}

	@GetMapping(value = "/get-total-count-of user", produces = "application/json")
	public ResponseEntity<Long> getUsersTotalCounts() {
		return null;
		
	}

	
	@GetMapping(value = "/get-total-count-of-user-by-type/{type}", produces = "application/json")
	public ResponseEntity<Long> getUsersTotalCountsByType(@PathVariable String type) {
		return null;
		
	}

	@GetMapping(value = "/get-total-count-of-user-by-date-and-type//{date}/{type}", produces = "application/json")
	public ResponseEntity<Long> getUserCountByDateAndType(@PathVariable Date date, @PathVariable String type) {
		return null;
		
	}

	@GetMapping(value = "/get-user-by-firtname/{firstName}", produces = "application/json")
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName) {
		return null;
		
	}

	@GetMapping(value = "/user/report", produces = "application/json")
	public String generateReport() {
		return null;


	}
	
	@GetMapping("/sample")
	public ResponseEntity<String> sample(){
		String msg=userService.sample();
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}

}
