package com.java.PetPals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.PetPals.util.ConnectionHelper;

public class sheltersDaoImpl implements sheltersDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean addShelters(int sid, String name, String location) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="insert into shelters(shelter_id,name,location)"
				+"values(?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, sid);
		pst.setString(2, name);
		pst.setString(3,location);
		pst.executeUpdate();
		return true;
		}

}
