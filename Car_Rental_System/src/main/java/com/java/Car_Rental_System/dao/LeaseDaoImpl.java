package com.java.Car_Rental_System.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.Car_Rental_System.model.Lease;
import com.java.Car_Rental_System.util.ConnectionHelper;

public class LeaseDaoImpl implements LeaseDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean InsertLease(String lid, String vid, String cid, Date stdate, Date stdate2, String type) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Lease(Lease_ID,Vehicle_ID,Customer_ID,Start_Date,End_Date,Type)"
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, lid);
		pst.setString(2, vid);
		pst.setString(3, cid);
		pst.setDate(4, (java.sql.Date) stdate);
		pst.setDate(5, (java.sql.Date) stdate2);
		pst.setString(6, type);
		pst.executeUpdate();
		return true;
	}
	@Override
	public Lease searchByLeId(String lid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Lease WHERE Lease_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, lid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("Lease_ID"));
			le.setVehicleID(rs.getString("Vehicle_ID"));
			le.setCustomerID(rs.getString("Customer_ID"));
			le.setStartDate(rs.getDate("Start_Date"));
			le.setEndDate(rs.getDate("End_Date"));
			le.setType(rs.getString("Type"));
		}
		return le;
	}
	@Override
	public Lease showLeaseByVehicleID(String vid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Lease WHERE Vehicle_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, vid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("Lease_ID"));
			le.setVehicleID(rs.getString("Vehicle_ID"));
			le.setCustomerID(rs.getString("Customer_ID"));
			le.setStartDate(rs.getDate("Start_Date"));
			le.setEndDate(rs.getDate("End_Date"));
			le.setType(rs.getString("Type"));
		}
		return le;

	}
	@Override
	public Lease showLEaseByCustomerId(String cid) throws SQLException,ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Lease WHERE Customer_ID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, cid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("Lease_ID"));
			le.setVehicleID(rs.getString("Vehicle_ID"));
			le.setCustomerID(rs.getString("Customer_ID"));
			le.setStartDate(rs.getDate("Start_Date"));
			le.setEndDate(rs.getDate("End_Date"));
			le.setType(rs.getString("Type"));
		}
		return le;
	}
	@Override
	public List<Lease> ShowLast6Month() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM Lease WHERE Start_Date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH) ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeList = new ArrayList<Lease>();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("Lease_ID"));
			le.setVehicleID(rs.getString("Vehicle_ID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("Star_tDate"));
			le.setEndDate(rs.getDate("End_Date"));
			le.setType(rs.getString("Type"));
			LeList.add(le);
		}
		return LeList;
	}
	@Override
	public List<Lease> ShowFromStToEnd(java.sql.Date sqlStartDate, java.sql.Date sqlEndDate) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM Lease WHERE Start_Date BETWEEN ? AND ?";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1,sqlStartDate);
        pst.setDate(2,sqlEndDate);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeList = new ArrayList<Lease>();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("Lease_ID"));
			le.setVehicleID(rs.getString("Vehicle_ID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("Star_tDate"));
			le.setEndDate(rs.getDate("End_Date"));
			le.setType(rs.getString("Type"));
			LeList.add(le);
		}
		return LeList;
	}
	
}
