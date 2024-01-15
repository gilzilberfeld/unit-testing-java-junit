package testingil.unittesting.examples.solution.ex4_refactoring.ex2.refactor;

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
        if (item.name == "Aged Brie")
        {
            if (item.quality < 50)
            {
                IncreaseQuality(item);
            }
            DecreaseSellIn(item);
            if (item.quality < 50)
            {
                if (item.sellIn < 0)
                {
                    IncreaseQuality(item);
                }
            }
            return;
        }
        if (item.name == "Backstage passes to a TAFKAL80ETC concert")
        {
            if (item.quality < 50)
            {
                IncreaseQuality(item);
                if (item.quality < 50)
                {
                    if (item.sellIn < 11)
                    {
                        IncreaseQuality(item);
                    }
                    if (item.sellIn < 6)
                    {
                        IncreaseQuality(item);
                    }
                }
            }
            DecreaseSellIn(item);
            if (item.sellIn < 0)
            {
                item.quality = 0;
            }
            return;
        }
        if (item.name == "+5 Dexterity Vest" || item.name == "Elixir of the Mongoose")
        {
            if (item.quality > 0)
            {
                DecreaseQuality(item);
            }
            DecreaseSellIn(item);
            if (item.quality > 0)
            {
                if (item.sellIn < 0)
                {
                    DecreaseQuality(item);
                }
            }
        }

    }

    private void DecreaseSellIn(Item item)
    {
        item.sellIn = item.sellIn - 1;
    }

    private void IncreaseQuality(Item item)
    {
        item.quality = item.quality + 1;
    }

    private void DecreaseQuality(Item item)
    {
        item.quality = item.quality - 1;
    }

}
