package testingil.unittesting.examples.solution.ex5_refactoring.ex3.storeditem;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items)    {
        this.items = items;
    }
    
    public void updateQuality() {
    	for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        switch (item.name)
        {
            case "Aged Brie":
                new AgedBrie(item).update();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                new Backstage(item).update();
                break;
            case "+5 Dexterity Vest":
            case "Elixir of the Mongoose":
                new DexterityOrElixir(item).update();
                break;
        }
    }

}
