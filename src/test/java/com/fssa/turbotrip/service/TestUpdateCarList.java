package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.CarService;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

/**
 * Test class for evaluating the update functionality of the CarService.
 */

public class TestUpdateCarList {

	
	@Test
	public void testUpdateSuccess() throws ServiceException, InvalidCarException, DAOException {
		CarService carService = new CarService();
		String Carno = "TN 08 CD 0099";
		Car car1 = new Car("https://example.com","It is nine seater");
		assertTrue(carService.updateCar(car1,Carno));
	}
		
	
	
}
