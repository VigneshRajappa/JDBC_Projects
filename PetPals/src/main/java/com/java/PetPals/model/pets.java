package com.java.PetPals.model;

public class pets {
	private int pet_id;
	private String name;
	private int age;
	private String breed;
	private String type;
	private availableforadoption availableforadoption;
	private int ownerid;
	public int getPet_id() {
		return pet_id;
	}
	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public availableforadoption getAvailableforadoption() {
		return availableforadoption;
	}
	public void setAvailableforadoption(availableforadoption availableforadoption) {
		this.availableforadoption = availableforadoption;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	@Override
	public String toString() {
		return "pets [pet_id=" + pet_id + ", name=" + name + ", age=" + age + ", breed=" + breed + ", type=" + type
				+ ", availableforadoption=" + availableforadoption + ", ownerid=" + ownerid + "]";
	}
	public pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pets(int pet_id, String name, int age, String breed, String type,
			com.java.PetPals.model.availableforadoption availableforadoption, int ownerid) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.type = type;
		this.availableforadoption = availableforadoption;
		this.ownerid = ownerid;
	}
	public String getBreed1() {
	    return this.breed;
	}

	
}
