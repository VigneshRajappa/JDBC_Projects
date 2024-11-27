package com.java.Pet_Pals.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.java.Pet_Pals.Dao.PetsDao;
import com.java.Pet_Pals.Dao.DonationsDao;
import com.java.Pet_Pals.Dao.DonationsDaoImpl;
import com.java.Pet_Pals.Dao.ParticipantsDao;
import com.java.Pet_Pals.Dao.ParticipantsDaoImpl;
import com.java.Pet_Pals.Dao.PetsDaoImpl;
import com.java.Pet_Pals.Dao.SheltersDao;
import com.java.Pet_Pals.Dao.SheltersDaoImpl;
import com.java.Pet_Pals.model.Donations;
import com.java.Pet_Pals.model.Participants;
import com.java.Pet_Pals.model.Pets;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PetsDao petdao = new PetsDaoImpl();
    static SheltersDao sDao = new SheltersDaoImpl();
    static DonationsDao donDao = new DonationsDaoImpl();
    static ParticipantsDao partDao = new ParticipantsDaoImpl();

    // Method to add pets
    private static void addpets() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Pet ID : ");
        int pid = sc.nextInt();
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter Age : ");
        int age = sc.nextInt();
        System.out.println("Enter Breed : ");
        String breed = sc.next();
        System.out.println("Enter Type : ");
        String type = sc.next();
        System.out.println("Enter Availability for Adoption : ");
        String available = sc.next();
        System.out.println("Enter Owner ID : ");
        int oid = sc.nextInt();
        boolean pet = petdao.insertpets(pid, name, age, breed, type, available, oid);
        if (pet) {
            System.out.println("\nValue Inserted\n");
        } else {
            System.out.println("\nCan't insert\n");
        }
    }

    // Method to show pets
    public static void showpets() throws ClassNotFoundException, SQLException {
        List<Pets> plist = petdao.ShowPets();
        for (Pets pt : plist) {
            System.out.println(pt);
        }
    }

    // Method to search pets by breed
    public static void searchByBreed() throws ClassNotFoundException, SQLException {
        System.out.println("Enter breed Name : ");
        String breed = sc.next();
        Pets pet = petdao.searchByPetBreed(breed);
        if (pet != null) {
            System.out.println(pet);
        } else {
            System.out.println("*** No Values Available ***");
        }
    }

    // Method to search pets by type
    public static void searchbytype() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Type :");
        String type = sc.next();
        List<Pets> pet = petdao.serachByType(type);
        if (pet != null) {
            for (Pets pt : pet)
                System.out.println(pt);
        } else {
            System.out.println("No Available Values");
        }
    }

    // Method to add shelters
    public static void addshelter() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Shelter ID : ");
        int sid = sc.nextInt();
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter Location : ");
        String Location = sc.next();
        boolean obj = sDao.addShelters(sid, name, Location);
        if (obj) {
            System.out.println("Value Inserted");
        } else {
            System.out.println("Can't insert");
        }
    }

    // Method to show donations
    public static void showdonation() throws ClassNotFoundException, SQLException {
        List<Donations> obj = donDao.ShowDonation();
        for (Donations ds : obj) {
            System.out.println(ds);
        }
    }

    // Method to insert donations
    public static void insertdonations() throws ParseException, ClassNotFoundException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter Donation ID : ");
        int did = sc.nextInt();
        System.out.println("Enter Donor Name : ");
        String dname = sc.next();
        System.out.println("Donation Type : ");
        String dtype = sc.next();
        System.out.println("Enter Donation Amount : ");
        double damount = sc.nextDouble();
        System.out.println("Enter Donation Item : ");
        String ditem = sc.next();
        System.out.println("Enter Donation Date : ");
        Date ddate = sdf.parse(sc.next());
        java.sql.Date sqlDonationDate = new java.sql.Date(ddate.getTime());
        boolean ds = donDao.InsertDonation(did, dname, dtype, damount, ditem, sqlDonationDate);
        if (ds) {
            System.out.println("Value Inserted");
        } else {
            System.out.println("Can't Insert");
        }
    }

    // Method to search donation by ID
    public static void searchByDonationID() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Donation ID : ");
        int did = sc.nextInt();
        Donations ds = donDao.SearchByDonationID(did);
        if (ds != null) {
            System.out.println(ds);
        } else {
            System.out.println("*** No value Detected ***");
        }
    }

    // Method to show events by Participant ID
    public static void showeventtbypartid() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Participant ID : ");
        int eid = sc.nextInt();
        Participants ps = partDao.ShowEventByPartId(eid);
        if (ps != null) {
            System.out.println(ps);
        } else {
            System.out.println("Value Not Available");
        }
    }

    // Method to add participant
    public static void addPart() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Participant Id : ");
        int pid = sc.nextInt();
        System.out.println("Enter Participant Name : ");
        String pname = sc.next();
        System.out.println("Enter Participant Type :");
        String ptype = sc.next();
        System.out.println("Enter Event ID : ");
        int eid = sc.nextInt();
        boolean ps = partDao.InsertPart(pid, pname, ptype, eid);
        if (ps) {
            System.out.println("Value Inserted");
        } else {
            System.out.println("Can't insert");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Pets : ");
            System.out.println("2. Show Pets : ");
            System.out.println("3. Search By Breed : ");
            System.out.println("4. Search By Type : ");
            System.out.println("5. Add Shelter : ");
            System.out.println("6. Show Donation : ");
            System.out.println("7. Add Donation : ");
            System.out.println("8. Search By Donation Id : ");
            System.out.println("9. Show all events by Participant ID : ");
            System.out.println("10. Add Participant : ");
            System.out.println("\nSelect your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addpets();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        showpets();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        searchByBreed();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        searchbytype();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        addshelter();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        showdonation();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        insertdonations();
                    } catch (ClassNotFoundException | ParseException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    try {
                        searchByDonationID();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        showeventtbypartid();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    try {
                        addPart();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}
