package com.java.PetPals.Dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.PetPals.model.donations;

public interface donationsDao {

	List<donations> ShowDonation() throws ClassNotFoundException, SQLException;

	boolean InsertDonation(int did, String dname, String dtype, double damount, String ditem, Date sqlDonationDate) throws ClassNotFoundException, SQLException;

	donations SearchByDonationID(int did) throws ClassNotFoundException, SQLException;

}
