package testUserValidation.java;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.validation.UserValidator;
public class TestName {
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
}


