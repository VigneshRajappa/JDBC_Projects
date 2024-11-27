package com.java.Car_Rental_System.model;

import java.sql.Date;

public class Payment {
	private String Payment_ID;
	private String Lease_ID;
	private Date Payment_Date;
	private double Amount;
	public String getPaymentID() {
		return Payment_ID;
	}
	public void setPaymentID(String Payment_ID) {
		this.Payment_ID = Payment_ID;
	}
	public String getLeaseID() {
		return Lease_ID;
	}
	public void setLeaseID(String Lease_ID) {
		this.Lease_ID = Lease_ID;
	}
	public Date getPaymentDate() {
		return Payment_Date;
	}
	public void setPaymentDate(Date Payment_Date) {
		this.Payment_Date = Payment_Date;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double Amount) {
		this.Amount = Amount;
	}
	@Override
	public String toString() {
		return "Payment [Payment_ID=" + Payment_ID + ", leaseID=" + Lease_ID + ", Payment_Date=" + Payment_Date + ", Amount="
				+ Amount + "]";
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String Payment_ID, String Lease_ID, Date Payment_Date, double Amount) {
		super();
		this.Payment_ID = Payment_ID;
		this.Lease_ID = Lease_ID;
		this.Payment_Date = Payment_Date;
		this.Amount = Amount;
	}
	
}
