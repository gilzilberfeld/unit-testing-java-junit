package testingil.unittesting.examples.solution.ex3_mocking;

public class PlasmaWrapper implements ExternalDisplay{

    @Override
    public void show(String text) {
        // PlasmaScreen.show(text)
    }

    @Override
    public Boolean isOn() {
        return true;
    }
}
