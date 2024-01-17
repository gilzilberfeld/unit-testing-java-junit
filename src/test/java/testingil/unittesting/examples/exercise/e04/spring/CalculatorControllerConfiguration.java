package testingil.unittesting.examples.exercise.e04.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorControllerConfiguration {

	@Bean
	public CalculatorController calculatorController() {
		return new CalculatorController();
	}
	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
