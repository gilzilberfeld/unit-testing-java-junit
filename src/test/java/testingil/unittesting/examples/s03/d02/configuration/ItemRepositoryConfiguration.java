package testingil.unittesting.examples.s03.d02.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JdbcConfiguration.class)	
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return new ItemRepository();
	}

}
