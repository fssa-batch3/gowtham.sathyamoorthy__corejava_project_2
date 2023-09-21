package com.fssa.turbotrip.validation;

import java.util.regex.Pattern;

import com.fssa.turbotrip.model.Booking;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.validation.exception.InvalidBookingException;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

public class BookingValidator {
	public static boolean validatebooking(Booking book) throws InvalidBookingException {

		if (book != null && validatepickup(book.getPickup_location()) && validatedrop(book.getDrop_location())
				&& validateTime(book.getBooking_time()) && validateDate(book.getBooking_date()) && validateseat(book.getSeat()) ) {
			return true;
		} else {
			throw new InvalidBookingException("The given booking detail is not valid");
		}

	}
	
	public static boolean validatepickup(String pickup) {
		boolean match = false; 

		if (pickup == null)
			return false;

		String pattern_string = "^[A-Za-z]{3,29}$";
		match = Pattern.matches(pattern_string, pickup);

		if (match) {
			System.out.println("Valid Pickup Location.");
		} else {
			System.out.println("Invalid Pickup Location.");
		}

		return match;
	}
	
	public static boolean validatedrop(String drop) {
		boolean match = false; 

		if (drop == null)
			return false;

		String pattern_string = "^[A-Za-z]{3,29}$";
		match = Pattern.matches(pattern_string, drop);

		if (match) {
			System.out.println("Valid drop Location.");
		} else {
			System.out.println("Invalid drop Location.");
		}

		return match;
	}
	
	public static boolean validateseat(int seatNumber) {
	    boolean isValid = false;

	    
	    if (seatNumber >= 1 && seatNumber <= 5) {
	        isValid = true;
	        System.out.println("Valid Seat selection.");
	    } else {
	        System.out.println("Invalid Seat selection.");
	    }

	    return isValid;
	}

	
	public static boolean validateTime(String time) {
		boolean match = false; 

		if (time == null)
			return false;

		String pattern_string = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
		match = Pattern.matches(pattern_string, time);

		if (match) {
			System.out.println("The given Time is valid.");
		} else {
			System.out.println("The given Time is Invalid.");
		}

		return match;
	}
	
	
	public static boolean validateDate(String date) {
		boolean match = false; 

		if (date == null)
			return false;

		String pattern_string = "^\\d{4}-\\d{2}-\\d{2}$";
				
		// example date is 2023-12-09
		match = Pattern.matches(pattern_string, date);

		if (match) {
			System.out.println("The given Date is valid.");
		} else {
			System.out.println("The given Date is Invalid.");
		}

		return match;
	}
	
}
