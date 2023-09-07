 package com.fssa.turbotrip.service;

import java.util.List;

import com.fssa.turbotrip.dao.UserDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.UserValidator;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

public class UserService {
	// This code is checking the validation in register user
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			userDAO.checkUserDataExistOrNot(user.getEmail());
			if (userDAO.createUser(user)) {
				System.out.println(user.getEmail() + "Successfully registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	// This code is checking the validation in Login user
	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user.getEmail(), user.getPassword())) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

	}

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<User> getAllUserLists() throws ServiceException {
		try {
			UserDAO userDAO = new UserDAO();
			return userDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
