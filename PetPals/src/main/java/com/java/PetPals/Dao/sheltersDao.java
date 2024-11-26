package com.java.PetPals.Dao;

import java.sql.SQLException;

public interface sheltersDao {

	boolean addShelters(int sid, String name, String location) throws ClassNotFoundException, SQLException;

}
