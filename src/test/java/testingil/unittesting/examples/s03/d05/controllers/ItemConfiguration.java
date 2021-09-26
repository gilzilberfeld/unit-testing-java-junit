package testingil.unittesting.examples.s03.d05.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfiguration {
	@Bean
	public ItemController itemController() {
		return new ItemController();
	}
}