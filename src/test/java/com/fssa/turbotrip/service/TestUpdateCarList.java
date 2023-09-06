 package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;

import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.CarValidator;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

/**
 * Test class for evaluating the update functionality of the CarService.
 */

 class TestUpdateCarList {

	@Test
	void testUpdateSuccess() throws ServiceException, InvalidCarException, DAOException {
		CarService carService = new CarService();
		String Carno = "tn 08 cd 9087";
		Car car1 = new Car("https://example.com", "It is nine seater");
		assertTrue(carService.updateCar(car1, Carno));
	}

	@Test 
	void testUpdateFail() {
		CarService carService = new CarService();
		try {
			assertFalse(carService.updateCar(null,null));
		} catch (ServiceException | InvalidCarException | DAOException e) {
			
			e.printStackTrace();
		}	
		
		
	}
 }
		
		
	