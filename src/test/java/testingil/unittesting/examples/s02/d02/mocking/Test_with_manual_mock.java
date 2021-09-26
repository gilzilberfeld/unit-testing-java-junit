package testingil.unittesting.examples.s02.d02.mocking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_with_manual_mock{

	@Test
	void cannot_drive_a_running_car() {
		Car mockCar = new Mock_RunningCar();
		Driver driver = new Driver(mockCar);
		
		assertFalse(driver.canDrive());
		
	}

}
