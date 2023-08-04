package turbotrip.service;

import turbotrip.dao.CarDAO;
import turbotrip.dao.exception.DAOException;
import turbotrip.model.Car;
import turbotrip.service.exception.ServiceException;
import turbotrip.validation.CarValidator;
import turbotrip.validation.exception.InvalidUserException;

public class CarService {
	public boolean createCar(Car car) throws ServiceException {
		CarDAO carDAO = new CarDAO();
		try {
			CarValidator.validateCar(car);
			if (carDAO.createCar(car)) {
				System.out.println(car.getCarNo() + " Successfully Your Car registered!");
				return true;
			} else {
				System.out.println("not successfully added");
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}
		
		}
}

	