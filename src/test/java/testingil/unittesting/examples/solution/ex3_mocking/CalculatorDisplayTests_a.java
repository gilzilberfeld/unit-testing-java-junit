package testingil.unittesting.examples.solution.ex3_mocking;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1. mock manually external display
public class CalculatorDisplayTests_a {

	@Test
	public void when_display_is_off_display_not_connected() {
		MockDisplay display = new MockDisplay();
		display.isOn = false;
		CalculatorDisplay cd = new CalculatorDisplay(display);

		assertThat(cd.hasDisplayConnected).isFalse();
	}

	@Test
	public void when_display_is_on_display_is_correct() {
		MockDisplay display = new MockDisplay();
		display.isOn = true;
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		assertThat(display.getText()).isEqualTo("1");
	}

}
