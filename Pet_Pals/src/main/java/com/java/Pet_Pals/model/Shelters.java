package com.java.Pet_Pals.model;

public class Shelters {
	private int Shelter_ID;
	private String Name;
	private String Location;
	public int getShelter_ID() {
		return Shelter_ID;
	}
	public void setShelter_ID(int Shelter_ID) {
		this.Shelter_ID = Shelter_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	@Override
	public String toString() {
		return "Shelters [Shelter_ID=" + Shelter_ID + ", Name=" + Name + ", Location=" + Location + "]";
	}
	public Shelters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shelters(int Shelter_ID, String Name, String Location) {
		super();
		this.Shelter_ID = Shelter_ID;
		this.Name = Name;
		this.Location = Location;
	}
	
}
