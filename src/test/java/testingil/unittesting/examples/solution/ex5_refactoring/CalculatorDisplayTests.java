package testingil.unittesting.examples.solution.ex5_refactoring;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorDisplayTests {

	CalculatorDisplay cd;
	TestLogger log;
	
	@BeforeEach
	public void setup() {
		cd = new CalculatorDisplay();
		log = new TestLogger();
	}

	@Test
	@Disabled()
	public void CharacterizationTests() throws Exception	{
		pressSequence("1");
		pressSequence("12");
		pressSequence("13+");
		pressSequence("11+5");
		pressSequence("21/3");
		pressSequence("15/5=");
		pressSequence("1+2=");
		pressSequence("1C");
		pressSequence("21C");
		pressSequence("C1C");
		Approvals.verify(log.getAll());
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> 
			(char) i).forEach(c -> press (c));
	}

	private void press(char key) {
		cd.press(Character.toString(key));
		log.append(key, cd.getDisplay());
	}

}
