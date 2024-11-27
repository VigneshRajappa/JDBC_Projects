package com.java.Pet_Pals.Test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.java.Pet_Pals.Dao.ParticipantsDao;
import com.java.Pet_Pals.Dao.ParticipantsDaoImpl;
import com.java.Pet_Pals.model.Participants;

public class ParticipantsDaoImplTest {

    private ParticipantsDao participantsDao;

    @Before
    public void setUp() {
        participantsDao = new ParticipantsDaoImpl();
    }

    @Test
    public void testShowEventByPartId() throws SQLException, ClassNotFoundException {
        int participantId = 1; // Use a valid participant ID from your database for testing
        Participants participant = participantsDao.ShowEventByPartId(participantId);
    }

    @Test
    public void testInsertPart() throws SQLException, ClassNotFoundException {
        int participantId = 10; // Use a valid ID for inserting a participant
        String participantName = "Jane Doe";
        String participantType = "Volunteer";
        int eventId = 2; 
        Participants insertedParticipant = participantsDao.ShowEventByPartId(participantId);

    }
}
