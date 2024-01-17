package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

public class ItemFactory {
    public static StoredItem getItemByName(Item item) {
        if (item.name.contains("Conjured"))
            return new Conjured(item);
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage(item);
            case "+5 Dexterity Vest":
            case "Elixir of the Mongoose":
                return new DexterityOrElixir(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return null;
        }
    }
}
