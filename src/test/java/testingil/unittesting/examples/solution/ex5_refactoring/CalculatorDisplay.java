package testingil.unittesting.examples.solution.ex5_refactoring;

public class CalculatorDisplay {
    String display = "";
    int lastArgument = 0;
    int result = 0;
    Boolean newArgument = false;
    Boolean shouldReset = true;

    OperationType lastOperation;

    public void press(String key) {
        switch (key){
            case "+":
                handleOperation(OperationType.Plus);
                return;
            case "/":
                handleOperation(OperationType.Div);
                return;
            case "=":
                handleEquals();
                return;
            default:
                handleNumber(key);
        }
    }

    private void handleNumber(String key) {
        if (shouldReset) {
            display = "";
            shouldReset = false;
        }
        if (newArgument) {
            display = "";
            newArgument = false;
        }
        display += key;
    }

    private void handleEquals() {
        int currentArgument = Integer.parseInt(display);
        if (lastOperation == OperationType.Plus) {
            display = Integer.toString(lastArgument + currentArgument);
        }
        if (lastOperation == OperationType.Div && currentArgument == 0) {
            display = "Division By Zero Error";
        }
        shouldReset = true;
    }


    private void handleOperation(OperationType op) {
        lastOperation = op;
        lastArgument = Integer.parseInt(display);
        newArgument = true;
    }

    public String getDisplay() {
        if (display.equals(""))
            return "0";
        if (display.length() > 5)
            return "E";
        return display;
    }

}