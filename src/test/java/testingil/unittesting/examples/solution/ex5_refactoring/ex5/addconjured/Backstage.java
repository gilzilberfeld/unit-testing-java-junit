package testingil.unittesting.examples.solution.ex5_refactoring.ex5.addconjured;

public class Backstage extends StoredItem {
    public Backstage(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (this.item.quality < 50) {
            this.increaseQuality();
            if (this.item.quality < 50) {
                if (this.item.sellIn < 11) {
                    this.increaseQuality();
                }
                if (this.item.sellIn < 6) {
                    this.increaseQuality();
                }
            }
        }
        this.decreaseSellIn();
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        }
    }
}
