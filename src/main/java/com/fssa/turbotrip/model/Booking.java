package com.fssa.turbotrip.model;

public class Booking {
	private String pickup_location;
	private String drop_location;
	private boolean request_status;
	private boolean accept_status;
	private int driver_id;
	private int user_id;
	private int seat;
	private String booking_date;
	private String booking_time;

	public Booking() {
		
	}
	
	public Booking(String pickup_location, String drop_location, String booking_time, String booking_date, int seat) {
		super();
		this.pickup_location = pickup_location;
		this.drop_location = drop_location;
		this.booking_time = booking_time;
		this.booking_date = booking_date;
		this.seat = seat;
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
	 * @return the request_status
	 */
	public boolean getRequest_status() {
		return request_status;
	}

	/**
	 * @param request_status the request_status to set
	 */
	public void setRequest_status(boolean request_status) {
		this.request_status = request_status;
	}

	/**
	 * @return the accept_status
	 */
	public boolean getAccept_status() {
		return accept_status;
	}

	/**
	 * @param accept_status the accept_status to set
	 */
	public void setAccept_status(boolean accept_status) {
		this.accept_status = accept_status;
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
	 * @return the seat
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * @param seat the seat to set
	 */
	public void setSeat(int seat) {
		this.seat = seat;
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
