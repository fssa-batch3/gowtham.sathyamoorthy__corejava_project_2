package testUserValidation.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.UserValidator;

public class TestPassword {

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
}
