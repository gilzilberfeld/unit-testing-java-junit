package testingil.unittesting.examples.s03.ex;

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
