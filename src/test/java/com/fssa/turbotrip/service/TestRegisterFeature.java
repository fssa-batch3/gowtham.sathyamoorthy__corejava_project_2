package com.fssa.turbotrip.service;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.UserService;
import com.fssa.turbotrip.service.exception.ServiceException;

/**
 * Test class for evaluating the registration functionality of the UserService.
 */

public class TestRegisterFeature{
	
	
	public static void main(String[] args) {

		User user1 = new User("Krishna","gowtham.krish1705@gmail.com","9551555232","Gowthi@123", 0, false);
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
		User user = new User("Krishna","gowtham.krish1705@gmail.com","9551555232","Gowthi@123", 0 , false);
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
			assertFalse(userService.registerUser(user));
		} catch ( ServiceException e) {
			e.printStackTrace();
		}
	
	}
}