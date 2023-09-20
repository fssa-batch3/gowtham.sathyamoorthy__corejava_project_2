  package com.fssa.turbotrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.utils.ConnectionUtil;

public class DriverDAO {
	// This code create new User to the website
		public boolean createUser(User user) throws DAOException {
			final String insertQuery = "INSERT INTO user( username, email, phone, password, is_deleted, license_number )VALUES (?,?,?,?,?,?)";
			try (Connection connect = ConnectionUtil.getConnection();
					PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			
				pst.setString(1, user.getUsername());
				pst.setString(2, user.getEmail());
				pst.setString(3, user.getPhone());
				pst.setString(4, user.getPassword());
				pst.setInt(5, user.getIsdeleted());
				pst.setString(6, user.getlicense_number());

				int rows = pst.executeUpdate();
				return (rows == 1);
			} catch (SQLException e) {
				throw new DAOException(e);
			}

		}
		public static int findIdByEmail(String email) throws DAOException {
			String sql = "SELECT user_id FROM user WHERE email = ?";
			int userId = 0; // Initialize to a default value
			try (Connection connection = ConnectionUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				preparedStatement.setString(1, email);

				// Execute the SQL query
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					userId = resultSet.getInt("user_id");
				} else {
					throw new DAOException("User not found.");
				}

				// Close the database resources
				resultSet.close();
			} catch (SQLException e) {
				throw new DAOException("Database error: " + e.getMessage());
			}
			return userId;
		}
	
	} 

	

