package com.java.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.CarRentalSystem.model.Vehicle;
import com.java.CarRentalSystem.model.status;
import com.java.CarRentalSystem.util.ConnectionHelper;

public class VehicleDaoImpl implements VehicleDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public Vehicle searchByCapacity(int Capacity) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vehicle WHERE PassengerCapacity = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, Capacity);
		ResultSet rs = pst.executeQuery();
		Vehicle veh = null;
		while(rs.next()) {
			veh = new Vehicle();
			veh.setVehicleID(rs.getString("VehicleID"));
			veh.setMake(rs.getString("Make"));
			veh.setModel(rs.getString("Model"));
			veh.setDailyrate(rs.getInt("DailyRate"));
			veh.setStatus(status.valueOf(rs.getString("Status")));
			veh.setPassengerCapacity(rs.getInt("PassengerCapacity"));
			veh.setEngineCapacity(rs.getString("EngineCapacity"));
		}
		return veh;
		
	}
	@Override
	public List<Vehicle> showVehDao() throws SQLException , ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vehicle";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vehicle> vehList = new ArrayList<Vehicle>();
		Vehicle veh = null;
		while(rs.next()) {
			veh = new Vehicle();
			veh.setVehicleID(rs.getString("VehicleID"));
			veh.setMake(rs.getString("Make"));
			veh.setModel(rs.getString("Model"));
			veh.setDailyrate(rs.getInt("DailyRate"));
			veh.setStatus(status.valueOf(rs.getString("Status")));
			veh.setPassengerCapacity(rs.getInt("PassengerCapacity"));
			veh.setEngineCapacity(rs.getString("EngineCapacity"));
			vehList.add(veh);
		}
		return vehList;
	}
	@Override
	public Vehicle searchByVehId(String vehicleID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vehicle WHERE VehicleID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, vehicleID);
		ResultSet rs = pst.executeQuery();
		Vehicle veh = null;
		while(rs.next()) {
			veh = new Vehicle();
			veh.setVehicleID(rs.getString("VehicleID"));
			veh.setMake(rs.getString("Make"));
			veh.setModel(rs.getString("Model"));
			veh.setDailyrate(rs.getInt("DailyRate"));
			veh.setStatus(status.valueOf(rs.getString("Status")));
			veh.setPassengerCapacity(rs.getInt("PassengerCapacity"));
			veh.setEngineCapacity(rs.getString("EngineCapacity"));
		}
		return veh;
	}
	@Override
	public boolean insertVehicle(String vehid, String make, String model, int rate, String status, int pass,
			String engine) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Vehicle(VehicleID,make,model,dailyrate,status,passengerCapacity,EngineCapacity)+"
				+ " values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, vehid);
		pst.setString(2, make);
		pst.setString(3,model);
		pst.setInt(4, rate);
		pst.setString(5, status);
		pst.setInt(6, pass);
		pst.setString(7,engine);
		pst.executeUpdate();
		return true;
	}
	@Override
	public boolean DelVehicle(String vehid) throws SQLException, ClassNotFoundException {
		String cmd="Delete from Vehicle where VehicleID=?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1,vehid);
		pst.executeUpdate();
		System.out.println("*** Employee record deleted ***");
		return true;
	}
	
}
