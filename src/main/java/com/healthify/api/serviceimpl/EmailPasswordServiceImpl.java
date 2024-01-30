// Java Program to Illustrate Creation Of
// Service implementation class

package com.healthify.api.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.healthify.api.dao.UserDao;
import com.healthify.api.model.EmailDetails;
import com.healthify.api.model.ResetPasswordDetail;
import com.healthify.api.service.EmailPasswordService;
import com.healthify.api.service.UserService;

@Service
public class EmailPasswordServiceImpl implements EmailPasswordService {
	private static Logger LOG = LogManager.getLogger(EmailPasswordServiceImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Value("${spring.mail.username}")
	private String sender;

	// Method 1
	// To send a simple email
	public boolean sendMail(EmailDetails details) {
		boolean isSent = false;
		
		return isSent;
	}

	@Override
	public String resetPasswordByQA(ResetPasswordDetail detail) {
		String message = null;
		
		return message;
	}

	@Override
	public String sendOtp(String UserId) {
		String msg = null;

		
		return msg;
	}

	@Override
	public String resetPasswordByOtp(ResetPasswordDetail detail) {
		String message = null;
		
		return message;
	}

}
