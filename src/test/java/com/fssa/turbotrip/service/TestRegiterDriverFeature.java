package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.fail;

import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.exception.ServiceException;

/**
 * Test class for verifying the registration functionality of the DriverService
 * and UserService.
 */

public class TestRegiterDriverFeature {
	public static void main(String[] args) {

		UserService userService = new UserService();
		DriverService driverService = new DriverService();
		User user1 = new User( "Arunkumar", "arun@gmail.com", "9840634596", "Kumar@12345", 0, true);

		Driver user2 = new Driver( 1, 294457655678L, "AB1234567890987", 2);
	
		

		try {
			driverService.registerDriver(user2);
			userService.registerUser(user1);

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

		

	} 

}
