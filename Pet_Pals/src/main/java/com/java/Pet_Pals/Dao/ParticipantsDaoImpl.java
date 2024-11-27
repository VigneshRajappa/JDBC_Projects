package com.java.Pet_Pals.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.java.Pet_Pals.model.Participants;
import com.java.Pet_Pals.util.ConnectionHelper;

public class ParticipantsDaoImpl implements ParticipantsDao {
	Connection connection;
	PreparedStatement pst;
	@Override
	public Participants ShowEventByPartId(int eid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select p.participant_id,p.event_id,e.event_name from participants as p "
				+"join adoption_events as e on e.event_id=p.event_id where p.participant_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, eid);
		ResultSet rs = pst.executeQuery();
		Participants ds = null;
		while(rs.next()) {
			ds = new Participants();
			ds.setParticipant_ID(rs.getInt("Participant_ID"));
			//ds.setParticipant_Name(rs.getString("Participant_Name"));
			ds.setEvent_ID(rs.getInt("Event_ID"));
			ds.setEvent_Name(rs.getString("Event_Name"));
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
