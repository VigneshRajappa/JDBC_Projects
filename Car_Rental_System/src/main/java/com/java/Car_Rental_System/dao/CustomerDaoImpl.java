package com.java.Car_Rental_System.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Car_Rental_System.model.Customer;
import com.java.Car_Rental_System.util.ConnectionHelper;

public class CustomerDaoImpl implements CustomerDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Customer> showcustDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer();
			cust.setCustomer_ID(rs.getString("Customer_ID"));
			cust.setFirst_Name(rs.getString("First_Name"));
			cust.setLastName(rs.getString("Last_Name"));
			cust.setEmail(rs.getString("Email"));
			cust.setUserID(rs.getString("User_ID"));
			cust.setPassword(rs.getString("Password"));
			cust.setPhoneNumber(rs.getString("Phone_Number"));
			cust.setAadhar_Number(rs.getLong("Aadhar_Number"));
			customerList.add(cust);
		}
		return customerList;
	}

	@Override
	public Customer searchByCustId(String CustomerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer WHERE Customer_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, CustomerId);
		ResultSet rs = pst.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer();
			cust.setCustomer_ID(rs.getString("Customer_ID"));
			cust.setFirst_Name(rs.getString("First_Name"));
			cust.setLastName(rs.getString("Last_Name"));
			cust.setEmail(rs.getString("Email"));
			cust.setUserID(rs.getString("User_ID"));
			cust.setPassword(rs.getString("password"));
			cust.setPhoneNumber(rs.getString("Phone_Number"));
			cust.setAadhar_Number(rs.getLong("Aadhar_Number"));
		}
		return cust;
	}
	@Override
	public Customer searchByCustName(String customerName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where First_Name like ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, customerName);
		ResultSet rs = pst.executeQuery();
		Customer cust = null;
		while(rs.next()) {
			cust = new Customer();
			cust.setCustomer_ID(rs.getString("Customer_ID"));
			cust.setFirst_Name(rs.getString("First_Name"));
			cust.setLastName(rs.getString("Last_Name"));
			cust.setEmail(rs.getString("Email"));
			cust.setUserID(rs.getString("User_ID"));
			cust.setPassword(rs.getString("password"));
			cust.setPhoneNumber(rs.getString("Phone_Number"));
			cust.setAadhar_Number(rs.getLong("Aadhar_Number"));
		}
		return cust;
	}

	@Override
	public boolean InsertCustomer(String customerID, String first, String last, String email, String userid,
			String pass, long phone, long aadhar) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Customer(Customer_ID,First_Name,Last_Name,Email,User_ID,Password,Phone_Number,Aadhar_Number)"
				+ " values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, customerID);
		pst.setString(2, first);
		pst.setString(3, last);
		pst.setString(4, email);
		pst.setString(5, userid);
		pst.setString(6, pass);
		pst.setLong(7,phone);
		pst.setLong(8, aadhar);
		pst.executeUpdate();
		return true;
		
	}
	
}
