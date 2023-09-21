package com.fssa.turbotrip.service;

import com.fssa.turbotrip.dao.BookingDAO;

import com.fssa.turbotrip.model.Booking;

import com.fssa.turbotrip.service.exception.ServiceException;
import com.fssa.turbotrip.utils.Logger;
import com.fssa.turbotrip.validation.BookingValidator;


public class BookingService {

	static Logger log = new Logger();

	public boolean createBooking(Booking book) throws ServiceException {
		BookingDAO bookingDAO = new BookingDAO();
		try {
			BookingValidator.validatebooking(book);
			if (bookingDAO.createBooking(book)) {
				log.debug("Your booking request is sent to the driver please wait");
				return true;

			} else {
				log.debug("Your booking is not acceptable please try again");
			  return false;	
			}
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
