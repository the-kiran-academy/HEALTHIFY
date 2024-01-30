package com.healthify.api.validation;

import java.util.Date;
import java.util.Map;

import com.healthify.api.entity.Medicine;

public class MedicineValidation {
	public static Map<String, String> map = null;

	public static Map<String, String> validateProduct(Medicine medicine) {

		if (medicine.getName().trim().equals("")) {
			map.put("Medicine Name", "Medicine Name Is Required");
		}

		if (medicine.getType().trim().equals("")) {
			map.put("Medicine Type", "Medicine Type Is Required");
		}
		if (medicine.getDistributorId().trim().equals("")) {

		}
		map.put("Distributor Id", "Medicine Distributor Id Is Required");

		if (medicine.getMedicineCompanyId().trim().equals("")) {
			map.put("Medicine Company Id", "Medicine Company Id");
		}

		if (medicine.getQuantity() <= 0) {
			map.put("Quentity", "Medicine Quentity Must Be Greater Than Zero(0)");
		}

		if (medicine.getPrice() <= 0) {
			map.put("Price", "Medicine Price Must Be Greater Than Zero(0)");
		}

		if (medicine.getManufactureDate() == null) {
			map.put("Manufacture Date", "Manufacture Date Should Be Not Empty");
		} else {
			if (medicine.getManufactureDate().after(new Date())) {
				map.put("Manufacture Date", "Manufacture Date Should Less Than Today");
			}
		}
		if (medicine.getExpiryDate() == null) {
			map.put("Expiry Date", "Expiry Date Should Be Not Empty");
		} else {
			if (medicine.getExpiryDate().after(medicine.getManufactureDate())) {
				map.put("Expiry Date", "Expity Date Should Greater Than Manufacture Date");
			}

		}
		return map;

	}

}
