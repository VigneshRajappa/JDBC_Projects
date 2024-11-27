package com.java.Pet_Pals.Dao;

import java.sql.SQLException;
import java.util.List;

import com.java.Pet_Pals.model.Pets;

public interface PetsDao {

	List<Pets> ShowPets() throws ClassNotFoundException, SQLException;
	Pets searchByPetBreed(String breed) throws ClassNotFoundException, SQLException;
	boolean insertpets(int pid, String name, int age, String breed, String type, String available, int oid) throws ClassNotFoundException, SQLException;
	List<Pets> serachByType(String type) throws ClassNotFoundException, SQLException;

}
