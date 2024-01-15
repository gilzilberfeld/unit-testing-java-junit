package testingil.unittesting.examples.solution.ex4_refactoring.ex5.addconjured;

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
        var storedItem = ItemFactory.getItemByName(item);
        storedItem.update();
    }
}
