package com.java.Pet_Pals.model;

public class Participants {
	private int Participant_ID;
	private String Participant_Name;
	private String Participant_Type;
	private int Event_ID;
	public int getParticipant_ID() {
		return Participant_ID;
	}
	public void setParticipant_ID(int Participant_ID) {
		this.Participant_ID = Participant_ID;
	}
	public String getParticipant_Name() {
		return Participant_Name;
	}
	public void setParticipant_Name(String Participant_Name) {
		this.Participant_Name = Participant_Name;
	}
	public String getParticipant_Type() {
		return Participant_Name;
	}
	public void setParticipant_Type(String Participant_Type) {
		this.Participant_Name = Participant_Type;
	}
	public int getEvent_ID() {
		return Event_ID;
	}
	public void setEvent_ID(int Event_ID) {
		this.Event_ID = Event_ID;
	}
	@Override
	public String toString() {
		return "Participants [Participant_ID=" + Participant_ID + ", Participant_Name=" + Participant_Name
				+ ", Participant_Type=" + Participant_Type + ", Event_ID=" + Event_ID + "]";
	}
	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participants(int Participant_ID, String Participant_Name, String Participant_Type, int Event_ID) {
		super();
		this.Participant_ID = Participant_ID;
		this.Participant_Name = Participant_Name;
		this.Participant_Type = Participant_Type;
		this.Event_ID = Event_ID;
	}
	public void setEvent_Name(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
