package com.java.PetPals.model;

import java.sql.Date;
//import java.util.DateTime;

public class donations {
	private int donation_id;
	private String donor_name;
	private donation_type donation_type;
	private double donation_amount;
	private String donation_item;
	private Date donation_date;
	public int getDonation_id() {
		return donation_id;
	}
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public donation_type getDonation_type() {
		return donation_type;
	}
	public void setDonation_type(donation_type donation_type) {
		this.donation_type = donation_type;
	}
	public double getDonation_amount() {
		return donation_amount;
	}
	public void setDonation_amount(double donation_amount) {
		this.donation_amount = donation_amount;
	}
	public String getDonation_item() {
		return donation_item;
	}
	public void setDonation_item(String donation_item) {
		this.donation_item = donation_item;
	}
	public Date getDonation_date() {
		return donation_date;
	}
	public void setDonation_date(Date donation_date) {
		this.donation_date = donation_date;
	}
	@Override
	public String toString() {
		return "donations [donation_id=" + donation_id + ", donor_name=" + donor_name + ", donation_type="
				+ donation_type + ", donation_amount=" + donation_amount + ", donation_item=" + donation_item
				+ ", donation_date=" + donation_date + "]";
	}
	public donations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public donations(int donation_id, String donor_name, com.java.PetPals.model.donation_type donation_type,
			double donation_amount, String donation_item, Date donation_date) {
		super();
		this.donation_id = donation_id;
		this.donor_name = donor_name;
		this.donation_type = donation_type;
		this.donation_amount = donation_amount;
		this.donation_item = donation_item;
		this.donation_date = donation_date;
	}
	
}
