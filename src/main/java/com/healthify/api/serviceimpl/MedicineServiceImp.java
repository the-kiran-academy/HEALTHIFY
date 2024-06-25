package com.healthify.api.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.healthify.api.dao.MedicineDao;
import com.healthify.api.entity.Medicine;
import com.healthify.api.service.MedicineService;

/**
 * @author RAM
 *
 */
@Service
public class MedicineServiceImp implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	String excludedRows = "";
	int totalRecordCount = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, String> validatedError = new HashMap<String, String>();
	Map<Integer, Map<String, String>> errorMap = new HashMap<Integer, Map<String, String>>();

	@Override
	public boolean addMedicine(Medicine medicine) {
		try {
//	        LocalDate today = LocalDate.now();
//
//	        LocalDate manufactureDate = medicine.getManufactureDate().toLocalDate();
//	        LocalDate expiryDate = medicine.getExpiryDate().toLocalDate();
//
//	        if (manufactureDate.isAfter(today) || expiryDate.isBefore(today)) {
//	            return false;
//	        }else {

	        // 13 Digit Timestamp
	        long currentTimeMillis = System.currentTimeMillis();
	        // 17 Digit timestamp - called a separate method here
	        String id = generate17DigitTimeStamp(currentTimeMillis);
	        medicine.setId(id);

	        // Set the current date as the medicine added date
	        medicine.setMedicineAddedDateInStock(new Date(currentTimeMillis));

	        return medicineDao.addMedicine(medicine);
//	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }

	}
	
	private String generate17DigitTimeStamp(long currentTimeMillis) {
		int randomNumber = (int) ((Math.random()*9000)+1000);
		return String.format("%013d%04d",currentTimeMillis, randomNumber);
	}

	@Override
	public boolean deleteMedicineById(String id) {
		return false;
		
	}

	@Override
	public Medicine getMedicineById(String id) {
		return null;
		
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		return medicine;
		
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return null;
		
	}

	@Override
	public List<Medicine> getMedicinesByName(String medicineName) {
		return null;
		
	}

	@Override
	public Medicine getMedicineByName(String medicineName) {
		return null;
		
	}

	@Override
	public List<Medicine> getMedicinesWithQuantityMoreThanZero(int quantity) {
		return null;
		
	}

	@Override
	public Long getCountOfMedicineByDateAdded(String dateAdded) {
		return null;
		
	}

	@Override
	public Long getMedicinesTotalCount() {
		return null;
		
	}

	@Override
	public List<Medicine> getTop5MedicineAddedByDate(String date) {
		return null;
		
	}

	public List<Medicine> readExcel(String filePath) {
		return null;
		

	}

	@Override
	public Map<String, Object> uploadSheet(MultipartFile myFile) {
		return map;
		
	}

}
