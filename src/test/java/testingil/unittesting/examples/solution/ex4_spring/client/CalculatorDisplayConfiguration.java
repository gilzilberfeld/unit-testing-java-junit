package testingil.unittesting.examples.solution.ex4_spring.client;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class CalculatorDisplayConfiguration {
    @Bean
    public CalculatorDisplay calculatorDisplay(){
        return new CalculatorDisplay();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
