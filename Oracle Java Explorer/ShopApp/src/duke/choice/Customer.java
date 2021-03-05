package duke.choice;

public class Customer {
  private String name;
  private String size;
  private Clothing[] items;


  public Customer() {

  }

  public Customer(String name) {
    this.name = name;
  }

  public Customer(String name, int size) {
    this.name = name;
    setSize(size);
  }

  public Customer(String name, String size) {
    this.name = name;
    setSize(size);
  }

  public String getSize() {
    return size;
  }

  public String getName() {
    return name;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSize(int measurement) {
    switch (measurement) {
      case 1:
      case 2:
      case 3:
        setSize("S");
        break;
      case 4:
      case 5:
      case 6:
        setSize("M");
        break;
      case 7:
      case 8:
      case 9:
        setSize("L");
        break;
      default:
        setSize("XL");
    }
  }

  public void addItems(Clothing[] items) {
    this.items = items;
  }

  public Clothing[] getItems() {
    return items;
  }

  public double getTotalClothingCost() {
    double total = 0.0;
    for (Clothing item : items) {
      if (getSize().equals(item.getSize())) {
//        total += item.getPrice() * (1 + tax);
        total += item.getPrice();
      }
      if (total > 15) {
        break;
      }
    }
    return total;
  }

  public double getAveragePrice() {
    int aantal = 0;
    double total = 0;
    for (Clothing item : items) {
      if (item.getSize().equals("L")) {
        total += item.getPrice();
        aantal++;
      }
    }
    try {
      return total / aantal;
    } catch (ArithmeticException E) {
      if (aantal == 0) {
        System.out.println("Divide by zero...");
      }
      return 0;
    }
  }
}
