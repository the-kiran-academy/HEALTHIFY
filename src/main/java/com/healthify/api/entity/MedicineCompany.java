package com.healthify.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 *
 */
@Entity
public class MedicineCompany {
	@Id
	@Column(name = "Id",nullable = false)
	private String id;

	@Column(name = "Name",nullable = false,unique = true)
	@NotBlank(message = "MedicineCompany Name Is Required")
	private String name;

	@Column(name = "EmailId",nullable = false,unique = true)
	@NotBlank(message = "EmailId Is Required")
	private String emailid;

	@Column(name = "MobileNo",nullable = false,unique = true)
	@NotBlank(message = "MobileNo Is Required")
	private String mobileNo;

	@Column(name = "Street",nullable = false)
	@NotBlank(message = "Street Is Required")
	private String street;

	@Column(name = "City",nullable = false)
	@NotBlank(message = "City Is Required")
	private String city;

	@Column(name = "Pincode",nullable = false)
	@NotBlank(message = "Pincode Is Requird")
	private String pincode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "RegisterDate",nullable = false)
	private Date registerDate;

	public MedicineCompany() {
		// TODO Auto-generated constructor stub
	}

	public MedicineCompany(String id, String name, String emailid, String mobileNo, String street, String city,
			String pincode, Date registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.registerDate = registerDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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

}
