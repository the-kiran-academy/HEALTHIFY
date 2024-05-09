package com.healthify.api.serviceimpl;

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
		return false;

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
		return medicineDao.getAllMedicine();
		
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
