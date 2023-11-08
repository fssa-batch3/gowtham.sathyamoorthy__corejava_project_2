package com.fssa.turbotrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.User;
import com.fssa.turbotrip.utils.ConnectionUtil;
import com.fssa.turbotrip.utils.Logger;

public class UserDAO {
    static Logger log = new Logger();
	// this code is checking login user from the User table
	// Get user from DB - Login
	public boolean login(String email, String password) throws DAOException {
		String selectQuery = "SELECT * FROM user WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {

		log.debug(email);
			// Set the email parameter
			statement.setString(1, email);
 
			// Execute the query
			try (ResultSet resultSet = statement.executeQuery()) {
				boolean userExists = resultSet.next();

				if (userExists) {
					String storedPassword = resultSet.getString("password");
					int userId = resultSet.getInt("user_id");
					User user1 = new User();
					user1.setUser_id(userId);
					if (storedPassword.equals(password)) {
						return true;
					} else {
						throw new DAOException("Incorrect password.");
					}
				} else {
					throw new DAOException("User credentials not exist.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

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

	// Check the user is already exists or not
	public boolean checkUserDataExistOrNot(String email) throws DAOException {
		String selectQuery = "SELECT email FROM user WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();

				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setString(1, email);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					throw new DAOException("User email already exist, try another email");
				} else {
					return true;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

//	get all users list
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<User> getAllUsers() throws DAOException {
		final String selectUserListQuery = "SELECT * FROM user";
		List<User> users = new ArrayList<>();
		try (Connection connect = ConnectionUtil.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectUserListQuery)) {
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				int is_deleted = rs.getInt("is_deleted");
				String license_number = rs.getString("license_number");

				User user = new User(username, email, phone, password, is_deleted, license_number);
				user.setUser_id(userId);
				users.add(user);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return users;
	}

	public User getUserByEmail(String email) throws DAOException {

		final String SELECTQUERY = "SELECT * FROM user WHERE email = ?";

		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connect.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {

					String name = rs.getString("username");
					String loggedEmail = rs.getString("email");
					String password = rs.getString("password");
					String phonenumber = rs.getString("phone");

					return new User(name, loggedEmail, password, phonenumber);

				}

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;

	}
	
	public User getUserById(int id) throws DAOException {

		final String SELECTQUERY = "SELECT * FROM user WHERE user_id = ?";

		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connect.prepareStatement(SELECTQUERY)) {

			pstmt.setInt(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {

					String name = rs.getString("username");
					String loggedEmail = rs.getString("email");
					String phonenumber = rs.getString("phone");

					return new User(name, loggedEmail, phonenumber);

				}

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;

	}

	public static String findTypeBylicenseNumber(String email) throws DAOException {
		String sql = "SELECT  license_number FROM user WHERE email = ?";
		String type = null; // Initialize to a default value
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, email);

			// Execute the SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				type = resultSet.getString("license_number");
			} else {
				throw new DAOException("User not found.");
			}

			// Close the database resources
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("Database error: " + e.getMessage());
		}
		return type;
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

//	public static void main(String[] args) {
//		User users = new User("Krishna", "gowtham.krish1705@gmail.com", "9551555232", "Gowthi@123", 0, false);
//	}

}
