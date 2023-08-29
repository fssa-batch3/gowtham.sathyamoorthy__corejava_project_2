package com.fssa.turbotrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.utils.ConnectionUtil;

public class UserDAO {
	// this code is checking the login user from the User table
	public boolean login(User user) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM user WHERE email = ? AND PASSWORD = ?";
			try (PreparedStatement pmt = connection.prepareStatement(query)) {
				pmt.setString(1, user.getEmail());
				pmt.setString(2, user.getPassword());

				try (ResultSet rs = pmt.executeQuery()) {
					return rs.next();
				}
			}
		}
	}

	// This code create new User to the website
	public boolean createUser(User user) throws DAOException {
		final String insertQuery = "INSERT INTO user(username, email, phone, password, is_deleted, is_driver)VALUES (?,?,?,?,?,?)";
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getPassword());
			pst.setInt(5, user.getIsdeleted());
			pst.setBoolean(6, user.getIsdriver());

			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public static void main(String[] args) throws DAOException {
		User use = new User("Krishna", "gowtham.krish1705@gmail.com", "9551555232", "Gowthi@123", 0, false);

	}

}
