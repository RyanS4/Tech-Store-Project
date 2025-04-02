public class Item {
  private String name;
  private double price;
  private int stock;

  public Item (String n, double p, int s) {
    name = n;
    price = p;
    stock = s;
  }

  // getters
  public double getPrice() {
    return price;
  }

  public int getStock () {
    return stock;
  }

  public String getName () {
    return name;
  }

  //setters
  public void setPrice (double a) {
    price = a;
  }

  public void setStock (int a) {
    stock = a;
  }

  public void setName (String a) {
    name = a;
  }

  // class functions
  public String toString () {
    return (
        "Item: " + name + "\n" +
        "Price: " + price + "\n" +
        "Stock: " + stock + "\n"
        );
  }
}
