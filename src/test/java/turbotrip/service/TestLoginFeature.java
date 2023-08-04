package turbotrip.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import turbotrip.model.*;
import turbotrip.service.exception.ServiceException;

public class TestLoginFeature {
	@Test

	public void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("gowtham.krish1705@gmail.com", "Arun@123");
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("gowthi@gmail.com", "Password@123");
		try {
			assertFalse(userService.loginUser(user2));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
