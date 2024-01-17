package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GildedRoseTests {


    private static List<Item> createItemList() {
        return List.of(
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6));
    }

    @Test
    public void gilded_rose_30_days() {
        List<Item> items = createItemList();
        Item[] itemsArray =new Item[items.size()];
        items.toArray(itemsArray);
        MockNotifier notifier = new MockNotifier();
        GildedRose gildedRose = new GildedRose(itemsArray, notifier);
        String log ="";

        for( int day=0; day<30; day++){
            log += "Day " + day + "\n";
            log += printItems(items);
            gildedRose.updateQuality();
            log += "\n";
        }
        Approvals.verify(log);
    }

    @Test
    public void gilded_rose_notifer_messages_30_Days(){
        List<Item> items = createItemList();
        Item[] itemsArray =new Item[items.size()];
        items.toArray(itemsArray);
        MockNotifier notifier = new MockNotifier();
        GildedRose gildedRose = new GildedRose(itemsArray, notifier);

        for( int day=0; day<30; day++){
            gildedRose.updateQuality();
        }
        Approvals.verify(notifier.notification_log);
    }

    public String printItems(List<Item> items) {
        final StringBuilder itemLog = new StringBuilder();
        itemLog.append("name, sellIn, quality\n");
        items.forEach(item -> {
            itemLog.append(item.toString());
            itemLog.append("\n");
        });

        return itemLog.toString();
    }

}
