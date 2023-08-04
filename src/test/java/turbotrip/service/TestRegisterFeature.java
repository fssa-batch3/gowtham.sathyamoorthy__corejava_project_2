package turbotrip.service;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import turbotrip.model.User;
import turbotrip.service.UserService;
import turbotrip.service.exception.ServiceException;
import turbotrip.validation.exception.InvalidUserException;


public class TestRegisterFeature{
	
	
	public static void main(String[] args) {

		User user1 = new User("Gowtham","kkk.krish1705@gmail.com","9551555231","Arun@123");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test 

	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user = new User("Gowtham","kkk.krish1705@gmail.com","9551555231","Arun@123");
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
@Test

	public void testUserNull() {
		UserService userService = new UserService();
		User user = null;
		try {
			userService.registerUser(user);
			fail();
		} catch ( ServiceException e) {
			e.printStackTrace();
			assertEquals("User details not valid", e.getMessage());
		}
	
	}
}