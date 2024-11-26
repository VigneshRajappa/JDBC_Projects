package com.java.PetPals.Dao;

import java.sql.SQLException;

import com.java.PetPals.model.participants;

public interface participantsDao {

	participants ShowByEventId(int eid) throws ClassNotFoundException, SQLException;

	boolean InsertPart(int pid, String pname, String ptype, int eid) throws ClassNotFoundException, SQLException;

}
