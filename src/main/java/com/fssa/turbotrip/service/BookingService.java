package com.fssa.turbotrip.service;

import java.util.List;
import java.util.Map;

import com.fssa.turbotrip.dao.BookingDAO;
import com.fssa.turbotrip.dao.exception.DAOException;
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
	
	public List<Booking> getAllbooking() throws ServiceException {
		try {
			BookingDAO bookDAO = new BookingDAO();
			return bookDAO.getAllbooking();
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

	}

	public int findIdByEmail(String email) throws ServiceException {
		int user;
		try {
			user = BookingDAO.findIdByEmail(email);
			return user;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	public Booking findObjectByUserIds(int user_id) throws ServiceException {
	    try {
	        return BookingDAO.findObjectByUserId(user_id);
	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage());
	    }
	}

	
	public String findObjectBydriverIds(int user_id) throws ServiceException {
		try {
			return BookingDAO.findObjectBydriverId(user_id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	public  boolean AcceptBooking(int Booking_id, int Driver_id, String generatedOTP) throws ServiceException {
		BookingDAO bookDAO = new BookingDAO();
		try {
			
				if (bookDAO.AcceptStatus(Booking_id, Driver_id, generatedOTP)) {
					
					log.debug("Driver " + Driver_id + "you accept the request Successfully !");
					return true;
				} else {
					return false;
				}
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	

}
