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

public class UserDAO {
	// this code is checking togin user from the User table
	// Get user from DB - Login
		public boolean login(String email, String password) throws DAOException {
			String selectQuery = "SELECT * FROM user WHERE email = ?";
			try (Connection connection = ConnectionUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(selectQuery)) {

				System.out.println(email);
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
		final String insertQuery = "INSERT INTO user( username, email, phone, password, is_deleted, is_driver)VALUES (?,?,?,?,?,?)";
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
				boolean is_driver = rs.getBoolean("is_driver");
			
				User user = new User(username, email, phone, password, is_deleted, is_driver);
				user.setUser_id(userId);
				users.add(user);
			}  
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return users;
	}

//	public static void main(String[] args) {
//		User users = new User("Krishna", "gowtham.krish1705@gmail.com", "9551555232", "Gowthi@123", 0, false);
//	}

}
