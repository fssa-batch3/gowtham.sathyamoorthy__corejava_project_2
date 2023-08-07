package turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import turbotrip.dao.exception.DAOException;
import turbotrip.model.Car;
import turbotrip.service.exception.ServiceException;
import turbotrip.validation.exception.InvalidUserException;

public class TestUpdateCarList {

	
	@Test
	public void testUpdateSuccess() throws ServiceException, InvalidUserException, DAOException {
		CarService carService = new CarService();
		String Carno = "TN 07 CD 1234";
		Car car1 = new Car("https://example.com","It is nine seater");
		assertTrue(carService.updateCar(car1,Carno));
	}
		
	
	
}
