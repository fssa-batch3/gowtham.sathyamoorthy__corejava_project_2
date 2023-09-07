package com.fssa.turbotrip.validation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.exception.InvalidCarException;
 class TestCarValidation {
// This is test case for CarDescription is valid or not
	@Test
	 void testValidCarDescription() throws InvalidCarException {
		assertTrue(CarValidator.validateDescription("It is seven seater car"));
	}

	@Test
	 void testInvalidCarDescription() throws InvalidCarException {
		assertFalse(CarValidator.validateDescription("it@100 seater car"));
	}
	 
	// This is test case for CarImage is valid or not
	
	@Test
	 void testValidImgUrl() {
		try {
			assertTrue(CarValidator.validateURL("https://media.istockphoto.com/id/949409516/photo/3d-illustration-of-generic-suv-car-on-white.webp?b=1&s=170667a&w=0&k=20&c=2LtfCnq1xTffaHP6b3MD8cKqJT7Z4ZiE-eHIQtbe4gw="));
		} catch (InvalidCarException e) {
			e.printStackTrace(); 
		}
	}

	@Test
	 void testInvalidImgUrl() {
		try {
			assertFalse(CarValidator.validateURL(null));
		} catch (InvalidCarException e) {
			e.printStackTrace();
		}
	}
	
	
	// This is test case for CarModel is valid or not
	
	@Test
	 void testValidModelName() {
		assertTrue(CarValidator.validateModel("Sedan"));

	}

	@Test
	 void testMismatchModelName() {
		assertFalse(CarValidator.validateModel("@fwffefe"));

	}
	
	// This is test case for CarDescription is valid or not:

	@Test
	 void testValidRegistration() {
		assertTrue(CarValidator.validateRegistration("AB 12 CD 2023"));

	}
 
	@Test
	 void testInValidRegistration() {
		assertFalse(CarValidator.validateRegistration("tn08cd0066"));

	}
	
	
}
