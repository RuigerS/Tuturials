package duke.choice;

import java.util.Arrays;

public class ShopApp {

  public static void main(String[] args) {
    // write your code here
//    double tax = 0.2;
    Clothing[] items = new Clothing[5];
    Customer c1 = new Customer("Pinky", 3);
    System.out.println("Welcome to Duke Choice Shop, " + c1.getName() + "!");
    System.out.println("Minimum price: "+Clothing.MIN_PRICE);
    items[0] = new Clothing("Blue Jacket", 20.9);
    items[1] = new Clothing("Orange T-Shirt", 10.5, "S");
    items[2] = new Clothing("Orange T-Shirt", 10.5, "S");
    items[3] = new Clothing("Green scarf", 5, "S");
    items[4] = new Clothing("Blue T-Shirt", 10.5, "S");
    c1.addItems(items);
//    System.out.println("Item1: " + items[0]);
//    System.out.println("Item2: " + items[1]);
//    System.out.println("Item3: " + items[2]);

    //total = items[0].price + items[1].price + items[2].price;
    //total += tax * total;
    Arrays.sort(c1.getItems());
    for(Clothing item:c1.getItems()) {
      System.out.println("Item: " + item);
    }
    System.out.println("Total: " + c1.getTotalClothingCost());
    c1.setSize(3);
    System.out.println(c1.getSize());
    System.out.println(items[1].getPrice());
    items[1].setPrice(5);
    System.out.println("Price < 10? : "+ items[1].getPrice());
    System.out.println("Average Price c1: "+c1.getAveragePrice());
  }
}
