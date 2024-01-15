package testingil.unittesting.examples.solution.ex5_spring.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testingil.unittesting.examples.solution.ex5_spring.CalculatorController;
import testingil.unittesting.examples.solution.ex5_spring.CalculatorDisplay;
import testingil.unittesting.examples.solution.ex5_spring.ExternalDisplay;

import static org.mockito.Mockito.mock;

@Configuration
public class CalculatorControllerConfiguration {

	@Bean
	public CalculatorController calculatorController() {
		return new CalculatorController();
	}
	
	@Bean
	public CalculatorDisplay calculatorDisplay() {
		return new CalculatorDisplay();
	}

	@Bean
	public ExternalDisplay externalDisplay() {return mock(ExternalDisplay.class);}
}
