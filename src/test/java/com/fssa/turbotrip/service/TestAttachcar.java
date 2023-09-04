package com.fssa.turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.service.exception.ServiceException;
/**
 * this containing test methods to verify the functionality of the CarService class.
 */
public class TestAttachcar {
	public static void main(String[] args) {
		Car user1 = new Car(1,"TN 08 CD 9087", "Suv",
				"https://media.istockphoto.com/id/495605964/photo/generic-compact-red-car.jpg?s=612x612&w=0&k=20&c=eElEDukSWi6HsUPXflSebpUm7j9tPNq7WvFOGIlqgeA=",
				"It is very easy to book ");
		CarService carService = new CarService();

		try {
			carService.createCar(user1);
		} catch (Exception e) {
			e.printStackTrace(); 

		}

	}

	@Test

	 void testCarAdded() {
		CarService carService = new CarService();
		Car car = new Car(1, "TN 08 CD 0099", "Car",
				"https://media.istockphoto.com/id/495605964/photo/generic-compact-red-car.jpg?s=612x612&w=0&k=20&c=eElEDukSWi6HsUPXflSebpUm7j9tPNq7WvFOGIlqgeA=",
				"It is a five seater");
		try {

			assertTrue(carService.createCar(car));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
