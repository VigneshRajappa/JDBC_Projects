package com.java.Pet_Pals.Dao;

import java.sql.SQLException;

import com.java.Pet_Pals.model.Participants;

public interface ParticipantsDao 
{
	Participants ShowEventByPartId(int eid) throws ClassNotFoundException, SQLException;

	boolean InsertPart(int pid, String pname, String ptype, int eid) throws ClassNotFoundException, SQLException;

}
