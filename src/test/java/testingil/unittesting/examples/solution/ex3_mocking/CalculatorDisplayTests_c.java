package testingil.unittesting.examples.solution.ex3_mocking;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// 3. Use Mockito with The Plasma Screen
public class CalculatorDisplayTests_c {


	@Test
	public void when_plasma_is_on_display_is_correct() {
		ExternalDisplay display = mock(PlasmaWrapper.class);
		when(display.isOn()).thenReturn(true);
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		verify(display).show("1");
	}

	@Test
	public void when_plasma_is_on_display_is_correct_static() {
		try (var mh = mockStatic(PlasmaScreen.class))
		{
			when(PlasmaScreen.isOn()).thenReturn(true);
			CalculatorDisplay_WithPlasma cd = new CalculatorDisplay_WithPlasma();
			cd.press("1");
			mh.verify(()-> PlasmaScreen.show("1"));
		}
	}

}
