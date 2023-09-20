 package com.fssa.turbotrip.model;



public class Car {

	@Override
	public String toString() {
		return "Car [carmodel=" + carmodel + ", carImage=" + carImage + ", carNo=" + carNo + ", description="
				+ description + ", getCarmodel()=" + getCarmodel() + ", getCarImage()=" + getCarImage()
				+ ", getCarNo()=" + getCarNo() + ", getDescription()=" + getDescription() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return car_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
//	public void setUser_id(int user_id) {
//		this.car_id = car_id;
//	}

	private String carmodel;
	private String carImage;
	private String carNo;
	private String description;
	private int driver_id;
	private int car_id;

	public Car(String carNo) {
		this.carNo = carNo;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getCarId() {
		return car_id;
	}

	public Car(String carImage, String description) {
		super();

		this.carImage = carImage;

		this.description = description;
	}

	public Car(int driver_id, String carNo, String carmodel, String carImage, String description) {
		super();
		this.driver_id =  driver_id;
		this.carmodel = carmodel;
		this.carImage = carImage;
		this.carNo = carNo;
		this.description = description;
	}
	// This is getters and setters for CarModel

	public Car() {
		
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public int getUserId() {
		return driver_id;
	}

	public void setUserId(int driver_id) {
		this.driver_id = driver_id;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo; 
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
