package com.java.CarRentalSystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CarRentalSystem.model.Customer;

public interface CustomerDao {
	List<Customer> showcustDao() throws ClassNotFoundException, SQLException;
	Customer searchByCustId(String CustomerId) throws ClassNotFoundException, SQLException;
	Customer searchByCustName(String customerName) throws ClassNotFoundException,SQLException;
	boolean InsertCustomer(String customerID, String first, String last, String email, String userid, String pass,
			long phone, long aadhar) throws ClassNotFoundException, SQLException;
}