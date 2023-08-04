package turbotrip.validation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class TestEmail {
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






}
