package com.java.PetPals.Test;

import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.java.PetPals.Dao.petsDaoImpl;
import com.java.PetPals.model.availableforadoption;
import com.java.PetPals.model.pets;
public class pets {

	@Mock
    private petsDaoImpl petsDao;
    public pets(int i, String string, int j, String string2, String string3, availableforadoption yes, int k) {
		// TODO Auto-generated constructor stub
	}

	@Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowPets() throws SQLException, ClassNotFoundException {
        List<com.java.PetPals.model.pets> mockPetsList = new ArrayList<>();
        pets pet = new pets(1, "Max", 3, "Labrador", "Dog", availableforadoption.YES, 101);
        mockPetsList.insertpets(pet);
        when(petsDao.ShowPets()).thenReturn(mockPetsList);
        petsDao.ShowPets(); 
    }

    @Test
    public void testSearchByPetBreed() throws SQLException, ClassNotFoundException {
        String breed = "Labrador";
        com.java.PetPals.model.pets pet = new pets(1, "Max", 3, breed, "Dog", availableforadoption.YES, 101);
        when(petsDao.searchByPetBreed(breed)).thenReturn(pet);
        petsDao.searchByPetBreed(breed); 
    }

    @Test
    public void testInsertPets() throws SQLException, ClassNotFoundException {
        int petId = 2;
        String name = "Bella";
        int age = 2;
        String breed = "Golden Retriever";
        String type = "Dog";
        String available = "YES";
        int ownerId = 102;
        when(petsDao.insertpets(petId, name, age, breed, type, available, ownerId)).thenReturn(true);
        petsDao.insertpets(petId, name, age, breed, type, available, ownerId); 
    }

    @Test
    public void testSearchByType() throws SQLException, ClassNotFoundException {
        String type = "Dog";
        List<com.java.PetPals.model.pets> mockPetsList = new ArrayList<>();
        pets pet = new pets(1, "Max", 3, "Labrador", type, availableforadoption.YES, 101);
        mockPetsList.insertpets(pet);
        when(petsDao.serachByType(type)).thenReturn(mockPetsList);
        petsDao.serachByType(type); 
    }
}
