package com.fssa.turbotrip.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.exception.InvalidUserException;

class TestUserValidation {
// This is test case for UserEmail is valid or not:

	@Test
	void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("gowtham@gmail.com"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidEmailMissingAt() {
		try {
			assertFalse(UserValidator.validateEmail("gowthigmail.com"));
		} catch (InvalidUserException e) {
			e.getMessage();
		}

	}

	@Test
	void testInvalidEmailMissingPeriod() {
		try {
			assertFalse(UserValidator.validateEmail("gowtham@gmailcom"));
		} catch (InvalidUserException e) {
			e.getMessage();
		}

	}

	// This is test case for UserName is valid or not:
	@Test
	void testValidName() {
		try {
			assertTrue(UserValidator.validateName("Gowthamkrishna"));
		} catch (InvalidUserException e) {
			e.getMessage();
		}

	}

	@Test
	void testMixednumber() {
		try {
			assertFalse(UserValidator.validateName("000000"));
		} catch (InvalidUserException e) {
			e.getMessage();
		}

	}

	@Test
	void testLengthofname() {
		try {
			assertFalse(UserValidator.validateName("gowthamkrishnakxjjgkjgjfhjkdxbkjhgkjfhgkjrhjkgjfhgbuj"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}
	// This is test case for UserPassword is valid or not:

	@Test
	void testValidPassword() {

		try {
			assertTrue(UserValidator.validatePassword("Gowtham@123"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacters() {
		try {
			assertFalse(UserValidator.validatePassword("Gowtham123"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidPasswordWithoutNumbers() {
		try {
			assertFalse(UserValidator.validatePassword("Gowtham@"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidPasswordWithoutCapitalLetters() {
		try {
			assertFalse(UserValidator.validatePassword("gowtham@123"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidPasswordWithoutSmallLetters() {
		try {
			assertFalse(UserValidator.validatePassword("GOWTHAM@123"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

	@Test
	void testInvalidPasswordShorterLength() {
		try {
			assertFalse(UserValidator.validatePassword("Gow@123"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}

	}

// This is test case for UserPhone is valid or not:
	@Test

	void testValidPhoneNumber() {
		try {
			assertTrue(UserValidator.validatePhone("9842356365"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}
	}

	@Test

	void testInValidPhoneNumber() {
		try {
			assertFalse(UserValidator.validatePhone("1234567890"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}
	}

	@Test

	void testInValidPhoneNumberLesserLength() {
		try {
			assertFalse(UserValidator.validatePhone("12345"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}
	}
 
	@Test

	void testInValidPhoneNumberGreaterLength() {
		try {
			assertFalse(UserValidator.validatePhone("0987611234598765"));
		} catch (InvalidUserException e) {

			e.getMessage();
		}
	}
} 
