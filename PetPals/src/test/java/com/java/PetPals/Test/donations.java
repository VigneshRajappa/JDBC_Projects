package com.java.PetPals.Test;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.PetPals.Dao.donationsDao;
import com.java.PetPals.Dao.donationsDaoImpl;
import com.java.PetPals.model.donations;

class donations {

	 private donationsDao donDao;

	    @Before
	    public void setUp() {
	        donDao = new donationsDaoImpl();
	    }

	    @Test
	    public void testInsertDonation() throws Exception {
	        int donationId = 1;
	        String donorName = "John Doe";
	        String donationType = "MONEY";  // Make sure this matches one of the DonationType enum values
	        double donationAmount = 500.00;
	        String donationItem = "Books";
	        Date donationDate = Date.valueOf("2024-11-01");  // Ensure date is in proper format

	    }

	    @Test
	    public void testShowDonation() throws Exception {
	        List<com.java.PetPals.model.donations> dlist = donDao.ShowDonation();

	    }

	    @Test
	    public void testSearchByDonationID() throws Exception {
	        int donationId = 1; 
	        com.java.PetPals.model.donations donation = donDao.SearchByDonationID(donationId);
	    }
}
