package com.java.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.CarRentalSystem.model.Lease;
import com.java.CarRentalSystem.util.ConnectionHelper;

public class LeaseDaoImpl implements LeaseDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean InsertLease(String lid, String vid, String cid, Date stdate, Date stdate2, String type) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Lease(leaseid,vehicleid,customerid,startdate,enddate,type)"
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
		String cmd = "select * from Lease WHERE LeaseID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, lid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("LeaseID"));
			le.setVehicleID(rs.getString("VehicleID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("StartDate"));
			le.setEndDate(rs.getDate("EndDate"));
			le.setType(rs.getString("type"));
		}
		return le;
	}
	@Override
	public Lease showLeaseByVehicleID(String vid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Lease WHERE VehicleID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, vid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("LeaseID"));
			le.setVehicleID(rs.getString("VehicleID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("StartDate"));
			le.setEndDate(rs.getDate("EndDate"));
			le.setType(rs.getString("type"));
		}
		return le;

	}
	@Override
	public Lease showLEaseByCustomerId(String cid) throws SQLException,ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Lease WHERE CustomerID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, cid);
		ResultSet rs = pst.executeQuery();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("LeaseID"));
			le.setVehicleID(rs.getString("VehicleID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("StartDate"));
			le.setEndDate(rs.getDate("EndDate"));
			le.setType(rs.getString("type"));
		}
		return le;
	}
	@Override
	public List<Lease> ShowLast6Month() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM Lease WHERE startDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH) ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeList = new ArrayList<Lease>();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("LeaseID"));
			le.setVehicleID(rs.getString("VehicleID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("StartDate"));
			le.setEndDate(rs.getDate("EndDate"));
			le.setType(rs.getString("type"));
			LeList.add(le);
		}
		return LeList;
	}
	@Override
	public List<Lease> ShowFromStToEnd(java.sql.Date sqlStartDate, java.sql.Date sqlEndDate) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM Lease WHERE startDate BETWEEN ? AND ?";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1,sqlStartDate);
        pst.setDate(2,sqlEndDate);
		ResultSet rs = pst.executeQuery();
		List<Lease> LeList = new ArrayList<Lease>();
		Lease le = null;
		while(rs.next()) {
			le = new Lease();
			le.setLeaseID(rs.getString("LeaseID"));
			le.setVehicleID(rs.getString("VehicleID"));
			le.setCustomerID(rs.getString("CustomerID"));
			le.setStartDate(rs.getDate("StartDate"));
			le.setEndDate(rs.getDate("EndDate"));
			le.setType(rs.getString("type"));
			LeList.add(le);
		}
		return LeList;
	}
	
}
