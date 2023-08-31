package com.fssa.turbotrip.model;

public class Driver {
	private long aadharNumber;
	private String licenseNumber;
	private int experience;
private int id; 
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public Driver (int id, long aadhar_number, String licensence_number, int experience ) {
		super();
		this.id = id;
		this.aadharNumber = aadhar_number;
		this.licenseNumber = licensence_number;
		this.experience = experience;
}
	// This is getters and setters for DriverModel

	public long getAadhar_number() {
		return aadharNumber;
	}

	public void setAadhar_number(long aadhar_number) {
		this.aadharNumber = aadhar_number;
	}

	public String getLicensence_number() {
		return licenseNumber;
	}

	public void setLicensence_number(String licensence_number) {
		this.licenseNumber = licensence_number;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	}
