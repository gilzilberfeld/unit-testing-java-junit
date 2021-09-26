package testingil.unittesting.examples.s03.d04.mockbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

import org.mockito.Answers;

@SpringBootTest
@ContextConfiguration(classes = { EmptyConfiguration.class })
public class MockBeanTest extends AbstractTestNGSpringContextTests {

	@MockBean(answer = Answers.RETURNS_DEEP_STUBS)
	@Autowired
	ItemRepository repository;

	@Test
	public void repository_is_created() {
		assertNotNull(repository);
		assertNotNull(repository.getTemplate());
		assertNotNull(repository.getTemplate().getDataSource());
	}
}
