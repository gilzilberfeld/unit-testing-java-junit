package testingil.unittesting.examples.s03.d03.mocking;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ItemRepositoryConfiguration {
	
	@Bean
	public ItemRepository itemRepository() {
		return new ItemRepository();
	}

	@Bean 
	public JdbcTemplate jdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
}
