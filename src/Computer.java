public class Computer extends Item {
  private int ram;
  private String CPU;
  private String GPU;
  private double storage;
  
  public Computer (String name, double price, int stock, int r, String c, String g, double s) {
    super(name, price, stock);
    ram = r;
    CPU = c;
    GPU = g;
    storage = s;
  }

  // getters
  public int getRam () {
    return ram;
  }

  public String getCPU () {
    return CPU;
  }

  public String getGPU () {
    return GPU;
  }

  public double getStorage () {
    return storage;
  }

  // setters
  public void setRam (int a) {
    ram = a;
  }

  public void setCPU (String a) {
    CPU = a;
  }

  public void setGPU (String a) {
    GPU = a;
  }

  public void setStorage (double a) {
    storage = a;
  }

  // class functions
  public String toString () {
    return (
        super.toString() +
        "GPU: " + GPU + "\n" +
        "CPU: " + CPU + "\n" +
        "RAM: " + ram + "\n" +
        "Storage: " + storage + "GB\n" 
        );
  }
}
