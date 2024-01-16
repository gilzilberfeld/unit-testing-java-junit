package testingil.unittesting.examples.demos.d01.factorial;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests {

	@Test
	public void factorials_junit() {
		assertEquals(1, Factorial.calculate(1));
		assertEquals(2, Factorial.calculate(2));
		assertEquals(6, Factorial.calculate(3));
		assertEquals(3628800, Factorial.calculate(10));
	}

	@Test
	public void factorials_assertj() {
		assertThat(Factorial.calculate(1)).isEqualTo(1);
		assertThat(Factorial.calculate(2)).isEqualTo(2);
		assertThat(Factorial.calculate(3)).isEqualTo(6);
		assertThat(Factorial.calculate(10)).isEqualTo(3628800);
	}
}