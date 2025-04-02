public class Laptop extends Computer {
  public Laptop (String name, double price, int stock, int ram, String CPU, String GPU, double storage) {
    super(name, price, stock, ram, CPU, GPU, storage);
  }

  public String toString () {
    return (
        super.toString() +
        "Type: Laptop\n"
        );
  }
}
