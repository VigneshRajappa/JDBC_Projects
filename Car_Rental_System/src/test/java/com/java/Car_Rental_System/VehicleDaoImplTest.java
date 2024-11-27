package com.java.Car_Rental_System;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import com.java.Car_Rental_System.model.Vehicle;
import com.java.Car_Rental_System.dao.*;
import org.junit.Test;

public class VehicleDaoImplTest {

	private VehicleDaoImpl vehicleDao;

    @BeforeEach
    public void setUp() {
        // Setup your VehicleDaoImpl before each test
        vehicleDao = new VehicleDaoImpl();
    }

    @Test
    public void testInsertVehicle() throws SQLException, ClassNotFoundException {
        // Sample test data
        boolean isInserted = vehicleDao.insertVehicle("V123", "Toyota", "Corolla", 100, "Available", 5, "1.8L");
        assertTrue(isInserted, "Vehicle should be inserted successfully");
    }

    @Test
    public void testSearchByVehId() throws SQLException, ClassNotFoundException {
        // Sample test data
        vehicleDao.insertVehicle("V124", "Honda", "Civic", 120, "Available", 5, "2.0L");
        
        // Search for the vehicle by its ID
        Vehicle vehicle = vehicleDao.searchByVehId("V124");
         
        // Assert that the vehicle was found and its properties match
        assertNotNull(vehicle, "Vehicle should be found for ID: V124");
        assertEquals("V124", vehicle.getVehicleID(), "Vehicle ID should match");
        assertEquals("Honda", vehicle.getMake(), "Make should match");
        assertEquals("Civic", vehicle.getModel(), "Model should match");
    }

    @Test
    public void testSearchByCapacity() throws SQLException, ClassNotFoundException {
        // Insert a vehicle with capacity
        vehicleDao.insertVehicle("V125", "Ford", "Focus", 90, "Available", 5, "1.6L");
        
        // Search for vehicles by capacity
        List<Vehicle> vehicles = (List<Vehicle>) vehicleDao.searchByCapacity(5);
        
        // Assert that vehicles were found and the list is not empty
        assertNotNull(vehicles, "Vehicles list should not be null");
        assertFalse(vehicles.isEmpty(), "Vehicles list should not be empty");
    }

    @Test
    public void testDelVehicle() throws SQLException, ClassNotFoundException {
        // Insert a vehicle
        vehicleDao.insertVehicle("V126", "Chevrolet", "Cruze", 110, "Available", 5, "1.8L");
        
        // Delete the vehicle by ID
        boolean isDeleted = vehicleDao.DelVehicle("V126");
        
        // Assert that the vehicle was successfully deleted
        assertTrue(isDeleted, "Vehicle should be deleted successfully");
    }

    @Test
    public void testShowVehDao() throws SQLException, ClassNotFoundException {
        // Insert a vehicle
        vehicleDao.insertVehicle("V127", "Nissan", "Altima", 95, "Available", 5, "2.5L");
        
        // Retrieve all vehicles
        List<Vehicle> vehicles = vehicleDao.showVehDao();
        
        // Assert that vehicles list is not null and not empty
        assertNotNull(vehicles, "Vehicles list should not be null");
        assertTrue(vehicles.size() > 0, "Vehicles list should not be empty");
    }

}
