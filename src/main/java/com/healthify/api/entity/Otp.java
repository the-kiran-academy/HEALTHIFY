package com.healthify.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Otp {
	
	@Id
	@Column(name = "userId",nullable = false)
	private String userId;
	
	@Column(name = "otp",nullable = false)
	private int otp;
	
	@Column(name = "timestamp",nullable = false)
	private Timestamp timestamp;
	
	public Otp() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int generatedOtp) {
		this.otp = generatedOtp;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
