package testingil.unittesting.examples.solution.ex5_refactoring.ex4.factory;

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
        StoredItem storedItem = ItemFactory.getItemByName(item);
        storedItem.update();
    }
}
