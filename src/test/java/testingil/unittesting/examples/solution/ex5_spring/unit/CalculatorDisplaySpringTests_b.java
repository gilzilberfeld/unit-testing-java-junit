package testingil.unittesting.examples.solution.ex5_spring.unit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import testingil.unittesting.examples.solution.ex5_spring.CalculatorDisplay;
import testingil.unittesting.examples.solution.ex5_spring.ExternalDisplay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {CalculatorConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CalculatorDisplaySpringTests_b  {

    @Autowired
    CalculatorDisplay cd;
    @Autowired
    ExternalDisplay display;


    @Test
    public void when_display_is_off_calc_not_connected() {
        when(display.isOn()).thenReturn(false);
        cd.press("1");
        assertThat(cd.hasDisplayConnected).isFalse();
    }

    @Test
    public void when_display_is_on_display_is_correct() {
        when(display.isOn()).thenReturn(true);
        cd.press("1");
        verify(display).show("1");
    }
}
