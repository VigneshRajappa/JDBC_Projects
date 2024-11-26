package com.java.PetPals.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.*;
import com.java.PetPals.util.ConnectionHelper;
import com.java.PetPals.Dao.sheltersDao;
import com.java.PetPals.Dao.sheltersDaoImpl;

public class shelters {

	private static sheltersDao sDao;

    @BeforeAll
    public static void setupDatabase() throws Exception {
        sDao = new sheltersDaoImpl();

        try (Connection connection = ConnectionHelper.getConnection();
             Statement statement = connection.createStatement()) {

       
            String createTable = "CREATE TABLE IF NOT EXISTS Shelters (" +
                    "ShelterID INT PRIMARY KEY, " +
                    "Name VARCHAR(100), " +
                    "Location VARCHAR(200))";
            statement.execute(createTable);
        }
    }

    @BeforeEach
    public void cleanDatabase() throws Exception {
        try (Connection connection = ConnectionHelper.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM Shelters"); // Clean the table before each test
        }
    }

    @Test
    @Order(1)
    public void testAddShelter() throws Exception {
        shelters shelter = new shelters(1, "paws", "Goa");
        sDao.addShelters(shelter);

        List<shelters> shelterList = sDao.showShelters();

        assertEquals(1, shelterList.size(), "Expected one shelter in the list.");
        assertEquals("Happy Tails", shelterList.get(0).getName(), "Shelter name should match.");
        System.out.println("testAddShelter passed.");
    }

    @Test
    @Order(2)
    public void testShowShelters() throws Exception {
        sDao.addShelters(new shelters(1, "Paws", "Goa"));
        sDao.addShelters(new shelters(2, "Haven", "Bhopal"));

        List<shelters> shelterList = sDao.showShelters();

        assertEquals(2, shelterList.size(), "Expected two shelters in the list.");
        assertEquals("Furry Friends", shelterList.get(1).getName(), "Second shelter name should match.");
        System.out.println("testShowShelters passed.");
    }
    @AfterEach
    public void tearDownEach() {
        System.out.println("Test completed.");
    }

    @AfterAll
    public static void cleanupDatabase() throws Exception {
        try (Connection connection = ConnectionHelper.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Shelters"); // Drop the table after all tests
        }
    }
}
