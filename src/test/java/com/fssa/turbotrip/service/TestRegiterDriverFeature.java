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
		User user1 = new User( "Arunkumar", "arun@gmail.com", "9840634596", "Kumar@12345", 0, "TN 8687907868787");
 
		try {
			userService.registerUser(user1);

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

		

	} 

}
