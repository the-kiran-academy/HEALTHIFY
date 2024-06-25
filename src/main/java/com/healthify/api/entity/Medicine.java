package com.healthify.api.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RAM
 *
 */
@Entity
public class Medicine {
	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	@NotBlank(message = " Medicine Name Is Required")
	private String name;

	@Column(name = "Type")
	@NotBlank(message = " Medicine Type Is Required")
	private String type;

	@Column(name = "Quantity")
	@Min(value = 1)
	private int quantity;

	@Column(name = "Price")
	@Min(value = 1)
	private Double price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ManufactureDate")
	@NotNull(message = "ManufactureDate Is Requird")
	//@Past(message = "Manufacturing date must be in the past")
	private Date manufactureDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ExpiryDate")
	@NotNull(message = "ExpiryDate Is Requird")
	//@Future(message = "Expiry date must be in the future")
	private Date expiryDate;

	//current date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "MedicineAddedDateInStock")
	private Date medicineAddedDateInStock;

	@Column(name = "DistributorId")
	@NotBlank(message = "DistributorId Is Required")
	private String distributorId;

	@Column(name = "MedicineCompanyId")
	@NotBlank(message = "MedicineCompanyId Is Required")
	private String medicineCompanyId;

	public Medicine() {
		// TODO Auto-generated constructor stub
	}

	public Medicine(String id, String name, String type, int quantity, Double price, Date manufactureDate,
			Date expiryDate, Date medicineAddedDateInStock, String distributorId, String medicineCompanyId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.medicineAddedDateInStock = medicineAddedDateInStock;
		this.distributorId = distributorId;
		this.medicineCompanyId = medicineCompanyId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getMedicineAddedDateInStock() {
		return medicineAddedDateInStock;
	}

	public void setMedicineAddedDateInStock(Date medicineAddedDateInStock) {
		this.medicineAddedDateInStock = medicineAddedDateInStock;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getMedicineCompanyId() {
		return medicineCompanyId;
	}

	public void setMedicineCompanyId(String medicineCompanyId) {
		this.medicineCompanyId = medicineCompanyId;
	}
	
	

}
