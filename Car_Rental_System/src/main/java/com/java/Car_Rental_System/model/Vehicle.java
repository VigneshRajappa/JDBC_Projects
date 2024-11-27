package com.java.Car_Rental_System.model;

public class Vehicle {
	private String Vehicle_ID;
	private String Make;
	private String Model;
	private int Daily_Rate;
	private Status Status;
	private int Passenger_Capacity;
	private String Engine_Capacity;
	public String getVehicleID() {
		return Vehicle_ID;
	}
	public void setVehicleID(String Vehicle_ID) {
		this.Vehicle_ID = Vehicle_ID;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String Make) {
		this.Make = Make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}
	public int getDailyrate() {
		return Daily_Rate;
	}
	public void setDailyrate(int Daily_Rate) {
		this.Daily_Rate = Daily_Rate;
	}
	public Status getStatus() {
		return Status;
	}
	public void setStatus(Status Status) {
		this.Status = Status;
	}
	public int getPassengerCapacity() {
		return Passenger_Capacity;
	}
	public void setPassengerCapacity(int Passenger_Capacity) {
		this.Passenger_Capacity = Passenger_Capacity;
	}
	public String getEngineCapacity() {
		return Engine_Capacity;
	}
	public void setEngineCapacity(String Engine_Capacity) {
		this.Engine_Capacity = Engine_Capacity;
	}
	@Override
	public String toString() {
		return "Vehicle [Vehicle_ID=" + Vehicle_ID + ", Make=" + Make + ", Model=" + Model + ", Daily_Rate=" + Daily_Rate
				+ ", Status=" + Status + ", Passenger_Capacity=" + Passenger_Capacity + ", Engine_Capacity="
				+ Engine_Capacity + "]";
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String Vehicle_ID, String Make, String Model, int Daily_Rate,
			com.java.Car_Rental_System.model.Status Status, int Passenger_Capacity, String Engine_Capacity) {
		super();
		this.Vehicle_ID = Vehicle_ID;
		this.Make = Make;
		this.Model = Model;
		this.Daily_Rate = Daily_Rate;
		this.Status = Status;
		this.Passenger_Capacity = Passenger_Capacity;
		this.Engine_Capacity = Engine_Capacity;
	}
	public void setStatus(Object getstatus) {
		// TODO Auto-generated method stub
		
	}
	
	
}
