package com.java.Car_Rental_System;

import com.java.Car_Rental_System.model.Lease;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import com.java.Car_Rental_System.dao.*;
import org.junit.Test;

public class LeaseDaoImplTest {

	private LeaseDao leaseDao = new LeaseDaoImpl();

    @Test
    public void testInsertLease() throws SQLException, ClassNotFoundException {
        Date startDate = Date.valueOf("2024-11-01");
        Date endDate = Date.valueOf("2024-11-30");
    }

    @Test
    public void testSearchByLeId() throws SQLException, ClassNotFoundException {
        // Test to search for a lease by its ID
        Lease lease = leaseDao.searchByLeId("L001");

    }

    @Test
    public void testShowLeaseByVehicleID() throws SQLException, ClassNotFoundException {
        Lease lease = leaseDao.showLeaseByVehicleID("V001");
    }

    @Test
    public void testShowLeaseByCustomerId() throws SQLException, ClassNotFoundException {
        Lease lease = leaseDao.showLEaseByCustomerId("C001");

    }

    @Test
    public void testShowLast6Month() throws SQLException, ClassNotFoundException {
        List<Lease> leases = leaseDao.ShowLast6Month();
        assertNotNull(leases, "Leases from the last 6 months not found");
        assertTrue(leases.size() > 0, "No leases found for the last 6 months");
    }

    @Test
    public void testShowFromStToEnd() throws SQLException, ClassNotFoundException {
        Date startDate = Date.valueOf("2024-01-01");
        Date endDate = Date.valueOf("2024-06-01");
        List<Lease> leases = leaseDao.ShowFromStToEnd(startDate, endDate);
        assertNotNull(leases, "Leases not found between start and end dates");
        assertTrue(leases.size() > 0, "No leases found in the specified date range");
    }

}
