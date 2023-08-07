package turbotrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import turbotrip.dao.exception.DAOException;
import turbotrip.model.Car;

public class CarDAO {
	public static Connection getConnection() throws SQLException {
		Connection connect = null;
		String url = "jdbc:mysql://localhost/project";
		String username = "root";
		String password = "Amma@123";

		try {
			connect = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to database");
		}
		return connect;
	}

	public boolean createCar(Car car) throws DAOException {
		final String insertQuery = "INSERT INTO car_list (car_number, car_model, car_image, car_description)VALUES (?,?,?,?)";
		try (Connection connect = getConnection(); PreparedStatement pst = connect.prepareStatement(insertQuery);) {

			pst.setString(1, car.getCarNo());
			pst.setString(2, car.getCarmodel());
			pst.setString(3, car.getCarImage());
			pst.setString(4, car.getDescription());
			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public String readCar(Car car) throws DAOException {
		String selectQuery = "SELECT * FROM project.car_list WHERE car_number = ?";
		ResultSet result = null;
		StringBuilder resultBuilder = new StringBuilder();
		try (Connection connect = getConnection(); PreparedStatement pst = connect.prepareStatement(selectQuery)) {
			pst.setString(1, car.getCarNo());
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

	public static void main(String[] args) {
		Car car = new Car("TN 07 CD 9876");

		CarDAO reading = new CarDAO();
		try {
			System.out.println(reading.readCar(car));
		} catch (DAOException e) {
		
			e.printStackTrace();
		}
	}
}
