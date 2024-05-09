package com.healthify.api.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.MedicineDao;
import com.healthify.api.entity.Medicine;
import com.healthify.api.exception.ResourceNotFoundException;
import com.healthify.api.exception.SomethingWentWrongException;
//import com.mysql.cj.Query;

/**
 * @author RAM
 *
 */
@Repository
public class MedicineDaoIMPL implements MedicineDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addMedicine(Medicine medicine) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Medicine> findByNameContainingIgnoreCase(String medicineName) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Medicine findByName(String medicineName) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medicine> findByQuantityGreaterThan(int quantity) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long countByDateAdded(String dateAdded) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getTotalCount() {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medicine> findTop5ByIdDesc(String date) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteMedicineById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Medicine getMedicineById(String id) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicine;

	}

	@Override
	public List<Medicine> getAllMedicine() {
		Session session = sf.getCurrentSession();
		List<Medicine> list=null;
		try {
			Query<Medicine> query = session.createQuery("FROM Medicine");
			 list = query.list();
			 System.out.println(list);
			 if (!list.isEmpty()) {
				return list;
			}
			 else {
				throw new ResourceNotFoundException("Resource Not Found");
			}
			
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Resource Not Found");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong During Get All Medicine");
		}
	}

	@Override
	public int[] uploadProductList(List<Medicine> list) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
