package com.java.CarRentalSystem.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.java.CarRentalSystem.model.Lease;

public interface LeaseDao {

	boolean InsertLease(String lid, String vid, String cid, Date stdate, Date stdate2, String type) throws SQLException, ClassNotFoundException;
	Lease searchByLeId(String lid) throws ClassNotFoundException, SQLException;
	Lease showLeaseByVehicleID(String vid) throws ClassNotFoundException, SQLException;
	Lease showLEaseByCustomerId(String cid) throws SQLException,ClassNotFoundException;
	List<Lease> ShowLast6Month() throws ClassNotFoundException, SQLException;
	List<Lease> ShowFromStToEnd(java.sql.Date sqlStartDate, java.sql.Date sqlEndDate) throws ClassNotFoundException, SQLException;
}
