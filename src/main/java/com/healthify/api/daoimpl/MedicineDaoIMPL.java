package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.MedicineDao;
import com.healthify.api.entity.Medicine;
import com.healthify.api.entity.User;
import com.healthify.api.exception.ResourceAlreadyExistsException;
import com.healthify.api.exception.SomethingWentWrongException;

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
		boolean flag = false;

		try {
			Medicine ExistId = session.get(Medicine.class, medicine.getId());
			if (ExistId == null) {
				session.save(medicine);
				flag = true;
			}
			if (ExistId.getId() == medicine.getId()) {
				throw new ResourceAlreadyExistsException("Medicine With id Already exist, Please change Id");

			} else {

			}

		} catch (ResourceAlreadyExistsException e) {
			throw new ResourceAlreadyExistsException("Medicine With id Already exist, Please change Id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
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
		List<Medicine> resultList = null;
		try {
			Session session = sf.getCurrentSession();

			// resultList = session.createCriteria(Medicine.class).list();

			resultList = session.createQuery("from Medicine", Medicine.class).getResultList();

		} catch (HibernateException e) {
			throw new SomethingWentWrongException("Issue in retrieving all users");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
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
