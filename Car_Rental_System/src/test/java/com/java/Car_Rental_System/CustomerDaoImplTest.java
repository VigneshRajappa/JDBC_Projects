package com.java.Car_Rental_System;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.List;

import com.java.Car_Rental_System.dao.CustomerDaoImpl;
import com.java.Car_Rental_System.model.Customer;

import org.junit.Test;

public class CustomerDaoImplTest {
	private CustomerDaoImpl customerDao;

    @BeforeEach
    public void setUp() throws Exception {
        customerDao = new CustomerDaoImpl();
    }

    @Test
    public void testShowcustDao() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = customerDao.showcustDao();
        assertNotNull(customerList);
        assertTrue(customerList.size() > 0, "The customer list should not be empty.");
    }

    @Test
    public void testSearchByCustId() throws SQLException, ClassNotFoundException {
        String customerId = "C001";  // Assuming this customer ID exists
        Customer customer = customerDao.searchByCustId(customerId);
        assertNotNull(customer);
    }

    @Test
    public void testSearchByCustName() throws SQLException, ClassNotFoundException {
        String customerName = "John";  // Assuming there is a customer named John
        Customer customer = customerDao.searchByCustName(customerName);
        String nonExistentName = "NonExistentName";
        Customer nonExistentCustomer = customerDao.searchByCustName(nonExistentName);
    }

    @Test
    public void testInsertCustomer() throws SQLException, ClassNotFoundException {
        String customerID = "C002";
        String firstName = "Jane";
        String lastName = "Doe";
        String email = "jane.doe@example.com";
        String userID = "janedoe";
        String password = "password123";
        long phone = 9876543210L;
        long aadhar = 123456789012L;

        boolean isInserted = customerDao.InsertCustomer(customerID, firstName, lastName, email, userID, password, phone, aadhar);
        assertTrue(isInserted, "Customer should be successfully inserted.");

        Customer insertedCustomer = customerDao.searchByCustId(customerID);
        assertNotNull(insertedCustomer, "Inserted customer should be found.");
    }

    @Test
    public void testInsertCustomerDuplicateId() throws SQLException, ClassNotFoundException {
        String existingCustomerID = "C001"; // Assuming this ID already exists
        String firstName = "Duplicate";
        String lastName = "User";
        String email = "duplicate.user@example.com";
        String userID = "duplicateuser";
        String password = "password123";
        long phone = 9998887776L;
        long aadhar = 987654321012L;

        //boolean isInserted = customerDao.InsertCustomer(existingCustomerID, firstName, lastName, email, userID, password, phone, aadhar);
    }

}
