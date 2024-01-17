package testingil.unittesting.examples.solution.ex5_refactoring.ex2.refactor;

public class Item {

    public String name;

    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
   
   
}
