package com.java.PetPals.model;

import java.sql.Date;

public class Adoption_Events {
	private int event_id;
	private String event_name;
	private Date event_date;
	private String location;
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Adoption_Events [event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date
				+ ", location=" + location + "]";
	}
	public Adoption_Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adoption_Events(int event_id, String event_name, Date event_date, String location) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_date = event_date;
		this.location = location;
	}
	
}
