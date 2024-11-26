package com.java.PetPals.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.java.PetPals.Dao.participantsDaoImpl;

import org.junit.jupiter.api.Test;

class participants {

	@Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private participantsDaoImpl participantsDao;

    @BeforeEach
    void setUp() throws SQLException {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
        participantsDao = new participantsDaoImpl();

        // Mock connection behavior
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    void testShowByEventId() throws SQLException, ClassNotFoundException {
        // Simulate ResultSet behavior
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Simulate one result returned
        
        // Set the mock result set data
        when(mockResultSet.getInt("participant_id")).thenReturn(1);
        when(mockResultSet.getInt("event_id")).thenReturn(101);
        when(mockResultSet.getString("event_name")).thenReturn("Pet Adoption Event");

        // Call the method to test
        com.java.PetPals.model.participants result = participantsDao.ShowByEventId(101);

        // Verify that the data is returned correctly
        assertNotNull(result);
        assertEquals(1, result.getParticipant_id());
        assertEquals(101, result.getEvent_id());
        assertEquals("Pet Adoption Event", result.getEvent_name());
    }

    @Test
    void testShowByEventId_NoResults() throws SQLException, ClassNotFoundException {
        // Simulate no result returned for the given event ID
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);  // No results found

        // Call the method to test
        com.java.PetPals.model.participants result = participantsDao.ShowByEventId(999);

        // Verify that no participant is returned
        assertNull(result);
    }

    @Test
    void testInsertPart() throws SQLException, ClassNotFoundException {
        // Simulate prepared statement execution
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Assume 1 row is inserted

        // Input data
        int pid = 1;
        String pname = "John Doe";
        String ptype = "Volunteer";
        int eid = 101;

        // Call the method to test
        boolean result = participantsDao.InsertPart(pid, pname, ptype, eid);

        // Assert that the participant was successfully inserted
        assertTrue(result);

        // Verify that the PreparedStatement was used with the correct parameters
        verify(mockPreparedStatement).setInt(1, pid);
        verify(mockPreparedStatement).setString(2, pname);
        verify(mockPreparedStatement).setString(3, ptype);
        verify(mockPreparedStatement).setInt(4, eid);
    }


}
