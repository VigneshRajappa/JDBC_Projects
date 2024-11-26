package com.java.PetPals.model;

public class shelters {
	private int shelter_id;
	private String name;
	private String location;
	public int getShelter_id() {
		return shelter_id;
	}
	public void setShelter_id(int shelter_id) {
		this.shelter_id = shelter_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "shelters [shelter_id=" + shelter_id + ", name=" + name + ", location=" + location + "]";
	}
	public shelters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public shelters(int shelter_id, String name, String location) {
		super();
		this.shelter_id = shelter_id;
		this.name = name;
		this.location = location;
	}
	
}
