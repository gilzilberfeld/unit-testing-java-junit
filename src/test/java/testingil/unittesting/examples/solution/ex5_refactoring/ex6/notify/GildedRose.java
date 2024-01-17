package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

public class GildedRose {
    Item[] items;
    NotifyService notifyService;

    public GildedRose(Item[] items , NotifyService notifyService)    {
        this.items = items;
        this.notifyService = notifyService;
    }
    
    public void updateQuality() {
    	for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        StoredItem storedItem = ItemFactory.getItemByName(item);
        storedItem.update();
        notifyService.notifyTownCrier(storedItem.message);
    }
}
