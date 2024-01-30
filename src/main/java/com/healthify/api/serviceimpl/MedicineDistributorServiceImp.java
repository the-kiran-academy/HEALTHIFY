package com.healthify.api.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.MedicineDistributorDao;
import com.healthify.api.entity.MedicineDistributor;
import com.healthify.api.service.MedicineDistributorService;

/**
 * @author RAM
 *
 */
@Service
public class MedicineDistributorServiceImp implements MedicineDistributorService {

	@Autowired
	private MedicineDistributorDao medicineDistributorDao;

	@Override
	public MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor) {
		return null;

	}

	@Override
	public boolean deleteMedicineDistributorById(String id) {
		return medicineDistributorDao.deleteMedicineDistributorById(id);
	}

	@Override
	public MedicineDistributor getMedicineDistributorById(String id) {
		MedicineDistributor medicineDistributor = medicineDistributorDao.getMedicineDistributorById(id);
		return medicineDistributor;
	}

	@Override
	public MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor) {
		return medicineDistributorDao.updateMedicineDistributor(medicineDistributor);
	}

	@Override
	public List<MedicineDistributor> getAllDistributors() {
		return medicineDistributorDao.getAllDistributors();
	}

	@Override
	public List<MedicineDistributor> getDistributorsByName(String distributorName) {
		return medicineDistributorDao.getDistributorsByName(distributorName);
	}

	@Override
	public MedicineDistributor getDistributorByName(String distributorName) {
		return medicineDistributorDao.getDistributorByName(distributorName);
	}

	@Override
	public Long getCountByRegisteredDate(String registeredDate) {
		return medicineDistributorDao.getCountByRegisteredDate(registeredDate);
	}

	@Override
	public List<MedicineDistributor> getTop5CompanyAddedByDate(String date) {
		return medicineDistributorDao.getTop5CompanyAddedByDate(date);
	}

}
