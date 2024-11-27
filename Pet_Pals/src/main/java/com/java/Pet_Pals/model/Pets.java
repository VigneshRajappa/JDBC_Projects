package com.java.Pet_Pals.model;

public class Pets {
	private int Pet_ID;
	private String Name;
	private int Age;
	private String Breed;
	private String Type;
	private AvailableForAdoption Available_For_Adoption;
	private int Owner_ID;
	public int getPet_ID() {
		return Pet_ID;
	}
	public void setPet_ID(int Pet_ID) {
		this.Pet_ID = Pet_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	public String getBreed() {
		return Breed;
	}
	public void setBreed(String Breed) {
		this.Breed = Breed;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public AvailableForAdoption getAvailable_For_Adoption() {
		return Available_For_Adoption;
	}
	public void setAvailable_For_Adoption(AvailableForAdoption Available_For_Adoption) {
		this.Available_For_Adoption = Available_For_Adoption;
	}
	public int getOwner_ID() {
		return Owner_ID;
	}
	public void setOwner_ID(int Owner_ID) {
		this.Owner_ID = Owner_ID;
	}
	@Override
	public String toString() {
		return "Pets [Pet_ID=" + Pet_ID + ", Name=" + Name + ", Age=" + Age + ", Breed=" + Breed + ", Type=" + Type
				+ ", Available_For_Adoption=" + Available_For_Adoption + ", Owner_ID=" + Owner_ID + "]";
	}
	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pets(int Pet_ID, String Name, int Age, String Breed, String Type,
			com.java.Pet_Pals.model.AvailableForAdoption Available_For_Adoption, int Owner_ID) {
		super();
		this.Pet_ID = Pet_ID;
		this.Name = Name;
		this.Age = Age;
		this.Breed = Breed;
		this.Type = Type;
		this.Available_For_Adoption = Available_For_Adoption;
		this.Owner_ID = Owner_ID;
	}
	public String getBreed1() {
	    return this.Breed;
	}

	
}
