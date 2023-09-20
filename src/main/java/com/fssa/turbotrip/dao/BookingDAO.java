package com.fssa.turbotrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Booking;
import com.fssa.turbotrip.model.Car;
import com.fssa.turbotrip.utils.ConnectionUtil;

public class BookingDAO {

	
	public boolean createBooking(Booking book) throws DAOException {
		final String insertQuery = "INSERT INTO booking (user_id, driver_id, pickup_location, drop_location, booking_time, booking_date, seat, request_status, accept_status) VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			pst.setInt(1, book.getUser_id());
			pst.setInt(2, book.getDriver_id());
			pst.setString(3, book.getPickup_location());
			pst.setString(4, book.getDrop_location());
			pst.setString(5, book.getBooking_time());
			pst.setString(6, book.getBooking_date());
			pst.setInt(7, book.getSeat());
			pst.setBoolean(8, book.getRequest_status());
			pst.setBoolean(9, book.getAccept_status());
			
			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
}
