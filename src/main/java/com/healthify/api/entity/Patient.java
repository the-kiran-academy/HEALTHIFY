package com.healthify.api.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 *
 */
@Entity
public class Patient {
	@Id
	@Column(name = "patient_id",nullable = false)
	private String id;

	@Column(name = "first_name",nullable = false)
	@NotBlank(message = "FirstName Is Required")
	private String firstName;

	@Column(name = "last_name",nullable = false)
	@NotBlank(message = "LastName Is Required")
	private String lastName;

	@Column(name = "email")
	@NotBlank(message = "EmailId Is Required")
	private String emailId;

	@Column(name = "age",nullable = false)
	@NotBlank(message = "Age Is Required")
	private int age;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "mobile",nullable = false)
	@NotBlank(message = "MobileNo Is Required")
	private String mobileNo;

	@Column(name = "street")
	private String street;

	@Column(name = "city",nullable = false)
	@NotBlank(message = "City Is Required")
	private String city;

	@Column(name = "pincode",nullable = false)
	@NotBlank(message = "Pincode Is Required")
	private String pincode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "register_date")
	private Date registerDate;
	
	  @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admission admission;


	public Patient() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public Admission getAdmission() {
		return admission;
	}


	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	
}
