package testingil.unittesting.examples.solution.ex5_refactoring.ex3.storeditem;

public abstract class StoredItem {
    protected Item item;
    protected String message;

    public StoredItem(Item item) {
        this.item = item;
        this.message = "";
    }

    public abstract void update();

    protected void decreaseSellIn() {
        this.item.sellIn = this.item.sellIn - 1;
    }

    protected void increaseQuality() {
        this.item.quality = this.item.quality + 1;
    }

    protected void decreaseQuality() {
        this.item.quality = this.item.quality - 1;
    }
}

