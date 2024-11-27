package com.java.Pet_Pals.Dao;

import java.sql.SQLException;

public interface SheltersDao {

	boolean addShelters(int sid, String name, String location) throws ClassNotFoundException, SQLException;

}
