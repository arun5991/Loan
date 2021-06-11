package com.example.spring.webflux.model;

public class LoanDetails {
	private Integer customerId;
	private String loanType;
	private Integer loanAmount;
	private String date;
	private float ROI;
	private Integer loanDuration;
	
	public LoanDetails() {
		
	}
	
	public LoanDetails(Integer customerID, String loanType, Integer loanAmount, String date, float rOI, Integer loanDuration) {
		super();
		this.customerId = customerID;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.date = date;
		ROI = rOI;
		this.loanDuration = loanDuration;
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Integer getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getROI() {
		return ROI;
	}
	public void setROI(float rOI) {
		ROI = rOI;
	}
	public Integer getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}
	@Override
	public String toString() {
		return "LoanDetails [customerID="+customerId+"loanType=" + loanType + ", loanAmount=" + loanAmount + ", date=" + date + ", ROI=" + ROI
				+ ", loanDuration=" + loanDuration + "]";
	}
	
}
