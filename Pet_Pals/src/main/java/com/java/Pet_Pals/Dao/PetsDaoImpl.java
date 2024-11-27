package com.java.Pet_Pals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.Pet_Pals.model.AvailableForAdoption;
import com.java.Pet_Pals.model.Pets;
import com.java.Pet_Pals.util.ConnectionHelper;

public class PetsDaoImpl implements PetsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Pets> ShowPets() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Pets";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Pets> plist = new ArrayList<Pets>();
		Pets pt = null;
		while(rs.next()) {
			pt = new Pets();
			pt.setPet_ID(rs.getInt("Pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailable_For_Adoption(AvailableForAdoption.valueOf(rs.getString("Available_For_Adoption")));
			pt.setOwner_ID(rs.getInt("Owner_ID"));
			plist.add(pt);
		}
		return plist;
	}
	@Override
	public Pets searchByPetBreed(String breed) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Pets WHERE Breed like ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, breed);
		ResultSet rs = pst.executeQuery();
		Pets pt = null;
		while(rs.next()) {
			pt = new Pets();
			pt.setPet_ID(rs.getInt("Pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailable_For_Adoption(AvailableForAdoption.valueOf(rs.getString("Available_For_Adoption")));
			pt.setOwner_ID(rs.getInt("Owner_ID"));
		}
		return pt;
	}
	@Override
	public boolean insertpets(int pid, String name, int age, String breed, String type, String available, int oid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into pets(Pet_ID,Name,Age,Breed,Type,Available_For_Adoption,Owner_ID)"
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
	public List<Pets> serachByType(String type) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Pets WHERE Type like ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, type);
		ResultSet rs = pst.executeQuery();
		List<Pets> ptlist=new ArrayList<Pets>();
		Pets pt = null;
		while(rs.next()) {
			pt = new Pets();
			pt.setPet_ID(rs.getInt("Pet_ID"));
			pt.setName(rs.getString("Name"));
			pt.setAge(rs.getInt("age"));
			pt.setBreed(rs.getString("breed"));
			pt.setType(rs.getString("type"));
			pt.setAvailable_For_Adoption(AvailableForAdoption.valueOf(rs.getString("Available_For_Adoption")));
			pt.setOwner_ID(rs.getInt("Owner_ID"));
			ptlist.add(pt);
		}
		return ptlist;
	}

}
