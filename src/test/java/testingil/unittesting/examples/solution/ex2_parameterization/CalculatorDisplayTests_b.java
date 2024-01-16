package testingil.unittesting.examples.solution.ex2_parameterization;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


//  2. read values form CSV file
public class CalculatorDisplayTests_b {

	public static final String DATA_CSV = "src\\test\\java\\testingil\\unittesting\\examples\\solution\\ex2_parameterization\\data.csv";
	private CalculatorDisplay cd;

	@BeforeEach
	public void setup(){
		cd = new CalculatorDisplay();
	}

	static Stream<Arguments> press_displays_csv() throws Exception {
		String[][] data = new String[2][2];

		BufferedReader br =
				new BufferedReader(new FileReader(DATA_CSV));
		String line;
		int counter = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			data[counter][0] = values[0];
			data[counter][1] = values[1];
			counter++;
		}

		return Stream.of(arguments(data[0][0], data[0][1]),
				arguments(data[1][0], data[1][1]));
	};


	@Test
	public void at_start_display_0() {
		assertThat(cd.getDisplay()).isEqualTo("0");
	}

	@ParameterizedTest
	@MethodSource("press_displays_csv")
	public void pressing_keys_and_displays(String keys, String result) throws Exception{
		pressSequence(keys);
		assertThat(cd.getDisplay()).isEqualTo(result);
	}

	private void pressSequence(String sequence) throws Exception {
		sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
				cd.press(c.toString());
		});
	}

}
