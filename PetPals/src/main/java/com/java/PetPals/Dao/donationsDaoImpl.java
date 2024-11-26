package com.java.PetPals.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.java.PetPals.model.availableforadoption;
import com.java.PetPals.model.donation_type;
import com.java.PetPals.model.donations;
//import com.java.PetPals.model.pets;
import com.java.PetPals.util.ConnectionHelper;

public class donationsDaoImpl implements donationsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<donations> ShowDonation() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from donations";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<donations> dslist = new ArrayList<donations>();
		donations ds = null;
		while(rs.next()) {
			ds = new donations();
			ds.setDonation_id(rs.getInt("donation_id"));
			ds.setDonor_name(rs.getString("donor_Name"));
			ds.setDonation_type(donation_type.valueOf(rs.getString("donation_type")));
			ds.setDonation_amount(rs.getDouble("donation_amount"));
			ds.setDonation_item(rs.getString("donation_item"));
			ds.setDonation_date(rs.getDate("donation_date"));
			//ds.setOwnerid(rs.getInt("Owner_id"));
			dslist.add(ds);
		}
		return dslist;
	}
	@Override
	public boolean InsertDonation(int did, String dname, String dtype, double damount,String ditem, Date sqlDonationDate) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into donations(donation_id,donor_name,donation_type,donation_amount,donation_item,Donation_Date)"
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, did);
		pst.setString(2, dname);
		pst.setString(3,dtype);
		pst.setDouble(4, damount);
		pst.setString(5,ditem);
		pst.setDate(6, (java.sql.Date)sqlDonationDate);
		pst.executeUpdate();
		return true;
	}
	@Override
	public donations SearchByDonationID(int did) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from donations WHERE donation_id= ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, did);
		ResultSet rs = pst.executeQuery();
		donations ds = null;
		while(rs.next()) {
			ds = new donations();
			ds.setDonation_id(rs.getInt("donation_id"));
			ds.setDonor_name(rs.getString("donor_Name"));
			ds.setDonation_type(donation_type.valueOf(rs.getString("donation_type")));
			ds.setDonation_amount(rs.getDouble("donation_amount"));
			ds.setDonation_item(rs.getString("donation_item"));
			ds.setDonation_date(rs.getDate("donation_date"));
			//ds.setOwnerid(rs.getInt("Owner_id"));
			//dslist.add(ds);
		}
		return ds;
	}

}
