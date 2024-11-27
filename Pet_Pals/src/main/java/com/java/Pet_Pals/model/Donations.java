package com.java.Pet_Pals.model;

import java.sql.Date;
//import java.util.DateTime;

public class Donations {
	private int Donation_ID;
	private String Donar_Name;
	private DonationType Donation_Type;
	private double Donation_Amount;
	private String Donation_Item;
	private Date Donation_Date;
	public int getDonation_ID() {
		return Donation_ID;
	}
	public void setDonation_ID(int Donation_ID) {
		this.Donation_ID = Donation_ID;
	}
	public String getDonar_Name() {
		return Donar_Name;
	}
	public void setDonar_Name(String Donar_Name) {
		this.Donar_Name = Donar_Name;
	}
	public DonationType getDonation_Type() {
		return Donation_Type;
	}
	public void setDonation_Type(DonationType Donation_Type) {
		this.Donation_Type = Donation_Type;
	}
	public double getDonation_Amount() {
		return Donation_Amount;
	}
	public void setDonation_Amount(double Donation_Amount) {
		this.Donation_Amount = Donation_Amount;
	}
	public String getDonation_Item() {
		return Donation_Item;
	}
	public void setDonation_Item(String Donation_Item) {
		this.Donation_Item = Donation_Item;
	}
	public Date getDonation_Date() {
		return Donation_Date;
	}
	public void setDonation_Date(Date Donation_Date) {
		this.Donation_Date = Donation_Date;
	}
	@Override
	public String toString() {
		return "Donations [Donation_ID=" + Donation_ID + ", Donar_Name=" + Donar_Name + ", Donation_Type="
				+ Donation_Type + ", Donation_Amount=" + Donation_Amount + ", Donation_Item=" + Donation_Item
				+ ", Donation_Date=" + Donation_Date + "]";
	}
	public Donations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donations(int Donation_ID, String Donar_Name, com.java.Pet_Pals.model.DonationType Donation_Type,
			double Donation_Amount, String Donation_Item, Date Donation_Date) {
		super();
		this.Donation_ID = Donation_ID;
		this.Donar_Name = Donar_Name;
		this.Donation_Type = Donation_Type;
		this.Donation_Amount = Donation_Amount;
		this.Donation_Item = Donation_Item;
		this.Donation_Date = Donation_Date;
	}
	
}
