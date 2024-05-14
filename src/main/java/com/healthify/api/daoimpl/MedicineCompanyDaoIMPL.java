package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.exception.SomethingWentWrongException;
import javax.persistence.RollbackException;
import com.healthify.api.dao.MedicineCompanyDao;
import com.healthify.api.entity.MedicineCompany;

/**
 * @author RAM
 *
 */
@Repository
public class MedicineCompanyDaoIMPL implements MedicineCompanyDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<MedicineCompany> findByNameContainingIgnoreCase(String companyName) {
		return null;
	}

	

	@Override
	public Long countByRegisterdate(String dateAdded) {
		return null;
	}

	@Override
	public List<MedicineCompany> findTop5ByIdDesc(String date) {
		return null;
	}

	@Override
	public MedicineCompany addMedicineCompany(MedicineCompany medicineCompany) {
		//Session session = sf.getCurrentSession();
		try {
			Session session = sf.openSession();
			List<MedicineCompany> existingCompanies = session.createQuery("FROM MedicineCompany", MedicineCompany.class)
					.list();

			for (MedicineCompany existingCompany : existingCompanies) {
				if (existingCompany.getId().equals(medicineCompany.getId())) {
					throw new ResourceAlreadyExistsException(
							"Company with ID already exists: " + medicineCompany.getId());
				}
				if (existingCompany.getName().equals(medicineCompany.getName())) {
					throw new ResourceAlreadyExistsException(
							"Company with name already exists: " + medicineCompany.getName());
				}
				if (existingCompany.getEmailid().equals(medicineCompany.getEmailid())) {
					throw new ResourceAlreadyExistsException(
							"Company with email ID already exists: " + medicineCompany.getEmailid());
				}
				if (existingCompany.getMobileNo().equals(medicineCompany.getMobileNo())) {
					throw new ResourceAlreadyExistsException(
							"Company with mobile number already exists: " + medicineCompany.getMobileNo());
				}
			}
			session.persist(medicineCompany);
			Transaction tx = session.beginTransaction();
			tx.commit();

		} catch (RollbackException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong in during add medicinecompany data");

		}
		return medicineCompany;
	}

	@Override
	public boolean deleteMedicineCompanyById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MedicineCompany getMedicineCompanyById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MedicineCompany updateMedicineCompany(MedicineCompany medicineCompany) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MedicineCompany> getAllMedicineCompanys() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public MedicineCompany findByName(String companyName) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
