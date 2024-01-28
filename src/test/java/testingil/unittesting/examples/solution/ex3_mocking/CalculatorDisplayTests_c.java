package testingil.unittesting.examples.solution.ex3_mocking;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// 3. Use Mockito with argument matching
public class CalculatorDisplayTests_c {

	@Test
	public void when_display_passed_9999_the_display_shows_E() throws Exception {
		ExternalDisplay display = mock(ExternalDisplay.class);
		when(display.isOn()).thenReturn(true);
		doThrow(new Exception()).when(display).show("9999");

		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("9");
		cd.press("9");
		cd.press("9");
		cd.press("9");
		assertThat(cd.getDisplay()).isEqualTo("E");
	}

}
