package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

public class Conjured extends StoredItem {
    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (this.item.quality > 0) {
            this.decreaseQuality();
            this.decreaseQuality();
        }
        this.decreaseSellIn();
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        }
        updateMessage();
    }
}


