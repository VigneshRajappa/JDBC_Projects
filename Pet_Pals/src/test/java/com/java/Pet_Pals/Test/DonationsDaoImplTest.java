package com.java.Pet_Pals.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.Pet_Pals.Dao.DonationsDao;
import com.java.Pet_Pals.Dao.DonationsDaoImpl;
import com.java.Pet_Pals.model.Donations;

public class DonationsDaoImplTest {

    private DonationsDao donationsDao;

    @Before
    public void setUp() {
        donationsDao = new DonationsDaoImpl();
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
        List<Donations> donations = donationsDao.ShowDonation();

    }

    @Test
    public void testSearchByDonationID() throws Exception {
        int donationId = 1; 
        Donations donation = donationsDao.SearchByDonationID(donationId);
    }
}
