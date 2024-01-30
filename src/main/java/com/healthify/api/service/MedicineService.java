package com.healthify.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.healthify.api.entity.Medicine;

/**
 * @author RAM
 *
 */
@Transactional
public interface MedicineService {
	boolean addMedicine(Medicine medicine);

	public Map<String, Object> uploadSheet(MultipartFile file);

	boolean deleteMedicineById(String id);

	Medicine getMedicineById(String id);

	Medicine updateMedicine(Medicine medicine);

	List<Medicine> getAllMedicine();

	List<Medicine> getMedicinesByName(String medicineName);

	Medicine getMedicineByName(String medicineName);

	List<Medicine> getMedicinesWithQuantityMoreThanZero(int quantity);

	Long getCountOfMedicineByDateAdded(String dateAdded);

	Long getMedicinesTotalCount();

	List<Medicine> getTop5MedicineAddedByDate(String date);
}
