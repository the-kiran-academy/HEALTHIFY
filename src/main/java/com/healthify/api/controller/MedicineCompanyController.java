package com.healthify.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import com.healthify.api.entity.MedicineCompany;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.service.MedicineCompanyService;
import org.springframework.http.ResponseEntity;
/**
 * @author RAM
 *
 */
@RestController
@RequestMapping(value = "/medicinecompany")
public class MedicineCompanyController {

	private static Logger LOG = LogManager.getLogger(MedicineCompanyController.class);

	@Autowired
	private MedicineCompanyService medicineCompanyService;

	@GetMapping("/add")
	public ResponseEntity<Object> addMedicineCompany(@RequestBody @Valid MedicineCompany medicineCompany) {

		try {
			MedicineCompany medicineCompanys = medicineCompanyService.addMedicineCompany(medicineCompany);
			LOG.info("MedicineCompany data: " + medicineCompanys);
			return ResponseEntity.ok("MedicineCompany data is added..");
		} catch (ResourceAlreadyExistsException e) {
			LOG.error("Failed to add medicine company: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Failed to add medicine company: " + e.getMessage());
		} catch (Exception e) {
			LOG.error("Bad request: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: " + e.getMessage());
		}
	}
}
