package testCarValidation.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.CarValidator;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

public class TestCarDescription {
	@Test
	public void testValidCarDescription() throws InvalidCarException {
		assertTrue(CarValidator.validateDescription("It is seven seater car"));
	}

	@Test
	public void testInvalidCarDescription() throws InvalidCarException {
		assertFalse(CarValidator.validateDescription("it@100 seater car"));
	}
}
