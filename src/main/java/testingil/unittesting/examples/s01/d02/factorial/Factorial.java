package testingil.unittesting.examples.s01.d02.factorial;

public class Factorial {
	public static int calculate(int number) {
		if (number <= 1)
			return number;
		else
			return calculate(number-1)*number;
	}
}
