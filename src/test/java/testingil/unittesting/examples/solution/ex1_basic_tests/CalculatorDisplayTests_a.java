package testingil.unittesting.examples.solution.ex1_basic_tests;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


// 1. Write tests
// 2. Incremental coding
public class CalculatorDisplayTests_a {

	@Test
	public void at_start_display_0() {
		CalculatorDisplay cd = new CalculatorDisplay();
		assertThat(cd.getDisplay()).isEqualTo("0");
	}

	@Test
	public void pressing_1_displays_1(){
		CalculatorDisplay cd = new CalculatorDisplay();
		cd.press("1");
		assertThat(cd.getDisplay()).isEqualTo("1");
	}

	@Test
	public void pressing_12_displays_12(){
		CalculatorDisplay cd = new CalculatorDisplay();
		cd.press("1");
		cd.press("2");
		assertThat(cd.getDisplay()).isEqualTo("12");
	}
}
