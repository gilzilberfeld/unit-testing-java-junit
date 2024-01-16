package testingil.unittesting.examples.demos.d04.spring.d02.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringMocksTest{

	@Autowired
	ItemRepository repository;

	@Autowired
	JdbcTemplate mockjdbc;
	
	@BeforeEach
	public void setup() {
		Mockito.reset(mockjdbc);
	}
	
	@Test
	@Disabled
	public void repository_is_created() {
		assertThat(repository).isNotNull();
		assertThat(repository.getTemplate()).isNotNull();
		assertThat(repository.getTemplate().getDataSource()).isNotNull();
	}
}
