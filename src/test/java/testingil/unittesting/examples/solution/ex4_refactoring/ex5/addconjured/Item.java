package testingil.unittesting.examples.solution.ex4_refactoring.ex5.addconjured;

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
