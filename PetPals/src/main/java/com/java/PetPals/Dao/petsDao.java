package com.java.PetPals.Dao;

import java.sql.SQLException;
import java.util.List;

import com.java.PetPals.model.pets;

public interface petsDao {

	List<pets> ShowPets() throws ClassNotFoundException, SQLException;
	pets searchByPetBreed(String breed) throws ClassNotFoundException, SQLException;
	boolean insertpets(int pid, String name, int age, String breed, String type, String available, int oid) throws ClassNotFoundException, SQLException;
	List<pets> serachByType(String type) throws ClassNotFoundException, SQLException;

}
