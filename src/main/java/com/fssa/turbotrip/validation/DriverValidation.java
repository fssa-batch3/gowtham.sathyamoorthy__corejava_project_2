package com.fssa.turbotrip.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.validation.exception.InvalidDriverException;

public class DriverValidation {

	// This code for validating the given inputs or valid or not!!!
	public static boolean validateDriver(Driver driver) throws InvalidDriverException {

		if (driver != null && validateAadharnumber(driver.getAadhar_number())
				&& validateLicensencenumber(driver.getLicensence_number())
				&& validateExperience(driver.getExperience())) {
			return true;
		} else {
			throw new InvalidDriverException("Driver details not valid");
		}

	}
	// This code is validating the valid AadharNumber to store data in Driver table

	public static boolean validateAadharnumber(long aadhar_number) {
		boolean match = false;
		String aadhar = Long.toString(aadhar_number);
		if (aadhar == null)
			return false;

		String regex = "^\\d{12}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(aadhar);
		match = m.matches();
		if (match) {
			System.out.println("The given Aadhar number is valid.");
		} else {
			System.out.println("The given Aadhar number is not valid please enter 12 digits vaild number");
		}

		return match;
	}
	// This code is validating the valid LicenseNumber to store data in Driver table

	public static boolean validateLicensencenumber(String licensence_number) {
		boolean match = false;

		if (licensence_number == null)
			return false;

		String regex = "^[A-Z]{2}\\d{13}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(licensence_number);
		match = m.matches();
		if (match) {
			System.out.println("The given DL number is valid.");
		} else {
			System.out.println("The given DL number is not valid please enter vaild number");
		}

		return match;
	}
	// This code is validating the valid DriverExperience to store value in Driver
	// table

	public static boolean validateExperience(int experience) {
		boolean match = false;
		String exp = Integer.toString(experience);
		if (exp == null)
			return false;

		String regex = "^[1-9]\\d*$";
;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(exp);
		match = m.matches();
		if (match) {
			System.out.println("The given Experience year is valid.");
		} else {
			System.out.println("The given Experience year is not valid please enter vaild year");
		}

		return match;
	}
}
