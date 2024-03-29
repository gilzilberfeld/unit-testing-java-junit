package testingil.unittesting.examples.exercise.e04.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(classes = { CalculatorControllerConfiguration.class })
public class CalculatorDisplaySpringControllerTests{

	MockMvc mockMvc;

	@Autowired
	CalculatorController controller;

	@Test
	public void firstTest() throws Exception {
		pressSequence("1");
		assertThat(getDisplay()).isEqualTo("1");
	}

	@BeforeEach
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
