package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.MedicineDistributorDao;
import com.healthify.api.entity.MedicineDistributor;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.exception.SomethingWentWrongException;

/**
 * @author RAM
 *
 */
@Repository
public class MedicineDistributorDaoIMPL implements MedicineDistributorDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public MedicineDistributor addMedicineDistributor(MedicineDistributor medicineDistributor) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteMedicineDistributorById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MedicineDistributor getMedicineDistributorById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MedicineDistributor updateMedicineDistributor(MedicineDistributor medicineDistributor) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MedicineDistributor> getAllDistributors() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
    public List<MedicineDistributor> getDistributorsByName(String distributorName) {
        Session session = sf.openSession();
        try {
        	
            Criteria criteria = session.createCriteria(MedicineDistributor.class);
            criteria.add(Restrictions.eq("name", distributorName));
            List<MedicineDistributor> dbList = criteria.list();
          
            if (!dbList.isEmpty()) {
                return dbList;
            } else {
                throw new ResourceNotFoundException("Resource Not Found for Distributor Name " + distributorName);
            }
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new SomethingWentWrongException("Something Went wrong during Get Distributors by Name");
        } 
    }

	@Override
	public MedicineDistributor getDistributorByName(String distributorName) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getCountByRegisteredDate(String date) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MedicineDistributor> getTop5CompanyAddedByDate(String date) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
