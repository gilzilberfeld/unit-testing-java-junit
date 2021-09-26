package testingil.unittesting.examples.s02.d04.clean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import testingil.unittesting.examples.s02.d04.clean.DistanceProvider;
import testingil.unittesting.examples.s02.d04.clean.NavigationController;
import testingil.unittesting.examples.s02.d04.clean.Navigator;

@Configuration
public class NavigatorAPITestsConfig {
	
	@Bean
	public Navigator navigator() {
		return new Navigator(distanceProvider());
	}
	
	@Bean
	public NavigationController navigationController() {
		return new NavigationController();
	}
	
	@Bean
	public DistanceProvider distanceProvider() {
		return mock(DistanceProvider.class);
	}
}
