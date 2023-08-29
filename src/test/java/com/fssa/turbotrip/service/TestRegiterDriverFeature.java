 package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.fail;

import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.model.User;
/**
 * Test class for verifying the registration functionality of the DriverService and UserService.
 */

public class TestRegiterDriverFeature {
	public static void main(String[] args) {
		
		Driver user2 = new Driver( 294457655678L, "AB1234567890987", 2);
		//	public Driver (long aadhar_number, String licensence_number, int experience, int id ) {

			DriverService driverService = new DriverService();

			try {
				driverService.registerUser(user2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		

		 User user1 = new User( "AjaiKumar","ajaikumar@gmail.com","9551555231", "Ajai@12345",0, true);
			UserService userService = new UserService();

			try {
				userService.registerUser(user1);
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}
			 
}
		
		
}
