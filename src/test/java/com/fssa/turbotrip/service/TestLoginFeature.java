package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.model.*;
import com.fssa.turbotrip.service.UserService;
import com.fssa.turbotrip.service.exception.ServiceException;
/**
 * Test class for evaluating the login functionality of the UserService.
 */

 class TestLoginFeature {
	@Test

	 void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("kkk.krish1705@gmail.com", "Arun@123");
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
 
	@Test

	 void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("gowthi@gmail.com", "Password@123");
		try {
			assertFalse(userService.loginUser(user2));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
