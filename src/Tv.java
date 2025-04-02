public class Tv extends Monitor {
  public Tv (String name, double price, int stock, String size, String resolution, int Hz) {
    super(name, price, stock, size, resolution, Hz);
  }

  public String toString () {
    return (
        super.toString() +
        "Is a Tv: true"
        );
  }
}
