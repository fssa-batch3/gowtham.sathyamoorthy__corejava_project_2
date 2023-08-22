package com.fssa.turbotrip.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestUserValidation {
// This is test case for UserEmail is valid or not:

	@Test
	public void testValidEmail() {
		assertTrue(UserValidator.validateEmail("gowtham@gmail.com"));

	}

	@Test
	public void testInvalidEmailMissingAt() {
		assertFalse(UserValidator.validateEmail("gowthigmail.com"));

	}

	@Test
	public void testInvalidEmailMissingPeriod() {
		assertFalse(UserValidator.validateEmail("gowtham@gmailcom"));

	}

	// This is test case for UserName is valid or not:
	@Test
	public void testValidName() {
		assertTrue(UserValidator.validateName("Gowthamkrishna"));

	}

	@Test
	public void testMixednumber() {
		assertFalse(UserValidator.validateName("000000"));

	}

	@Test
	public void testLengthofname() {
		assertFalse(UserValidator.validateName("gowthamkrishnakxjjgkjgjfhjkdxbkjhgkjfhgkjrhjkgjfhgbuj"));

	}
	// This is test case for UserPassword is valid or not:

	@Test
	public void testValidPassword() {

		assertTrue(UserValidator.validatePassword("Gowtham@123"));

	}

	@Test
	public void testInvalidPasswordWithoutSpecialCharacters() {
		assertFalse(UserValidator.validatePassword("Gowtham123"));

	}

	@Test
	public void testInvalidPasswordWithoutNumbers() {
		assertFalse(UserValidator.validatePassword("Gowtham@"));

	}

	@Test
	public void testInvalidPasswordWithoutCapitalLetters() {
		assertFalse(UserValidator.validatePassword("gowtham@123"));

	}

	@Test
	public void testInvalidPasswordWithoutSmallLetters() {
		assertFalse(UserValidator.validatePassword("GOWTHAM@123"));

	}

	@Test
	public void testInvalidPasswordShorterLength() {
		assertFalse(UserValidator.validatePassword("Gow@123"));

	}

// This is test case for UserPhone is valid or not:
	@Test

	public void testValidPhoneNumber() {
		assertTrue(UserValidator.validatePhone("9842356365"));
	}

	@Test

	public void testInValidPhoneNumber() {
		assertFalse(UserValidator.validatePhone("1234567890"));
	}

	@Test

	public void testInValidPhoneNumberLesserLength() {
		assertFalse(UserValidator.validatePhone("12345"));
	}

	@Test

	public void testInValidPhoneNumberGreaterLength() {
		assertFalse(UserValidator.validatePhone("0987611234598765"));
	}
}
