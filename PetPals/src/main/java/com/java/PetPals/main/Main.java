package com.java.PetPals.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.java.PetPals.Dao.petsDao;
import com.java.PetPals.Dao.petsDaoImpl;
import com.java.PetPals.model.pets;
import com.java.PetPals.Dao.sheltersDao;
import com.java.PetPals.Dao.sheltersDaoImpl;
import com.java.PetPals.Dao.donationsDao;
import com.java.PetPals.Dao.donationsDaoImpl;
import com.java.PetPals.model.donations;
import com.java.PetPals.Dao.participantsDao;
import com.java.PetPals.Dao.participantsDaoImpl;
import com.java.PetPals.model.participants;


public class Main {
	static Scanner sc=new Scanner(System.in);
	static petsDao petdao=new petsDaoImpl();
	static sheltersDao sDao=new sheltersDaoImpl();
	static donationsDao donDao=new donationsDaoImpl();
	static participantsDao partDao=new participantsDaoImpl();
	private static void addpets() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Pet ID : ");
		int pid=sc.nextInt();
		System.out.println("Enter Name : ");
		String name=sc.next();
		System.out.println("Enter Age : ");
		int age=sc.nextInt();
		System.out.println("Enter Breed : ");
		String breed=sc.next();
		System.out.println("Enter Type : ");
		String type=sc.next();
		System.out.println("Enter Availability for Adoption : ");
		String available=sc.next();
		System.out.println("Enter Owner ID : ");
		int oid=sc.nextInt();
		boolean pet=petdao.insertpets(pid,name,age,breed,type,available,oid);
		if(pet) {
			System.out.println("Value Inserted ");
		}
		else {
			System.out.println("Can't insert");
		}	
	}
	public static void showpets() throws ClassNotFoundException, SQLException {
		List<pets> plist=petdao.ShowPets();
		for(pets pt:plist) {
			System.out.println(pt);
		}
	}
	public static void searchByBreed() throws ClassNotFoundException, SQLException {
		System.out.println("Enter breed Name : ");
		String breed=sc.next();
		pets pet=petdao.searchByPetBreed(breed);
		if(pet!=null) {
			System.out.println(pet);
		}
		else {
			System.out.println("*** No Valies Available ***");
		}
	}
	public static void searchbytype() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Type :");
		String type=sc.next();
		List<pets> pet=petdao.serachByType(type);
		if(pet!=null) {
			for(pets pt:pet)
			System.out.println(pt);
		}
		else {
			System.out.println("No Available Values");
		}
	}
	public static void addshelter() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Shelter ID : ");
		int sid=sc.nextInt();
		System.out.println("Enter name : ");
		String name=sc.next();
		System.out.println("Enter Location : ");
		String Location=sc.next();
		boolean obj=sDao.addShelters(sid,name,Location);
		if(obj) {
			System.out.println("Value Inserted ");
		}
		else {
			System.out.println("Can't insert");
		}
	}
	public static void showdonation() throws ClassNotFoundException, SQLException {
		List<donations> obj=donDao.ShowDonation();
		for(donations ds:obj) {
			System.out.println(ds);
		}
	}
	public static void insertdonations() throws ParseException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Enter Donation ID : ");
		int did=sc.nextInt();
		System.out.println("Enter Donor Name : ");
		String dname=sc.next();
		System.out.println("Donation Type : ");
		String dtype=sc.next();
		System.out.println("Enter Donation Amount : ");
		double damount=sc.nextDouble();
		System.out.println("Enter Donation Item : ");
		String ditem=sc.next();
		System.out.println("Enter Donation Date : ");
		Date ddate=sdf.parse(sc.next());
		java.sql.Date sqlDonationDate = new java.sql.Date(ddate.getTime());
		boolean ds=donDao.InsertDonation(did,dname,dtype,damount,ditem,sqlDonationDate);
		if(ds) {
			System.out.println("Value Inserted");
		}
		else {
			System.out.println("Can't Insert");
		}
	}
	public static void searchByDonationID() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Donation ID : ");
		int did=sc.nextInt();
		donations ds=donDao.SearchByDonationID(did);
		if(ds!=null) {
			System.out.println(ds);
		}
		else {
			System.out.println("*** No value Detected ***");
		}
	}

	public static void showpartbyevent() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Event ID : ");
		int eid=sc.nextInt();
		participants ps=partDao.ShowByEventId(eid);
		if(ps!=null) {
			System.out.println(ps);
		}
		else {
			System.out.println("Value Not Available");
		}
	}
	public static void addPart() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Participant Id : ");
		int pid=sc.nextInt();
		System.out.println("Enter Particiapant Name : ");
		String pname=sc.next();
		System.out.println("Enter Participant Type :");
		String ptype=sc.next();
		System.out.println("Enter Event ID : ");
		int eid=sc.nextInt();
		boolean ps=partDao.InsertPart(pid,pname,ptype,eid);
		if(ps) {
			System.out.println("Value Inserted");
		}
		else {
			System.out.println("Can't insert");
		}
	}
	public static void main(String[] args) {
		int i=0;
		do {
		int choice;
		System.out.println("1.Add Pets : ");
		System.out.println("2.Show Pets : ");
		System.out.println("3.Search By Breed : ");
		System.out.println("4.Search by Type : ");
		System.out.println("5.Add Shelter : ");
		System.out.println("6.show donations : ");
		System.out.println("7. add donations : ");
		System.out.println("8. search by donation ID : ");
		System.out.println("9. show all events by participant ID : ");
		System.out.println("10. add participant : ");
		choice=sc.nextInt();
		i++;
		switch(choice){
		case 1:
			try {
				addpets();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				showpets();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				searchByBreed();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				searchbytype();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				addshelter();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			try {
				showdonation();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			try {
				insertdonations();
			} catch (ClassNotFoundException | ParseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 8:
			try {
				searchByDonationID();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 9:
			try {
				showpartbyevent();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 10:
			try {
				addPart();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}}while(i<=10);
	}	
}
