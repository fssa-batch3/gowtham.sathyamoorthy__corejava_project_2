  package com.fssa.turbotrip.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.fssa.turbotrip.dao.exception.DAOException;
import com.fssa.turbotrip.model.Driver;

import com.fssa.turbotrip.utils.ConnectionUtil;

public class DriverDAO {
	// This code is Create new Driver details in Driver table
	public boolean createDriver(Driver driver) throws DAOException {
		final String insertQuery = "INSERT INTO driver(user_id, aadhar_number, licensence_number, experience )VALUES (?,?,?,?)";
		try (Connection connect = ConnectionUtil.getConnection();
				PreparedStatement pst = connect.prepareStatement(insertQuery);) {
			pst.setInt(1, driver.getId());
			pst.setLong(2, driver.getAadhar_number());
			pst.setString(3, driver.getLicensence_number());
			pst.setInt(4, driver.getExperience());

			int rows = pst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
	}

	

