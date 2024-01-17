package testingil.unittesting.examples.solution.ex4_spring.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import testingil.unittesting.examples.solution.ex4_spring.CalculatorController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// add some characterization tests
// refactor the tests
// add reset method
@SpringBootTest
@ContextConfiguration(classes = { CalculatorControllerConfiguration.class })
public class CalculatorDisplaySpringControllerTests {

	public static final String CALCULATOR_PRESS_URL = "/calculator/press";
	public static final String CALCULATOR_DISPLAY_URL = "/calculator/display";
	public static final String CALCULATOR_RESET_URL = "/calculator/reset";
	MockMvc mockMvc;

	@Autowired
	CalculatorController controller;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void characterization_tests() throws Exception {
		pressing("1").shouldDisplay("1");
		pressing("12").shouldDisplay("12");
		pressing("13+").shouldDisplay("13");
		pressing("11+5").shouldDisplay("5");
		pressing("21/3").shouldDisplay("3");
		pressing("1+2=").shouldDisplay("3");
	}

	private void shouldDisplay(String expected) throws Exception {
		assertThat(getDisplay()).isEqualTo(expected);
	}


	private CalculatorDisplaySpringControllerTests pressing(String sequence) throws Exception {
		resetCalculator();
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
			try {
				press(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return this;
	}

	private void resetCalculator() throws Exception {
		mockMvc.perform(post(CALCULATOR_RESET_URL))
				.andExpect(status().isOk());
	}

	private void press(char key) throws Exception {
		mockMvc.perform(post(CALCULATOR_PRESS_URL)
				.param("key", Character.toString(key)));
	}

	private String getDisplay() throws Exception {
		MvcResult response = mockMvc.perform(get(CALCULATOR_DISPLAY_URL)).andExpect(status().isOk()).andReturn();
		return response.getResponse().getContentAsString();
	}
}
