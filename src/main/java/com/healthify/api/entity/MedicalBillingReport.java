package com.healthify.api.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "medical_bill_report")
public class MedicalBillingReport {
	
	@Id
	@Column(unique = true, nullable = false)
	private Long invoiceNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "billing_date",nullable = false)
	private Date billingDate;
	
	@Column(name = "patient_name",nullable = false)
	private String fullName;
	
	@Column(name = "patient_address")
	private String patientAddress;

	@Column(name = "admission_id")
	private Long admissionId;

	@OneToMany(mappedBy = "billingReport", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)	
	private List<MedicineInfoReport> medicines;

	private double subTotal;

	private int taxRate;

	private double totalAmount;
	
	public MedicalBillingReport() {
		// TODO Auto-generated constructor stub
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	public List<MedicineInfoReport> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicineInfoReport> medicines) {
		this.medicines = medicines;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
