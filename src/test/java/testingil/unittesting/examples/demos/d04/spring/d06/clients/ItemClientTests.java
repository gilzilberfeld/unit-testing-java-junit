package testingil.unittesting.examples.demos.d04.spring.d06.clients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@ContextConfiguration(classes= {ItemClientConfiguration.class})
public class ItemClientTests{
	
	@Autowired RestTemplate template;
	@Autowired
    ItemClient client;
	
	MockRestServiceServer mockServer;
	
	@BeforeEach
	public void setup() {
		mockServer = MockRestServiceServer.createServer(template);
	}
	
	@Test
	public void get_ServerCalledCorrectly() {
		mockServer
				.expect(once(), requestTo("/items/"))
				.andRespond(
						withSuccess("", MediaType.TEXT_PLAIN));
		client.getAllItems();
		mockServer.verify();
	}
	
	@Test
	public void add_ThrowsOnError() {
		mockServer.expect(once(), requestTo("/items/"))
			.andRespond(withBadRequest());
		assertThatThrownBy(()->client.getAllItems())
				.isInstanceOf(ItemNotFoundException.class);
	}
}


