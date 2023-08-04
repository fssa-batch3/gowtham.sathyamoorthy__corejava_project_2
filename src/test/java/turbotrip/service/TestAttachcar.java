package turbotrip.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import turbotrip.service.CarService;
import turbotrip.model.Car;
import turbotrip.service.exception.ServiceException;

public class TestAttachcar {
	public static void main(String[] args) {
		Car user1 = new Car("TN 07 CD 2344", "Car", "https://media.istockphoto.com/id/495605964/photo/generic-compact-red-car.jpg?s=612x612&w=0&k=20&c=eElEDukSWi6HsUPXflSebpUm7j9tPNq7WvFOGIlqgeA=","it is five seater ");
		CarService carService = new CarService();

		try {
			carService.createCar(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test 

	public void testCarAdded() {
		CarService carService = new CarService();
		Car car = new Car("TN 07 CD 2344", "Car", "https://media.istockphoto.com/id/495605964/photo/generic-compact-red-car.jpg?s=612x612&w=0&k=20&c=eElEDukSWi6HsUPXflSebpUm7j9tPNq7WvFOGIlqgeA=","It is a five seater");
		try {
			
			assertTrue(carService.createCar(car));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}
	
}
