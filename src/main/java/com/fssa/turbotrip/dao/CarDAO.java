package com.fssa.turbotrip.dao;

import java.sql.Connection;

import com.fssa.turbotrip.utils.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;

public class CarDAO {
// This is Attaching new car in the CarList
	public boolean createCar(Car car) throws DAOException {
		final String insertQuery = "INSERT INTO car_list (driver_id, car_number, car_model, car_image, car_description)VALUES (?,?,?,?,?)";
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			pst.setInt(1, car.getUserId());
			pst.setString(2, car.getCarNo().toLowerCase().trim());
			pst.setString(3, car.getCarmodel());
			pst.setString(4, car.getCarImage());
			pst.setString(5, car.getDescription());
			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

// This is read CarList code
	public String readCar(Car car) throws DAOException {
		String selectQuery = "SELECT * FROM project.car_list WHERE car_number = ?";
		ResultSet result = null;
		StringBuilder resultBuilder = new StringBuilder();
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(selectQuery)) {
			pst.setString(1, car.getCarNo().toLowerCase().trim());
			result = pst.executeQuery();

			if (!result.isBeforeFirst()) {
				return "No Car found for this Number " + car.getCarNo();
			}

			while (result.next()) {
				String number = result.getString("car_number");
				String model = result.getString("car_model");
				String img = result.getString("car_image");
				String description = result.getString("car_description");

				resultBuilder.append("carNumber: ").append(number).append(", carModel: ").append(model)
						.append(", carImage: ").append(img).append(", carDescription: ").append(description)
						.append("\n");

			}
			return resultBuilder.toString();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// This is Update the Car details in carList

	public static boolean updateCar(Car car, String Carno) throws DAOException {
		String updateQuery = "UPDATE car_list SET car_image=?, car_description=? WHERE car_number=?";
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(updateQuery)) {
			pst.setString(1, car.getCarImage());
			pst.setString(2, car.getDescription());
			pst.setString(3, Carno.toLowerCase().trim());
			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean sameNumberExist(String Carno) throws SQLException, DAOException {
		boolean match = false;
		int count = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM car_list WHERE car_number = ?");) {

			pst.setString(1, Carno);
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String num1 = resultSet.getString("car_number");
					System.out.println("carno: " + num1);
					if (Carno.toLowerCase().trim().equals(num1)) {
						count++;
					}
				}
			}

			if (count > 0) {
				match = true;
			}
		} catch (SQLException e) {
			throw new DAOException("Error: " + e);
		}

		return match;
	}

	// This is Delete the car details in the CarList

	public boolean deleteCar(String Carno, int isDeleted) throws DAOException {
		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String isDelete = Integer.toString(isDeleted);
			String deleteQuery = "UPDATE car_list SET is_deleted = ? WHERE car_number = '" + Carno.toLowerCase().trim()
					+ "';";
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, isDelete);
			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while deleting car: " + e);
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
		// Return Successful or not
		return (rows == 1);
	}

}
