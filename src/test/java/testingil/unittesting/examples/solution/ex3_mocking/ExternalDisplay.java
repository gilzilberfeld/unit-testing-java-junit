package testingil.unittesting.examples.solution.ex3_mocking;

public interface ExternalDisplay {
    void show(String text) throws Exception;
    Boolean isOn();
}
