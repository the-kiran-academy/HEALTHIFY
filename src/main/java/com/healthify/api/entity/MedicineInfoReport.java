package com.healthify.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medicine_report")
public class MedicineInfoReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String medicineName;
	private int medicineQty;
	private double medicinePrice;
	private double total;

	@ManyToOne
	@JoinColumn(name = "billing_report_id")
	@JsonIgnore
	private MedicalBillingReport billingReport;

	public MedicineInfoReport() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getMedicineQty() {
		return medicineQty;
	}

	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public MedicalBillingReport getBillingReport() {
		return billingReport;
	}

	public void setBillingReport(MedicalBillingReport billingReport) {
		this.billingReport = billingReport;
	}

}
