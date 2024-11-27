package com.java.Pet_Pals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.Pet_Pals.util.ConnectionHelper;

public class SheltersDaoImpl implements SheltersDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public boolean addShelters(int sid, String name, String location) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="insert into Shelters(Shelter_ID,Name,Location)"
				+"values(?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, sid);
		pst.setString(2, name);
		pst.setString(3,location);
		pst.executeUpdate();
		return true;
		}

}
