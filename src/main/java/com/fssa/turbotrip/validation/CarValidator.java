package com.fssa.turbotrip.validation;

import java.util.regex.Pattern;

import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.utils.Logger;
import com.fssa.turbotrip.validation.exception.InvalidCarException;
 
public class CarValidator {
    static Logger log = new Logger();
// This code for validating the given inputs or valid or not!!!
	
	public static boolean validateCar(Car car) throws InvalidCarException {

		if (car != null && validateURL(car.getCarImage()) && validateModel(car.getCarmodel())
				&& validateRegistration(car.getCarNo()) && validateDescription(car.getDescription())) {
			return true;
		} else {
			throw new InvalidCarException("The giver car details not valid");
		}
 
	}

	public static boolean validateupdateCar(Car car) throws InvalidCarException {

		if (car != null && validateURL(car.getCarImage()) && validateDescription(car.getDescription())) {
			return true;
		} else {
			throw new InvalidCarException("The giver car details not valid");
		}

	}
// This code is validating the image URL to store data in CarList
	public static boolean validateURL(String imageUrl) throws InvalidCarException {
		if (imageUrl == null || imageUrl.isEmpty()) {
			throw new InvalidCarException("The image url is null or empty please correct it");
		} else {
			return true;
		}
		// This code is validating the Car Model to store data in CarList
		
	}

	public static boolean validateModel(String model) {
		boolean match = false; 

		if (model == null)
			return false;

		String pattern_string = "^[A-Za-z]{3,29}$";
		match = Pattern.matches(pattern_string, model);

		if (match) {
			log.debug("Valid Car Model.");
		} else {
			log.debug("Invalid Car Model.");
		}

		return match;
	}
	// This code is validating the Car registration  to store data in CarList
	public static boolean validateRegistration(String registration) {
		boolean match = false;

		if (registration == null)
			return false;

		String pattern_string = "[A-Z]{2}+ \\d{2} +[A-Z]{2}+ \\d{4}";
		match = Pattern.matches(pattern_string, registration);

		if (match) { 

			log.debug("Valid Car Registration.");
		} else {
			log.debug("Invalid Car Registration.");
		}

		return match;
	}
	// This code is validating the Car Description to store data in CarList
	public static boolean validateDescription(String description) {
		boolean match = false;

		if (description == null)
			return false;

		String pattern_string = "^[a-zA-Z0-9\\s]+$";
		match = Pattern.matches(pattern_string, description);

		if (match) {

			log.debug("Valid Description.");
		} else {
			log.debug("Invalid Description.");
		}

		return match;
	}

}
