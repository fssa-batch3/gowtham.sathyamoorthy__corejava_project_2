package com.fssa.turbotrip.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

// This code for validating the given inputs or valid or not!!!

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validatePhone(user.getPhone())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}
	// This code is validating the valid UserName to store data in User table
	public static boolean validateName(String name) {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The user name is valid.");
		} else {
			System.out.println("The user name is not valid");
		}

		return match;
	}
	// This code is validating the valid UserPassword to store data in User table

	public static boolean validatePassword(String password) {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}
	// This code is validating the valid UserEmail to store data in User table

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}
	// This code is validating the valid UserPhonenumber to store data in User table

	public static boolean validatePhone(String phone) {
		boolean isMatch = false;
		if (phone == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, phone);
		if (isMatch) {
			System.out.println("The mobile number is: Valid");
		} else {
			System.out.println("The mobile number is: Invalid");
		}
		return isMatch;

	}
}
