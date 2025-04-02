public class Monitor extends Item {
  private String size;
  private String resolution;
  private int Hz;

  public Monitor (String name, double price, int storage, String s, String r, int h) {
    super (name, price, storage);
    size = s;
    resolution = r;
    Hz = h;
  }

  // getters
  public String getSize () {
    return size;
  }

  public String resolution () {
    return resolution;
  }

  public int getHZ () {
    return Hz;
  }

  // setters
  public void setSize (String a) {
    size = a;
  }

  public void setResolution (String a) {
    resolution = a;
  }

  public void setHz (int a) {
    Hz = a;
  }

  // class functions
  public String toString () {
    return (
        super.toString() +
        "Size: " + size + "\n" +
        "Resolution: " + resolution + "\n" +
        "Refresh Rate: " + Hz + "Hz\n"
        );
  }
}
