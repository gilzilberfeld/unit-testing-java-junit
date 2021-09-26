package testingil.unittesting.examples.s02.d05.characterization;

import org.approvaltests.Approvals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorDisplayTests {

	CalculatorDisplay cd;
	TestLogger log;
	
	@BeforeTest
	public void setup() {
		cd = new CalculatorDisplay();
		log = new TestLogger();
	}
	
	@Test(enabled = true)
	public void CheckDisplayTest() throws Exception
	{
		cd.press("1");
		Approvals.verify(cd.getDisplay());
	}
	
	
	@Test(enabled = false)
	public void ComplexOperationsTest() throws Exception	{
		pressSequence("1+2=");
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
