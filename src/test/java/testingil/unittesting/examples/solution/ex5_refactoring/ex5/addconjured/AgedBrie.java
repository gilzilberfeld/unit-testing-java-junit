package testingil.unittesting.examples.solution.ex5_refactoring.ex5.addconjured;

public class AgedBrie extends StoredItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (this.item.quality < 50) {
            this.increaseQuality();
        }
        this.decreaseSellIn();
        if (this.item.quality < 50) {
            if (this.item.sellIn < 0) {
                this.increaseQuality();
            }
        }
    }
}
