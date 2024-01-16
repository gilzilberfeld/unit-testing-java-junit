package testingil.unittesting.examples.demos.d01.factorial;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FixtureFactorialTests {

	private Factorial factorial;

	@BeforeEach
	public void setup(){
		factorial = new Factorial();
	}

	@Test
	public void factorial_tests() {
		assertThat(Factorial.calculate(1)).isEqualTo(1);
		assertThat(Factorial.calculate(2)).isEqualTo(2);
		assertThat(Factorial.calculate(3)).isEqualTo(6);

	}

	@Disabled
	@Test
	public void negative_factorial() {
		assertThat(Factorial.calculate(-3)).isEqualTo(0);
	}

	@Test
	public void big_factorial() {
		assertThat(Factorial.calculate(10)).isEqualTo(3628800);
	}
}