package com.fssa.turbotrip.service;

/**
 * Test class for verifying the deletion functionality of the CarService.
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.dao.exception.DAOException;

import com.fssa.turbotrip.service.exception.ServiceException;

  class TestDeleteCar {

	@Test
	void TestDeleteCarSuccess() {
		String Carno = "tn 07 bd 2345";
		int isDeleted = 1;
		CarService carService = new CarService();
		try {
			assertTrue(carService.deleteCar(Carno, isDeleted));
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteCarFail() {
		String Carno = "num";
		int isDeleted = 1;
		CarService carService = new CarService();
		try {
			assertFalse(CarService.deleteCar(Carno, isDeleted));
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
		}
	}

}
