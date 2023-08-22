package com.fssa.turbotrip.validation;

import java.util.regex.Pattern;

import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.validation.exception.InvalidCarException;

public class CarValidator {

	public static boolean validateCar(Car car) throws InvalidCarException {

		if (car != null && validateURL(car.getCarImage()) && validateModel(car.getCarmodel())
				&& validateRegistration(car.getCarNo()) && validateDescription(car.getDescription())) {
			return true;
		} else {
			throw new InvalidCarException("User details not valid");
		}

	}

	public static boolean validateupdateCar(Car car) throws InvalidCarException {

		if (car != null && validateURL(car.getCarImage()) && validateDescription(car.getDescription())) {
			return true;
		} else {
			throw new InvalidCarException("User details not valid");
		}

	}

	public static boolean validateURL(String imageUrl) throws InvalidCarException {
		if (imageUrl == null || imageUrl.isEmpty()) {
			throw new InvalidCarException("The image url is null or empty please correct it");
		} else {
			return true;
		}
//		
//		
	}

	public static boolean validateModel(String model) {
		boolean match = false;

		if (model == null)
			return false;

		String pattern_string = "^[A-Za-z]\\w{2,29}$";
		match = Pattern.matches(pattern_string, model);

		if (match) {

			System.out.println("Valid Car Model.");
		} else {
			System.out.println("Invalid Car Model.");
		}

		return match;
	}

	public static boolean validateRegistration(String registration) {
		boolean match = false;

		if (registration == null)
			return false;

		String pattern_string = "[A-Z]{2} \\d{2} [A-Z]{2} \\d{4}";
		match = Pattern.matches(pattern_string, registration);

		if (match) {

			System.out.println("Valid Car Registration.");
		} else {
			System.out.println("Invalid Car Registration.");
		}

		return match;
	}

	public static boolean validateDescription(String description) {
		boolean match = false;

		if (description == null)
			return false;

		String pattern_string = "^[a-zA-Z0-9\\s]+$";
		match = Pattern.matches(pattern_string, description);

		if (match) {

			System.out.println("Valid Description.");
		} else {
			System.out.println("Invalid Description.");
		}

		return match;
	}

}
