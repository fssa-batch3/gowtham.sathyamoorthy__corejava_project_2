package com.fssa.turbotrip.model;

public class Booking {
	private int booking_id;
	private String pickup_location;
	private String drop_location;
	private String status;
	private int driver_id;
	private int user_id;
	private int no_of_seat;
	private String booking_date;
	private String booking_time;
	private String otp;

//	public Booking(int userId, String pickup, String drop, String book_time, String book_date, int seat) {
//		
//		
//		
//		
//	}

	/**
	 * @return the otp
	 */
	public String getOtp() {
		return otp;
	}

	/**
	 * @param otp the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int userId, String pickup, String drop, String book_time, String book_date, int seat) {

		this.drop_location = drop;
		this.pickup_location = pickup;
		this.user_id = userId;
		this.no_of_seat = seat;
		this.booking_date = book_date;
		this.booking_time = book_time;
	}
	
	public Booking(int driverId, String otp) {

		this.driver_id = driverId;
		this.otp = otp;
		
	}
	
	public Booking(int driverId, String otp, int booking_id) {

		this.driver_id = driverId;
		this.otp = otp;
		this.booking_id = booking_id;
	}
	
	
	public Booking(int booking_id,int userId, String pickup, String drop, String book_time, String book_date, int seat) {
this.booking_id = booking_id;
		this.drop_location = drop;
		this.pickup_location = pickup;
		this.user_id = userId;
		this.no_of_seat = seat;
		this.booking_date = book_date;
		this.booking_time = book_time;
	}

	/**
	 * @return the booking_id
	 */
	public int getBooking_id() {
		return booking_id;
	}

	/**
	 * @param booking_id the booking_id to set
	 */
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	/**
	 * @return the pickup_location
	 */
	public String getPickup_location() {
		return pickup_location;
	}

	/**
	 * @param pickup_location the pickup_location to set
	 */
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}

	/**
	 * @return the drop_location
	 */
	public String getDrop_location() {
		return drop_location;
	}

	/**
	 * @param drop_location the drop_location to set
	 */
	public void setDrop_location(String drop_location) {
		this.drop_location = drop_location;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the driver_id
	 */
	public int getDriver_id() {
		return driver_id;
	}

	/**
	 * @param driver_id the driver_id to set
	 */
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the no_of_seat
	 */
	public int getNo_of_seat() {
		return no_of_seat;
	}

	/**
	 * @param no_of_seat the no_of_seat to set
	 */
	public void setNo_of_seat(int no_of_seat) {
		this.no_of_seat = no_of_seat;
	}

	/**
	 * @return the booking_date
	 */
	public String getBooking_date() {
		return booking_date;
	}

	/**
	 * @param booking_date the booking_date to set
	 */
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	/**
	 * @return the booking_time
	 */
	public String getBooking_time() {
		return booking_time;
	}

	/**
	 * @param booking_time the booking_time to set
	 */
	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}

}
