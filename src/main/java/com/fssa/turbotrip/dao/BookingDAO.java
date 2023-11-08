package com.fssa.turbotrip.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Booking;
import com.fssa.turbotrip.utils.ConnectionUtil;
import com.fssa.turbotrip.utils.Logger;

public class BookingDAO {
    private static final String DATABASE_ERROR_MESSAGE = "Database error: ";
    static Logger log = new Logger();

    public boolean createBooking(Booking booking) throws DAOException {
        final String insertQuery = "INSERT INTO booking (user_id, pickup_location, drop_location, booking_time, booking_date, no_of_seat) VALUES (?,?,?,?,?,?)";
        try (Connection connect = ConnectionUtil.getConnection();
                PreparedStatement pst = connect.prepareStatement(insertQuery);) {
            pst.setInt(1, booking.getUser_id());
            pst.setString(2, booking.getPickup_location());
            pst.setString(3, booking.getDrop_location());
            pst.setString(4, booking.getBooking_time());
            pst.setString(5, booking.getBooking_date());
            pst.setInt(6, booking.getNo_of_seat());

            int rows = pst.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(DATABASE_ERROR_MESSAGE + e.getMessage());
        }
    }

    public List<Booking> getAllbooking() throws DAOException {
        final String selectCarListQuery = "SELECT * FROM booking WHERE status = 'Pending' ";
        List<Booking> book = new ArrayList<>();
        try (Connection connect = ConnectionUtil.getConnection();
                Statement statement = connect.createStatement();
                ResultSet rs = statement.executeQuery(selectCarListQuery);) {

            while (rs.next()) { 
                int bookingId = rs.getInt("booking_id");
                int userId = rs.getInt("user_id");
                String pickup = rs.getString("pickup_location");
                String drop = rs.getString("drop_location");
                String book_time = rs.getString("booking_time");
                String book_date = rs.getString("booking_date");
                int seat = rs.getInt("no_of_seat");

                Booking booking = new Booking(bookingId, userId, pickup, drop, book_time, book_date, seat);
                log.debug(booking.toString());
                book.add(booking);
            }

        } catch (SQLException e) {
            throw new DAOException(DATABASE_ERROR_MESSAGE + e.getMessage());
        }
        return book;
    }

    public static int findIdByEmail(String email) throws DAOException {
        String sql = "SELECT user_id FROM user WHERE email = ?";
        int userId = 0; // Initialize to a default value
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("user_id");
            } else {
                throw new DAOException("User not found.");
            }

            resultSet.close();
        } catch (SQLException e) {
            throw new DAOException(DATABASE_ERROR_MESSAGE + e.getMessage());
        }
        return userId;
    }

    public static Booking findObjectByUserId(int user_id) throws DAOException {
        String sql = "SELECT booking_id, otp, driver_id FROM booking WHERE user_id = ? ORDER BY booking_id DESC LIMIT 1";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user_id);

            System.out.println("Executing SQL query: " + sql);
            System.out.println("User ID: " + user_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String otp = resultSet.getString("otp");
                int bookingid = resultSet.getInt("booking_id");
                int driverId = resultSet.getInt("driver_id");
                Booking booking = new Booking(driverId, otp,bookingid);

                System.out.println("Retrieved OTP: " + otp);

                return booking;
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println(DATABASE_ERROR_MESSAGE + e.getMessage());
            throw new DAOException(DATABASE_ERROR_MESSAGE + e.getMessage());
        }

        return null;
    }

    public static String findObjectBydriverId(int user_id) throws DAOException {
        String sql = "SELECT otp FROM booking WHERE driver_id = ? ORDER BY booking_id DESC LIMIT 1";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user_id);

            System.out.println("Executing SQL query: " + sql);
            System.out.println("User ID: " + user_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String otp = resultSet.getString("otp");
                System.out.println("Retrieved OTP: " + otp);
                return otp;
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println(DATABASE_ERROR_MESSAGE + e.getMessage());
            throw new DAOException(DATABASE_ERROR_MESSAGE + e.getMessage());
        }
        return null;
    }

    public boolean AcceptStatus(int Booking_id, int Driver_id, String generatedOTP) throws DAOException {
        Connection connection = null;
        PreparedStatement pst = null;
        int rows = 0;

        try {
            connection = ConnectionUtil.getConnection();
            String updateQuery = "UPDATE booking SET driver_id = ?, otp = ?, status = 'True' WHERE booking_id = ? AND status = 'Pending'";
            pst = connection.prepareStatement(updateQuery);

            pst.setInt(1, Driver_id);
            pst.setString(2, generatedOTP);
            pst.setInt(3, Booking_id);
 
            rows = pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error while updating booking: " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Handle the SQLException or log it if needed
            }
        }

        return (rows == 1);
    }
}
