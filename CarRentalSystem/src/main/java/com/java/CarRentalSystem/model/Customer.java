package com.java.CarRentalSystem.model;

public class Customer {
	private String customerID;
	private String firstName;
	private String lastName;
	private String email;
	private String userID;
	private String password;
	private String phoneNumber;
	private long Aadhar_Number;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getAadhar_Number() {
		return Aadhar_Number;
	}
	public void setAadhar_Number(long l) {
		Aadhar_Number = l;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", userID=" + userID + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", Aadhar_Number=" + Aadhar_Number + "]";
	}
	public Customer() {
		
	}
	public Customer(String customerID, String firstName, String lastName, String email, String userID, String password,
			String phoneNumber, long aadhar_Number) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userID = userID;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.Aadhar_Number = aadhar_Number;
	}
	
}
