package com.java.Car_Rental_System.model;

import java.sql.Date;

public class Lease {
	private String Lease_ID;
	private String Vehicle_ID;
	private String Customer_ID;
	private Date Start_Date;
	private Date End_Date;
	private String Type;
	public String getLeaseID() {
		return Lease_ID;
	}
	public void setLeaseID(String Lease_ID) {
		this.Lease_ID = Lease_ID;
	}
	public String getVehicleID() {
		return Vehicle_ID;
	}
	public void setVehicleID(String Vehicle_ID) {
		this.Vehicle_ID = Vehicle_ID;
	}
	public String getCustomerID() {
		return Customer_ID;
	}
	public void setCustomerID(String Customer_ID) {
		this.Customer_ID = Customer_ID;
	}
	public Date getStartDate() {
		return Start_Date;
	}
	public void setStartDate(Date Start_Date) {
		this.Start_Date = Start_Date;
	}
	public Date getEndDate() {
		return End_Date;
	}
	public void setEndDate(Date End_Date) {
		this.End_Date = End_Date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	@Override
	public String toString() {
		return "Lease [Lease_ID=" + Lease_ID + ", Vehicle_ID=" + Vehicle_ID + ", Customer_ID=" + Customer_ID + ", Start_Date="
				+ Start_Date + ", End_Date=" + End_Date + ", Type=" + Type + "]";
	}
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lease(String Lease_ID, String Vehicle_ID, String Customer_ID, Date Start_Date, Date End_Date, String Type) {
		super();
		this.Lease_ID = Lease_ID;
		this.Vehicle_ID = Vehicle_ID;
		this.Customer_ID = Customer_ID;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.Type = Type;
	}
	
	
}
