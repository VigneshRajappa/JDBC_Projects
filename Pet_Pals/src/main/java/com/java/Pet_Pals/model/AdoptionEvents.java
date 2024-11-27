package com.java.Pet_Pals.model;

import java.sql.Date;

public class AdoptionEvents {
	private int Event_ID;
	private String Event_Name;
	private Date Event_Date;
	private String Location;
	public int getEvent_ID() {
		return Event_ID;
	}
	public void setEvent_id(int Event_ID) {
		this.Event_ID = Event_ID;
	}
	public String getEvent_name() {
		return Event_Name;
	}
	public void setEvent_name(String Event_Name) {
		this.Event_Name = Event_Name;
	}
	public Date getEvent_date() {
		return Event_Date;
	}
	public void setEvent_date(Date Event_Date) {
		this.Event_Date = Event_Date;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	@Override
	public String toString() {
		return "Adoption_Events [Event_ID=" + Event_ID + ", Event_Name=" + Event_Name + ", Event_Date=" + Event_Date
				+ ", Location=" + Location + "]";
	}
	public AdoptionEvents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdoptionEvents(int Event_ID, String Event_Name, Date Event_Date, String Location) {
		super();
		this.Event_ID = Event_ID;
		this.Event_Name = Event_Name;
		this.Event_Date = Event_Date;
		this.Location = Location;
	}
	
}
