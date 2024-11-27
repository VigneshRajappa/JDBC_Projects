package com.java.Car_Rental_System.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Car_Rental_System.model.Payment;
import com.java.Car_Rental_System.util.ConnectionHelper;

public class PaymentDaoImpl implements PaymentDao{
	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean InsertPayment(String payid, String leid, Date paymentDate, double amount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Payment(Payment_ID,Lease_ID,Payment_Date,Amount)"
				+ " values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, payid);
		pst.setString(2, leid);
		pst.setDate(3, (java.sql.Date) paymentDate);
		pst.setDouble(4, amount);
		pst.executeUpdate();
		return true;
	}
	@Override
	public Payment ShowByLeaseID(String leid) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="select * from Payment where leaseId=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1,leid);
		ResultSet rs=pst.executeQuery();
		Payment pm=null;
		while(rs.next()) {
			pm=new Payment();
			pm.setPaymentID(rs.getString("Payment_ID"));
			pm.setLeaseID(rs.getString("Lease_ID"));
			pm.setPaymentDate(rs.getDate("Payment_Date"));
			pm.setAmount(rs.getDouble("Amount"));
		}
		return pm;
	}
	@Override
	public List<Payment> PendingPayments() throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="Select * from Payment where Amount = null";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Payment> pmlist=new ArrayList<Payment>();
		Payment pm=null;
		while(rs.next()) {
			pm=new Payment();
			pm.setPaymentID(rs.getString("Payment_ID"));
			pm.setLeaseID(rs.getString("Lease_ID"));
			pm.setPaymentDate(rs.getDate("Payment_Date"));
			pm.setAmount(rs.getDouble("Amount"));
			pmlist.add(pm);
		}
		return pmlist;
	}

}
