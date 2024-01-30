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
		return medicineDao.deleteMedicineById(id);
	}

	@Override
	public Medicine getMedicineById(String id) {
		Medicine medicine = medicineDao.getMedicineById(id);

		return medicine;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		return medicineDao.updateMedicine(medicine);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return medicineDao.getAllMedicine();
	}

	@Override
	public List<Medicine> getMedicinesByName(String medicineName) {
		return medicineDao.findByNameContainingIgnoreCase(medicineName);
	}

	@Override
	public Medicine getMedicineByName(String medicineName) {
		return medicineDao.findByName(medicineName);
	}

	@Override
	public List<Medicine> getMedicinesWithQuantityMoreThanZero(int quantity) {
		return medicineDao.findByQuantityGreaterThan(quantity);
	}

	@Override
	public Long getCountOfMedicineByDateAdded(String dateAdded) {
		return medicineDao.countByDateAdded(dateAdded);
	}

	@Override
	public Long getMedicinesTotalCount() {
		return medicineDao.getTotalCount();
	}

	@Override
	public List<Medicine> getTop5MedicineAddedByDate(String date) {
		return medicineDao.findTop5ByIdDesc(date);
	}

	public List<Medicine> readExcel(String filePath) {
		List<Medicine> list=new ArrayList<>();
		return list;

	}

	@Override
	public Map<String, Object> uploadSheet(MultipartFile myFile) {
		
		return map;
	}

}
