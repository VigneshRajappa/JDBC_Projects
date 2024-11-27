package com.java.Car_Rental_System.model;

public class Customer {
	private String Customer_ID;
	private String First_Name;
	private String Last_Name;
	private String Email;
	private String User_ID;
	private String Password;
	private String Phone_Number;
	private long Aadhar_Number;
	
	public String getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(String Customer_ID) {
		this.Customer_ID = Customer_ID;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLastName(String getLast_Name) {
		this.Last_Name = getLast_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getUserID() {
		return User_ID;
	}
	public void setUserID(String User_ID) {
		this.User_ID = User_ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getPhoneNumber() {
		return Phone_Number;
	}
	public void setPhoneNumber(String Phone_Number) {
		this.Phone_Number = Phone_Number;
	}
	public long getAadhar_Number() {
		return Aadhar_Number;
	}
	public void setAadhar_Number(long l) {
		Aadhar_Number = l;
	}
	@Override
	public String toString() {
		return "Customer [Customer_ID=" + Customer_ID + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Email="
				+ Email + ", User_ID=" + User_ID + ", Password=" + Password + ", Phone_Number=" + Phone_Number
				+ ", Aadhar_Number=" + Aadhar_Number + "]";
	}
	public Customer() {
		
	}
	public Customer(String Customer_ID, String First_Name, String Last_Name, String Email, String User_ID, String Password,
			String Phone_Number, long Aadhar_Number) {
		super();
		this.Customer_ID = Customer_ID;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Email = Email;
		this.User_ID = User_ID;
		this.Password = Password;
		this.Phone_Number = Phone_Number;
		this.Aadhar_Number = Aadhar_Number;
	}
	
}
