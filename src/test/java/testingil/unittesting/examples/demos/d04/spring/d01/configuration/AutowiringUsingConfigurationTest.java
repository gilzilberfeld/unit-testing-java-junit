package testingil.unittesting.examples.demos.d04.spring.d01.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringUsingConfigurationTest{

	@Autowired
	ItemRepository repository;

	//@Test
	//@Disabled
	public void repository_is_created() {
		assertThat(repository).isNotNull();
		assertThat(repository.getTemplate()).isNotNull();
	}
}
