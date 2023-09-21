package com.fssa.turbotrip.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.exception.InvalidBookingException;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

public class TestBookingValidation {
	
		 
		// This is test case for Pickup location is valid or not
		@Test
		 void testValidBookingpickup() throws InvalidBookingException {
			assertTrue(BookingValidator.validatepickup("Perungudi"));
		}

		
		@Test
		 void testInvalidBookingpickup() throws InvalidBookingException {
			assertFalse(BookingValidator.validatepickup("Per341gudi"));
		}
		 
		
		 
			// This is test case for Drop location is valid or not
			@Test
			 void testValidBookingdrop() throws InvalidBookingException {
				assertTrue(BookingValidator.validatedrop("Perungudi"));
			}

			
			@Test
			 void testInvalidBookingdrop() throws InvalidBookingException {
				assertFalse(BookingValidator.validatedrop("Per341gudi"));
			}
			
			// This is test case for seat selection is valid or not
						@Test
						 void testValidBookingSeat() throws InvalidBookingException {
							assertTrue(BookingValidator.validateseat(5));
						}

						
						@Test
						 void testInvalidBookingSeat() throws InvalidBookingException {
							assertFalse(BookingValidator.validateseat(100));
						}
						
						// This is test case for given time is valid or not
						@Test
						 void testValidBookingTime() throws InvalidBookingException {
							assertTrue(BookingValidator.validateTime("05:23"));
						}

						
						@Test
						 void testInvalidBookingTime() throws InvalidBookingException {
							assertFalse(BookingValidator.validateTime("abc:def"));
						}
		
						// This is test case for given time is valid or not
						@Test
						 void testValidBookingDate() throws InvalidBookingException {
							assertTrue(BookingValidator.validateDate("2023-09-20"));
						}

						
						@Test
						 void testInvalidBookingDate() throws InvalidBookingException {
							assertFalse(BookingValidator.validateDate("23-09-2023"));
						}
		
}
