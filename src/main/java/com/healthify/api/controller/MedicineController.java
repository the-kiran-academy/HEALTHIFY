package com.healthify.api.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.healthify.api.entity.Medicine;
import com.healthify.api.service.MedicineService;

/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	private static Logger LOG = LogManager.getLogger(MedicineController.class);

	@PostMapping(value = "/add-medicine")
	public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {

		return null;
	}

	@GetMapping(value = "/get-medicine-by-name-ignorecase/{medicineName}")
	public ResponseEntity<List<Medicine>> findByNameContainingIgnoreCase(@PathVariable String medicineName) {
		return null;
	}

	@GetMapping(value = "/get-medicine-by-name/{medicineName}")
	public ResponseEntity<Medicine> getMedicineByName(@PathVariable String medicineName) {
		return null;
	}

	@GetMapping(value = "/get-medicines-with-quantity-more-than-zero/{quantity}")
	public ResponseEntity<List<Medicine>> getMedicinesWithQuantityMoreThanZero(@PathVariable int quantity) {
		return null;
	}

	// One API is pending

	@GetMapping(value = "/get-medicines-total-count")
	public ResponseEntity<Long> getMedicinesTotalCount() {
		return null;
	}

	@GetMapping(value = "/get-medicine-by-id/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable String id) {
		return null;
	}

	@GetMapping(value = "/get-all-medicine")
	public ResponseEntity<List<Medicine>> getAllMedicine() {
		return null;
	}

	@PostMapping(value = "/uploadSheet")
	public ResponseEntity<Map<String, Object>> uploadSheet(@RequestParam MultipartFile file) {
		return null;
	}
}
