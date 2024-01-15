package testingil.unittesting.examples.solution.ex3_mocking;

public class MockDisplay implements ExternalDisplay{
    public boolean isOn;
    private String text;

    @Override
    public void show(String text) {
        this.text = text;
    }

    @Override
    public Boolean isOn() {
        return isOn;
    }

    public String getText() {
        return this.text;
    }
}
