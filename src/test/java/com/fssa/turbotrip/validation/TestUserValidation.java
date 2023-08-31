package com.fssa.turbotrip.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestUserValidation {
// This is test case for UserEmail is valid or not:

	@Test
	 void testValidEmail() {
		assertTrue(UserValidator.validateEmail("gowtham@gmail.com"));

	}

	@Test
	 void testInvalidEmailMissingAt() {
		assertFalse(UserValidator.validateEmail("gowthigmail.com"));

	}

	@Test
	 void testInvalidEmailMissingPeriod() {
		assertFalse(UserValidator.validateEmail("gowtham@gmailcom"));

	}

	// This is test case for UserName is valid or not:
	@Test
	 void testValidName() {
		assertTrue(UserValidator.validateName("Gowthamkrishna"));

	}

	@Test
	 void testMixednumber() {
		assertFalse(UserValidator.validateName("000000"));

	}

	@Test
	 void testLengthofname() {
		assertFalse(UserValidator.validateName("gowthamkrishnakxjjgkjgjfhjkdxbkjhgkjfhgkjrhjkgjfhgbuj"));

	}
	// This is test case for UserPassword is valid or not:

	@Test
	 void testValidPassword() {

		assertTrue(UserValidator.validatePassword("Gowtham@123"));

	}

	@Test
	 void testInvalidPasswordWithoutSpecialCharacters() {
		assertFalse(UserValidator.validatePassword("Gowtham123"));

	}

	@Test
	 void testInvalidPasswordWithoutNumbers() {
		assertFalse(UserValidator.validatePassword("Gowtham@"));

	}

	@Test
	 void testInvalidPasswordWithoutCapitalLetters() {
		assertFalse(UserValidator.validatePassword("gowtham@123"));

	}

	@Test
	 void testInvalidPasswordWithoutSmallLetters() {
		assertFalse(UserValidator.validatePassword("GOWTHAM@123"));

	}

	@Test
	 void testInvalidPasswordShorterLength() {
		assertFalse(UserValidator.validatePassword("Gow@123"));

	}

// This is test case for UserPhone is valid or not:
	@Test

	public void testValidPhoneNumber() {
		assertTrue(UserValidator.validatePhone("9842356365"));
	}

	@Test

	 void testInValidPhoneNumber() {
		assertFalse(UserValidator.validatePhone("1234567890"));
	}

	@Test

	 void testInValidPhoneNumberLesserLength() {
		assertFalse(UserValidator.validatePhone("12345"));
	}

	@Test

	 void testInValidPhoneNumberGreaterLength() {
		assertFalse(UserValidator.validatePhone("0987611234598765"));
	}
}
