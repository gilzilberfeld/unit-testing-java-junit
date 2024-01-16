package testingil.unittesting.examples.exercise.e04.refactoring;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GildedRoseTests {

    List<Item> items = List.of(
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));

    @Test
    @Disabled
    public void gilded_rose_first_update() {
        String log = "Before Update\n";
        log += printItems();
        Item[] itemsArray =new Item[items.size()];
        items.toArray(itemsArray);
        new GildedRose(itemsArray ).updateQuality();
        log += "\nAfter Update\n";
        log += printItems();

        Approvals.verify(log);
    }

    public String printItems() {
        final StringBuilder itemLog = new StringBuilder();
        itemLog.append("name, sellIn, quality\n");
        items.forEach(item -> {
            itemLog.append(item.toString());
            itemLog.append("\n");
        });

        return itemLog.toString();
    }

}
