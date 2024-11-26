package com.java.CarRentalSystem.model;

public class Vehicle {
	private String vehicleID;
	private String make;
	private String model;
	private int dailyrate;
	private status status;
	private int passengerCapacity;
	private String engineCapacity;
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getDailyrate() {
		return dailyrate;
	}
	public void setDailyrate(int dailyrate) {
		this.dailyrate = dailyrate;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public String getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", make=" + make + ", model=" + model + ", daily_rate=" + dailyrate
				+ ", status=" + status + ", passengerCapacity=" + passengerCapacity + ", engineCapacity="
				+ engineCapacity + "]";
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String vehicleID, String make, String model, int dailyrate,
			com.java.CarRentalSystem.model.status status, int passengerCapacity, String engineCapacity) {
		super();
		this.vehicleID = vehicleID;
		this.make = make;
		this.model = model;
		this.dailyrate = dailyrate;
		this.status = status;
		this.passengerCapacity = passengerCapacity;
		this.engineCapacity = engineCapacity;
	}
	public void setStatus(Object getstatus) {
		// TODO Auto-generated method stub
		
	}
	
	
}
