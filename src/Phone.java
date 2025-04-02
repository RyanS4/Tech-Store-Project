public class Phone extends Item {
  private String model;
  private boolean hasSIMCard;
  private String size;
  
  public Phone (String name, double price, int stock, String m, boolean h, String s) {
    super(name, price, stock);
    model = m;
    hasSIMCard = h;
    size = s;
  }

  // getters
  public String getModel () {
    return model;
  }

  public boolean getHasSIMCard () {
    return hasSIMCard;
  }

  public String getSize () {
    return size;
  }

  // setters
  public void setModel (String a) {
    model = a;
  }

  public void setHasSIMCard (boolean a) {
    hasSIMCard = a;
  }

  public void setSize (String a) {
    size = a;
  }

  // class functions
  public String toString () {
    return (
        super.toString() +
        "Model: " + model + "\n" +
        "Has SIM card: " + hasSIMCard + "\n" +
        "Size: " + size + "\n"
        );
  }
}
