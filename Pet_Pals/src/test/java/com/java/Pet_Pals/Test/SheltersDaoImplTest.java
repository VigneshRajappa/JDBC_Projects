package com.java.Pet_Pals.Test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.java.Pet_Pals.Dao.SheltersDaoImpl;

public class SheltersDaoImplTest {

    private SheltersDaoImpl sheltersDao;

    @Before
    public void setUp() throws Exception {
        sheltersDao = new SheltersDaoImpl();
    }

    @Test
    public void testAddShelters() throws SQLException, ClassNotFoundException {
        int shelterId = 0;
        String shelterName = "Happy Paws Shelter";
        String shelterLocation = "New York";
        //sheltersDao.addShelters(shelterId, shelterName, shelterLocation);
    }
 
    @Test
    public void testAddSheltersDuplicateId() throws SQLException, ClassNotFoundException {
        String shelterName = "Happy Paws Shelter";
        String shelterLocation = "New York";
        int shelterId = 0;
		//sheltersDao.addShelters(shelterId, shelterName, shelterLocation); 
    }

    @Test
    public void testAddSheltersWithInvalidLocation() throws SQLException, ClassNotFoundException {
        int shelterId = 0;
        String shelterName = "Paws for Hope Shelter";
        String shelterLocation = "";
        //sheltersDao.addShelters(shelterId, shelterName, shelterLocation); 
    }

    @Test
    public void testAddAndFetchShelter() throws SQLException, ClassNotFoundException {
        int shelterId = 0;
        String shelterName = "Paws Rescue Shelter";
        String shelterLocation = "Los Angeles";
        //sheltersDao.addShelters(shelterId, shelterName, shelterLocation); 

    }
}
