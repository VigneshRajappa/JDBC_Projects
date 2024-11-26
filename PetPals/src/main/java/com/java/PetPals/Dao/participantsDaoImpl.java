package com.java.PetPals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.java.PetPals.model.participants;
import com.java.PetPals.util.ConnectionHelper;

public class participantsDaoImpl implements participantsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public participants ShowByEventId(int eid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select p.participant_id,p.event_id,e.event_name from participants as p "
				+"join adoption_events as e on e.event_id=p.event_id where p.event_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, eid);
		ResultSet rs = pst.executeQuery();
		participants ds = null;
		while(rs.next()) {
			ds = new participants();
			ds.setParticipant_id(rs.getInt("participant_id"));
			ds.setEvent_id(rs.getInt("event_id"));
			ds.setEvent_name(rs.getString("event_name"));
		}
		return ds;
	}
	@Override
	public boolean InsertPart(int pid, String pname, String ptype, int eid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into participants(participant_id,participant_name,participant_type,event_id)"
				+ " values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, pid);
		pst.setString(2, pname);
		pst.setString(3,ptype);
		pst.setInt(4, eid);
		pst.executeUpdate();
		return true;
	}

}
