package testingil.unittesting.examples.solution.ex4_spring.unit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testingil.unittesting.examples.solution.ex4_spring.CalculatorDisplay;
import testingil.unittesting.examples.solution.ex4_spring.ExternalDisplay;

import static org.mockito.Mockito.mock;

@Configuration
public class CalculatorConfiguration {

	@Bean
	public CalculatorDisplay calculator() {
		return new CalculatorDisplay();
	}

	@Bean
	public ExternalDisplay externalDisplay(){
		return mock(ExternalDisplay.class);
	}
}
