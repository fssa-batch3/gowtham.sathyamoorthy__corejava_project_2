package testCarValidation.java;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.CarValidator;
import com.fssa.turbotrip.validation.exception.InvalidCarException;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class TestCarImage {
	@Test
	public void testValidImgUrl() {
		try {
			assertTrue(CarValidator.validateURL("https://media.istockphoto.com/id/949409516/photo/3d-illustration-of-generic-suv-car-on-white.webp?b=1&s=170667a&w=0&k=20&c=2LtfCnq1xTffaHP6b3MD8cKqJT7Z4ZiE-eHIQtbe4gw="));
		} catch (InvalidCarException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidImgUrl() {
		try {
			assertFalse(CarValidator.validateURL(null));
		} catch (InvalidCarException e) {
			e.printStackTrace();
		}
	}

}
