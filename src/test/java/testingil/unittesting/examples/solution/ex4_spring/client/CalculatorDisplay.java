package testingil.unittesting.examples.solution.ex4_spring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import testingil.unittesting.examples.solution.ex4_spring.OperationType;

public class CalculatorDisplay {
    @Autowired
    RestTemplate realCalculatorService;

    String display = "";
    int lastArgument = 0;
    int result = 0;
    Boolean newArgument = false;
    Boolean shouldReset = true;

    OperationType lastOperation;

    public void press(String key) {
        switch (key){
            case "C":
                display="";
                return;
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
        call_real_calculator( lastOperation, currentArgument, lastArgument);
        shouldReset = true;
    }

    private void call_real_calculator(OperationType operation, int currentArgument, int lastArgument) {
        try {
            String expression = Integer.toString(lastArgument) + operation.toString() + Integer.toString(currentArgument);
            HttpEntity<String> request = new HttpEntity<>(expression);
            ResponseEntity<String> result =
                    realCalculatorService.exchange("/calc/" , HttpMethod.POST,
                            request, String.class);
            display = result.getBody();
        }
        catch (HttpClientErrorException e) {
            if (e.getStatusCode()== HttpStatus.FORBIDDEN)
                display ="E";
        }
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