package testingil.unittesting.examples.solution.ex3_mocking;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

// 4. Use Mockito with The Plasma Screen
public class CalculatorDisplayTests_d {


	@Test
	public void when_plasma_is_on_display_is_correct() throws Exception {
		ExternalDisplay display = mock(PlasmaWrapper.class);
		when(display.isOn()).thenReturn(true);
		CalculatorDisplay cd = new CalculatorDisplay(display);
		cd.press("1");
		verify(display).show("1");
	}

	@Test
	public void when_plasma_is_on_display_is_correct_static() throws Exception{
		try (MockedStatic<PlasmaScreen> mh = mockStatic(PlasmaScreen.class))
		{
			when(PlasmaScreen.isOn()).thenReturn(true);
			CalculatorDisplay_WithPlasma cd = new CalculatorDisplay_WithPlasma();
			cd.press("1");
			mh.verify(()-> PlasmaScreen.show("1"));
		}
	}

}
