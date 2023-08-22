package com.fssa.turbotrip.model;

public class Driver {
	private long aadhar_number;
	private String licensence_number;
	private int experience;
private int id; 
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public Driver (long aadhar_number, String licensence_number, int experience, int id ) {
		super();
		this.aadhar_number = aadhar_number;
		this.licensence_number = licensence_number;
		this.experience = experience;
		this.id=id;
}

	public long getAadhar_number() {
		return aadhar_number;
	}

	public void setAadhar_number(long aadhar_number) {
		this.aadhar_number = aadhar_number;
	}

	public String getLicensence_number() {
		return licensence_number;
	}

	public void setLicensence_number(String licensence_number) {
		this.licensence_number = licensence_number;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	}
