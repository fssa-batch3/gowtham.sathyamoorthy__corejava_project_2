 package com.fssa.turbotrip.service;

import com.fssa.turbotrip.dao.DriverDAO;
import com.fssa.turbotrip.dao.UserDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.utils.Logger;
import com.fssa.turbotrip.validation.DriverValidation;
import com.fssa.turbotrip.validation.UserValidator;
import com.fssa.turbotrip.validation.exception.InvalidDriverException;
import com.fssa.turbotrip.validation.exception.InvalidUserException;

// This code is checking the validation of Register driver
public class DriverService {
	static Logger log = new Logger();
	public boolean registerDriver(User driver) throws ServiceException {
		DriverDAO driverDAO = new DriverDAO();
		try {
			DriverValidation.validateUser(driver);
			if (driverDAO.createUser(driver)) {
				log.debug(driver.getUser_id() + "Successfully registered!");
				return true;
			} else {
				log.debug("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		} 

	} 

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				log.debug(user.getUser_id() + "Successfully registered!");
				return true;
			} else {
				log.debug("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}
	public int findIdByEmail(String email) throws ServiceException {
		int user;
		try {
			user = DriverDAO.findIdByEmail(email);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
