package testingil.unittesting.examples.solution.ex1_basic_tests;

public class CalculatorDisplay {
    String display="0";

    public String getDisplay() {
        return display;
    }

    public void press(String key) {
        if (display.equals("0"))
            display = key;
        else
            display += key;
    }
}
