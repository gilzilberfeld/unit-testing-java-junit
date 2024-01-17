package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

public class Sulfuras extends StoredItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void update() {
        updateMessage();
    }
}
