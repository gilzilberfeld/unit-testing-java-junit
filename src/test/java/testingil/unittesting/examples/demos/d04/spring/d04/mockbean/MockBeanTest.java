package testingil.unittesting.examples.demos.d04.spring.d04.mockbean;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = { EmptyConfiguration.class })
public class MockBeanTest {

	@MockBean(answer = Answers.RETURNS_DEEP_STUBS)
	@Autowired
	ItemRepository repository;

	@Test
	public void repository_is_created() {
		assertThat(repository).isNotNull();
		assertThat(repository.getTemplate()).isNotNull();
		assertThat(repository.getTemplate().getDataSource()).isNotNull();
	}
}
