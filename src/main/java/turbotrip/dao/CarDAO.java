package turbotrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import turbotrip.dao.exception.DAOException;
import turbotrip.model.Car;
import turbotrip.model.User;

public class CarDAO {
	public static void main(String[] args) {
		try {
			Connection connect = getConnection();
			System.out.println(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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
	}
		
