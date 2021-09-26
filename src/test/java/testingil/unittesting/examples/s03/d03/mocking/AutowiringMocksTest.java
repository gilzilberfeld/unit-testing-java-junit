package testingil.unittesting.examples.s03.d03.mocking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

import org.mockito.Mockito;

@SpringBootTest
@ContextConfiguration(classes = { ItemRepositoryConfiguration.class })
public class AutowiringMocksTest extends AbstractTestNGSpringContextTests {

	@Autowired
	ItemRepository repository;

	@Autowired
	JdbcTemplate mockjdbc;
	
	@BeforeMethod
	public void setup() {
		Mockito.reset(mockjdbc);
	}
	
	@Test(enabled = false)
	public void repository_is_created() {
		assertNotNull(repository);
		assertNotNull(repository.getTemplate());
		assertNotNull(repository.getTemplate().getDataSource());
	}
}
