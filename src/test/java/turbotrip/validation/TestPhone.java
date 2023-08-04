package turbotrip.validation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class TestPhone {
	 
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
