package com.healthify.api.model;

import java.util.List;

public class MedicalBillingReport {
	
	private Long invoiceNumber;

	private String Date;
	
	private String fullName;
	
	private String patientAddress;

	private Long admissionId;

	private String billingDate;

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

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
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

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
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
