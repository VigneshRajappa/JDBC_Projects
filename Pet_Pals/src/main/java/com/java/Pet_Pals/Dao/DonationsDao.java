package com.java.Pet_Pals.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.Pet_Pals.model.Donations;

public interface DonationsDao 
{
	List<Donations> ShowDonation() throws ClassNotFoundException, SQLException;
	boolean InsertDonation(int did, String dname, String dtype, double damount, String ditem, Date sqlDonationDate) throws ClassNotFoundException, SQLException;
	Donations SearchByDonationID(int did) throws ClassNotFoundException, SQLException;
}
