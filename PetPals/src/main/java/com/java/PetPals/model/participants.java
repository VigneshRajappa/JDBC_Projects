package com.java.PetPals.model;

public class participants {
	private int participant_id;
	private String participant_name;
	private String particicpant_type;
	private int event_id;
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	public String getParticicpant_type() {
		return particicpant_type;
	}
	public void setParticicpant_type(String particicpant_type) {
		this.particicpant_type = particicpant_type;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	@Override
	public String toString() {
		return "participants [participant_id=" + participant_id + ", participant_name=" + participant_name
				+ ", particicpant_type=" + particicpant_type + ", event_id=" + event_id + "]";
	}
	public participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public participants(int participant_id, String participant_name, String particicpant_type, int event_id) {
		super();
		this.participant_id = participant_id;
		this.participant_name = participant_name;
		this.particicpant_type = particicpant_type;
		this.event_id = event_id;
	}
	public void setEvent_name(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
