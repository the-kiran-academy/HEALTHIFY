package com.healthify.api.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 */
@Entity
public class User {

	@Id
	@Column(name = "UserName",unique = true,nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9_]{3,20}$", message = "Invalid username format")	
	private String username;

	@NotBlank(message = "First name is manadtory")
	@Column(name = "FirstName",nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = "Invalid first name")
	private String firstname;

	@Column(name = "LastName",nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = "Invalid last name")
	private String lastname;

	@Column(name = "EmailId", unique = true,nullable = false)
	@NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email format")
	private String emailid;

	@Column(name = "Password",nullable = false)
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "At least 8 characters long, one uppercase,lowercase,digit,special character")
	private String password;

	@Column(name = "MobileNo", unique = true,nullable = false)
	@Pattern(regexp = "^[0-9]{10}$",message = "Invalid mobile number")
	private String mobileno;

	
	@Column(name = "Street")
	private String street;

	@Column(name = "City")
	private String city;

	@Column(name = "Pincode")
	private String pincode;


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<Specialty> specialties;

	@Column(name = "Question",nullable = false)
	@NotBlank(message = "Question is manadtory")
	private String Question;

	@Column(name = "Answer",nullable = false)
	@NotBlank(message = "Answer is manadtory")
	private String answer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CreatedDate",nullable = false)
	private Date createdDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;

	public User() {

	}

	public User(String username, String firstname, String lastname, String emailid, String password, String mobileno,
			String street, String city, String pincode, Set<Specialty> specialties, String question,
			String answer, Date createdDate, Set<Role> roles) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.mobileno = mobileno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.specialties = specialties;
		Question = question;
		this.answer = answer;
		this.createdDate = createdDate;
		this.roles = roles;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public Set<Specialty> getSpecialties() {
		return specialties;
	}



	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
}
