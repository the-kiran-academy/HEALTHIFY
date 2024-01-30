package com.healthify.api.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.MedicineCompanyDao;
import com.healthify.api.entity.MedicineCompany;
import com.healthify.api.service.MedicineCompanyService;

/**
 * @author RAM
 *
 */
@Service
public class MedicineCompanyServiceImp implements MedicineCompanyService {

	@Autowired
	private MedicineCompanyDao medicineCompanyDao;

	@Override
	public MedicineCompany addMedicineCompany(MedicineCompany medicineCompany) {
		return null;

	}

	@Override
	public boolean deleteMedicineCompanyById(String id) {
		return medicineCompanyDao.deleteMedicineCompanyById(id);
	}

	@Override
	public MedicineCompany getMedicineCompanyById(String id) {
		MedicineCompany medicineCompany = medicineCompanyDao.getMedicineCompanyById(id);

		return medicineCompany;
	}

	@Override
	public MedicineCompany updateMedicineCompany(MedicineCompany medicineCompany) {
		return medicineCompanyDao.updateMedicineCompany(medicineCompany);
	}

	@Override
	public List<MedicineCompany> getAllMedicineCompanys() {
		return medicineCompanyDao.getAllMedicineCompanys();
	}

	@Override
	public List<MedicineCompany> getCompanysByName(String companyName) {
		return medicineCompanyDao.findByNameContainingIgnoreCase(companyName);
	}

	@Override
	public MedicineCompany getCompanyByName(String companyName) {
		return medicineCompanyDao.findByName(companyName);
	}

	@Override
	public Long getCountByRegisteredDate(String registeredDate) {
		return medicineCompanyDao.countByRegisterdate(registeredDate);
	}

	@Override
	public List<MedicineCompany> getTop5CompanyAddedByDate(String registeredDate) {
		return medicineCompanyDao.findTop5ByIdDesc(registeredDate);
	}

}
