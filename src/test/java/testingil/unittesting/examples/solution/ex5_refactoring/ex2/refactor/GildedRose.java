package testingil.unittesting.examples.solution.ex5_refactoring.ex2.refactor;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
            decreaseSellIn(item);
            if (item.quality < 50) {
                if (item.sellIn < 0) {
                    increaseQuality(item);
                }
            }
            return;
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                increaseQuality(item);
                if (item.quality < 50) {
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }
                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }
            }
            decreaseSellIn(item);
            if (item.sellIn < 0) {
                item.quality = 0;
            }
            return;
        }
        if (item.name.equals("+5 Dexterity Vest") || item.name.equals("Elixir of the Mongoose")) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
            decreaseSellIn(item);
            if (item.quality > 0) {
                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
            }
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

}

