package com.java.PetPals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.PetPals.model.availableforadoption;
import com.java.PetPals.model.pets;
import com.java.PetPals.util.ConnectionHelper;

public class petsDaoImpl implements petsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<pets> ShowPets() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from pets";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<pets> plist = new ArrayList<pets>();
		pets pt = null;
		while(rs.next()) {
			pt = new pets();
			pt.setPet_id(rs.getInt("pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailableforadoption(availableforadoption.valueOf(rs.getString("availableforadoption")));
			pt.setOwnerid(rs.getInt("Owner_id"));
			plist.add(pt);
		}
		return plist;
	}
	@Override
	public pets searchByPetBreed(String breed) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from pets WHERE breed like ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, breed);
		ResultSet rs = pst.executeQuery();
		pets pt = null;
		while(rs.next()) {
			pt = new pets();
			pt.setPet_id(rs.getInt("pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailableforadoption(availableforadoption.valueOf(rs.getString("availableforadoption")));
			pt.setOwnerid(rs.getInt("Owner_id"));
		}
		return pt;
	}
	@Override
	public boolean insertpets(int pid, String name, int age, String breed, String type, String available, int oid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into pets(Pet_ID,name,age,Breed,type,availableforadoption,owner_id)"
				+ " values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, pid);
		pst.setString(2, name);
		pst.setInt(3,age);
		pst.setString(4, breed);
		pst.setString(5, type);
		pst.setString(6, available);
		pst.setInt(7,oid);
		pst.executeUpdate();
		return true;
	}
	@Override
	public List<pets> serachByType(String type) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from pets WHERE type like ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, type);
		ResultSet rs = pst.executeQuery();
		List<pets> ptlist=new ArrayList<pets>();
		pets pt = null;
		while(rs.next()) {
			pt = new pets();
			pt.setPet_id(rs.getInt("pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailableforadoption(availableforadoption.valueOf(rs.getString("availableforadoption")));
			pt.setOwnerid(rs.getInt("Owner_id"));
			ptlist.add(pt);
		}
		return ptlist;
	}

}
