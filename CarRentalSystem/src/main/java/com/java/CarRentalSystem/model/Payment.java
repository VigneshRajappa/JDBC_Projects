package com.java.CarRentalSystem.model;

import java.sql.Date;

public class Payment {
	private String paymentID;
	private String leaseID;
	private Date paymentDate;
	private double amount;
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getLeaseID() {
		return leaseID;
	}
	public void setLeaseID(String leaseID) {
		this.leaseID = leaseID;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", leaseID=" + leaseID + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String paymentID, String leaseID, Date paymentDate, double amount) {
		super();
		this.paymentID = paymentID;
		this.leaseID = leaseID;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
}
