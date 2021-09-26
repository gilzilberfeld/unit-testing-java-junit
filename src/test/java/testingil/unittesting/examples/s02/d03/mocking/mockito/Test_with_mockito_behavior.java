package testingil.unittesting.examples.s02.d03.mocking.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import testingil.unittesting.examples.s02.d02.mocking.Car;
import testingil.unittesting.examples.s02.d02.mocking.Driver;

class Test_with_mockito_behavior {

	@Test
	void a_running_car() {
		Car mockCar = mock(Car.class);
		when(mockCar.isRunning()).thenReturn(true);
		
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
	}

}
