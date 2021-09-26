package testingil.unittesting.examples.s03.d06.clients;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
@ContextConfiguration(classes= {ItemClientConfiguration.class})
public class ItemClientTests extends AbstractTestNGSpringContextTests{
	
	@Autowired RestTemplate template;
	@Autowired ItemClient	client;
	
	MockRestServiceServer mockServer;
	
	@BeforeMethod
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
	
	@Test(expectedExceptions = { ItemNotFoundException.class })
	public void add_ThrowsOnError() {
		mockServer.expect(once(), requestTo("/items/"))
			.andRespond(withBadRequest());
		client.getAllItems();
	}
}


