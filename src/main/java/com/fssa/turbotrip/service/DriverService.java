 package com.fssa.turbotrip.service;

import com.fssa.turbotrip.dao.DriverDAO;
import com.fssa.turbotrip.dao.UserDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.DriverValidation;
import com.fssa.turbotrip.validation.UserValidator;
import com.fssa.turbotrip.validation.exception.InvalidDriverException;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

// This code is checking the validation of Register driver
public class DriverService {
	public boolean registerDriver(Driver driver) throws ServiceException {
		DriverDAO driverDAO = new DriverDAO();
		try {
			DriverValidation.validateDriver(driver);
			if (driverDAO.createDriver(driver)) {
				System.out.println(driver.getId() + "Successfully registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidDriverException e) {
			throw new ServiceException(e);
		}

	} 

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getUser_id() + "Successfully registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
