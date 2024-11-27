package com.java.Pet_Pals.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.java.PetPals.model.availableforadoption;
import com.java.Pet_Pals.model.DonationType;
import com.java.Pet_Pals.model.Donations;
//import com.java.PetPals.model.pets;
import com.java.Pet_Pals.util.ConnectionHelper;

public class DonationsDaoImpl implements DonationsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Donations> ShowDonation() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Donations";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Donations> dslist = new ArrayList<Donations>();
		Donations ds = null;
		while(rs.next()) {
			ds = new Donations();
			ds.setDonation_ID(rs.getInt("Donation_ID"));
			ds.setDonar_Name(rs.getString("Donar_Name"));
			ds.setDonation_Type(DonationType.valueOf(rs.getString("Donation_Type")));
			ds.setDonation_Amount(rs.getDouble("Donation_Amount"));
			ds.setDonation_Item(rs.getString("Donation_Item"));
			ds.setDonation_Date(rs.getDate("Donation_Date"));
			//ds.setOwnerid(rs.getInt("Owner_id"));
			dslist.add(ds);
		}
		return dslist;
	}
//	@Override
//	public List<Donations> ShowDonation() throws ClassNotFoundException, SQLException {
//	    connection = ConnectionHelper.getConnection();
//	    String cmd = "SELECT Donation_ID, Donor_Name, Donation_Type, Donation_Amount, Donation_Item, Donation_Date FROM Donations";
//	    pst = connection.prepareStatement(cmd);
//	    ResultSet rs = null;
//	    List<Donations> dslist = new ArrayList<>();
//	    try {
//	        rs = pst.executeQuery();
//	        while (rs.next()) {
//	            Donations ds = new Donations();
//	            ds.setDonation_ID(rs.getInt("Donation_ID"));
//	            ds.setDonor_Name(rs.getString("Donor_Name"));
//	            try {
//	                ds.setDonation_Type(DonationType.valueOf(rs.getString("Donation_Type")));
//	            } catch (IllegalArgumentException e) {
//	                System.err.println("Invalid Donation_Type: " + rs.getString("Donation_Type"));
//	                ds.setDonation_Type(null); // Fallback
//	            }
//	            ds.setDonation_Amount(rs.getDouble("Donation_Amount"));
//	            ds.setDonation_Item(rs.getString("Donation_Item"));
//	            ds.setDonation_Date(rs.getDate("Donation_Date"));
//	            dslist.add(ds);
//	        }
//	    } finally {
//	        if (rs != null) rs.close();
//	        if (pst != null) pst.close();
//	        if (connection != null) connection.close();
//	    }
//	    return dslist;
//	}
	@Override
	public boolean InsertDonation(int did, String dname, String dtype, double damount, String ditem, Date sqlDonationDate) throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO Donations (Donation_ID, Donar_Name, Donation_Type, Donation_Amount, Donation_Item, Donation_Date) "
	                 + "VALUES (?, ?, ?, ?, ?, ?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, did);
	    pst.setString(2, dname);
	    pst.setString(3, dtype);  // Make sure 'dtype' is a valid DonationType value (enum string)
	    pst.setDouble(4, damount);
	    pst.setString(5, ditem);
	    pst.setDate(6, sqlDonationDate);
	    
	    // Execute query and check affected rows
	    int affectedRows = pst.executeUpdate();
	    return affectedRows > 0;  // Return true if at least one row is inserted
	}

	@Override
	public Donations SearchByDonationID(int donationId) throws ClassNotFoundException, SQLException {
	    // Declare and initialize the necessary resources
	    Connection connection = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    Donations ds = null;

	    try {
	        connection = ConnectionHelper.getConnection();
	        String query = "SELECT * FROM Donations WHERE Donation_ID = ?";
	        pst = connection.prepareStatement(query);
	        pst.setInt(1, donationId);
	        
	        // Execute the query
	        rs = pst.executeQuery();
	        
	        // Process the ResultSet
	        if (rs.next()) {
	            ds = new Donations();
	            ds.setDonation_ID(rs.getInt("Donation_ID"));
	            ds.setDonar_Name(rs.getString("Donar_Name"));
	            
	            // Ensure proper enum handling for DonationType
	            String donationTypeStr = rs.getString("Donation_Type");
	            if (donationTypeStr != null) {
	                try {
	                    ds.setDonation_Type(DonationType.valueOf(donationTypeStr));
	                } catch (IllegalArgumentException e) {
	                    // Handle invalid enum value if necessary
	                    ds.setDonation_Type(null); // Or you can throw an exception or handle accordingly
	                }
	            }
	            
	            ds.setDonation_Amount(rs.getDouble("Donation_Amount"));
	            ds.setDonation_Item(rs.getString("Donation_Item"));
	            ds.setDonation_Date(rs.getDate("Donation_Date"));
	        }

	    } finally {
	        // Close resources to avoid potential memory leaks
	        if (rs != null) {
	            rs.close();
	        }
	        if (pst != null) {
	            pst.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }

	    return ds;  // Return the result
	}



}
