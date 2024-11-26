package com.java.CarRentalSystem.model;

import java.sql.Date;

public class Lease {
	private String LeaseID;
	private String VehicleID;
	private String CustomerID;
	private Date startDate;
	private Date endDate;
	private String type;
	public String getLeaseID() {
		return LeaseID;
	}
	public void setLeaseID(String leaseID) {
		LeaseID = leaseID;
	}
	public String getVehicleID() {
		return VehicleID;
	}
	public void setVehicleID(String vehicleID) {
		VehicleID = vehicleID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Lease [LeaseID=" + LeaseID + ", VehicleID=" + VehicleID + ", CustomerID=" + CustomerID + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + "]";
	}
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lease(String leaseID, String vehicleID, String customerID, Date startDate, Date endDate, String type) {
		super();
		LeaseID = leaseID;
		VehicleID = vehicleID;
		CustomerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}
	
	
}
