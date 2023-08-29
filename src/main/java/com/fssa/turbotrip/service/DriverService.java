package com.fssa.turbotrip.service;

import com.fssa.turbotrip.dao.DriverDAO; 
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Driver;
import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.validation.DriverValidation;
import com.fssa.turbotrip.validation.exception.InvalidDriverException;
// This code is checking the validation of Register driver
public class DriverService {
	public boolean registerUser(Driver driver) throws ServiceException, InvalidDriverException {
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

	
}
