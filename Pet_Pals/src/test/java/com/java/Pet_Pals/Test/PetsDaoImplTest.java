package com.java.Pet_Pals.Test;

import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.java.Pet_Pals.Dao.PetsDaoImpl;
import com.java.Pet_Pals.model.AvailableForAdoption;
import com.java.Pet_Pals.model.Pets;

public class PetsDaoImplTest {
    @Mock
    private PetsDaoImpl petsDao;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowPets() throws SQLException, ClassNotFoundException {
        List<Pets> mockPetsList = new ArrayList<>();
        Pets pet = new Pets(1, "Max", 3, "Labrador", "Dog", AvailableForAdoption.YES, 101);
        mockPetsList.add(pet);
        when(petsDao.ShowPets()).thenReturn(mockPetsList);
        petsDao.ShowPets(); 
    }

    @Test
    public void testSearchByPetBreed() throws SQLException, ClassNotFoundException {
        String breed = "Labrador";
        Pets pet = new Pets(1, "Max", 3, breed, "Dog", AvailableForAdoption.YES, 101);
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
        List<Pets> mockPetsList = new ArrayList<>();
        Pets pet = new Pets(1, "Max", 3, "Labrador", type, AvailableForAdoption.YES, 101);
        mockPetsList.add(pet);
        when(petsDao.serachByType(type)).thenReturn(mockPetsList);
        petsDao.serachByType(type); 
    }
}
