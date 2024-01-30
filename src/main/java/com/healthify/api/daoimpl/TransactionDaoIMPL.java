package com.healthify.api.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthify.api.dao.TransactionDao;
import com.healthify.api.entity.TransactionDetails;

@Repository
public class TransactionDaoIMPL implements TransactionDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public int generateSalaryForUser(TransactionDetails transactionDetails) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public TransactionDetails getTransactionDetails(String transactionId) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public TransactionDetails getTransactionDetails(String username, int month) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransactionDetails> getTransactionDetails(String username, int from, int to) {
		Session session = sf.getCurrentSession();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
