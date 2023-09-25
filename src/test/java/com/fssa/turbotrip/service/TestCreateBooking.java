package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.model.Booking;
import com.fssa.turbotrip.service.exception.ServiceException;

public class TestCreateBooking {

	@Test

	 void testBookingAdded() {
		BookingService bookService = new BookingService();
	
		Booking book = new Booking();
		book.setUser_id(1);
		book.setPickup_location("Perungudi");
		book.setDrop_location("Tharamani");
		book.setBooking_time("09:30");
		book.setBooking_date("20-09-2023");
		book.setNo_of_seat(2);
		
		try {

			assertTrue(bookService.createBooking(book));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	
	
}
