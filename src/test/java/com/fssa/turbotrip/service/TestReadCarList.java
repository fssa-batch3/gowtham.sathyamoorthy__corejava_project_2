 package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.dao.CarDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.CarService;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.exception.InvalidCarException;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class TestReadCarList {
	/**
	 * Test class for evaluating the functionality of listing cars using the CarService.
	 */

	public static void main(String[] args) throws ServiceException, InvalidCarException, DAOException {
		
		Car car1 = new Car("TN 07 bd 2345");
		CarDAO c = new CarDAO();
	CarService carService = new CarService();
		System.out.println(carService.listCar(car1));
	}
	
	@Test
	 void testUpdateSuccess() throws ServiceException, InvalidCarException, DAOException {
		CarService carService = new CarService();
		Car car1 = new Car("tn 07 bd 2345");
		String s = carService.listCar(car1);
		String[] split = s.split(",");
		String output = split[0].toLowerCase().trim();
		assertEquals("carnumber: tn 07 bd 2345",output);
	}
	
	
	
	@Test
	 void testUpdateFail() throws ServiceException, InvalidCarException, DAOException {
		CarService carService = new CarService();
		Car car1 = new Car("TN 08 CD 1234");
		String s = carService.listCar(car1);
		String[] split = s.split(",");
	String output = split[0].toLowerCase().trim();
	 assertNotEquals("carnumber: tn 08 cd 0099",output);
	}
	

}
