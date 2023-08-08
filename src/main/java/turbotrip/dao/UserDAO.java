package turbotrip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import turbotrip.dao.exception.DAOException;
import turbotrip.model.User;

public class UserDAO {

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
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}

		try {
			connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to database");
		}
		return connect;
	}

	public boolean login(User user) throws SQLException {
		Connection connection = getConnection();
		String query = "SELECT * FROM USER WHERE email = ? AND PASSWORD = ?";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());
		ResultSet rs = pmt.executeQuery();
		return rs.next();
	}

	public boolean createUser(User user) throws DAOException {
		final String insertQuery = "INSERT INTO user(username, email, phone, password)VALUES (?,?,?,?)";
		try (Connection connect = getConnection(); PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPhone());

			pst.setString(4, user.getPassword());

			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

}
