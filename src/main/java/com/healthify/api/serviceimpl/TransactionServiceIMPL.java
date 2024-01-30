package com.healthify.api.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.TransactionDao;
import com.healthify.api.entity.TransactionDetails;
import com.healthify.api.service.TransactionService;

@Service
public class TransactionServiceIMPL implements TransactionService {

	@Autowired
	private TransactionDao dao;

	@Override
	public int generateSalaryForUser(TransactionDetails transactionDetails) {
		return 0;
		
	}

	@Override
	public List<String> generateSalaryreportForUser(String username, int from, int to) {
		return null;
		
	}

}
