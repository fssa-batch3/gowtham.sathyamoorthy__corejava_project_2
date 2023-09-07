package com.fssa.turbotrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Car;

import com.fssa.turbotrip.utils.ConnectionUtil;

public class CarDAO {
	private static final String CARNUMBER = "car_number";

	/**
	 * 
	 * Creates a new car entry in the database.
	 * 
	 * @param car The Car object containing car information to be inserted.
	 * @return True if the car was successfully created, false otherwise.
	 * @throws DAOException If an SQL exception occurs while attempting to create
	 *                      the car.
	 */
	public boolean createCar(Car car) throws DAOException {
		final String insertQuery = "INSERT INTO car_list (driver_id, car_number, car_model, car_image, car_description) VALUES (?,?,?,?,?)";
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

	/**
	 * Reads car information from the database based on car object's car number.
	 *
	 * @param car The Car object contains the car number for which information is to be get.
	 * @return A string containing car details if found, or an error message if no car is found.
	 * @throws DAOException If an SQL exception occurs while attempting to read car information.
	 */
	public String readCar(Car car) throws DAOException {
		String selectQuery = "SELECT * FROM gowtham_sathyamoorthy_corejava_project.car_list WHERE car_number = ?";
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
				String number = result.getString(CARNUMBER);
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

	/**
	 * Updates a car's information in the database.
	 *
	 * @param car The Car object containing the updated car information.
	 * @param Carno The car number to identify the car to update.
	 * @return True if the car information was successfully updated, false otherwise.
	 * @throws DAOException If there is an error during the update process, a DAOException is thrown.
	 */

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
					String num1 = resultSet.getString(CARNUMBER);

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

	/**
	 * Deletes a car from the database by updating its "is_deleted" status.
	 *
	 * @param Carno The car number is identify the car to delete.
	 * @param isDeleted The new status (0 for not deleted, 1 for deleted) to set for the car.
	 * @return True if the car was successfully deleted, false otherwise.
	 * @throws DAOException If there is an error during the deletion process, a DAOException is thrown.
	 */

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

	/**
	 *
	 *
	 * @return
	 * @throws DAOException
	 */
	public List<Car> getAllCars() throws DAOException {
		final String selectCarListQuery = "SELECT * FROM car_list WHERE is_deleted=0";
		List<Car> cars = new ArrayList<>();
		try (Connection connect = ConnectionUtil.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectCarListQuery)) {
			while (rs.next()) {
				int carId = rs.getInt("car_id");
				String CarNo = rs.getString(CARNUMBER);
				String Carmodel = rs.getString("car_model");
				String CarImage = rs.getString("car_image");
				String Description = rs.getString("car_description");

				Car car = new Car(carId, CarNo, Carmodel, CarImage, Description);
				cars.add(car);

			}

		}

		catch (SQLException e) {
			throw new DAOException(e);
		}
		return cars;
	}

	

	}
