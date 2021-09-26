package testingil.unittesting.examples.s03.ex;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testingil.unittesting.examples.s03.d05.controllers.ItemConfiguration;
import static org.testng.Assert.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = { CalculatorControllerConfiguration.class })
public class CalculatorDisplaySpringControllerTests extends AbstractTestNGSpringContextTests {

	MockMvc mockMvc;

	@Autowired
	CalculatorController controller;

	@Test
	public void firstTest() throws Exception {
		pressSequence("1");
		assertEquals(getDisplay(), "1");
	}

	@BeforeMethod
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
			try {
				press(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void press(char key) throws Exception {
		mockMvc.perform(post("/calculator/press")
				.param("key", Character.toString(key)));
	}

	private String getDisplay() throws Exception {
		MvcResult response = mockMvc.perform(get("/calculator/display")).andExpect(status().isOk()).andReturn();
		return response.getResponse().getContentAsString();
	}
}
