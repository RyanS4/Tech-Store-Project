public class PC extends Computer {
  private String towerType;
  private boolean waterCooling;
  private int fans;

  public PC (String name, double price, int stock, int ram, String CPU, String GPU, double storage, String t, boolean w, int f) {
    super(name, price, stock, ram, CPU, GPU, storage);
    towerType = t;
    waterCooling = w;
    fans = f;
  }

  // getters
  public String getTowerType () {
    return towerType;
  }

  public boolean getWaterCooling () {
    return waterCooling;
  }

  public int getFans () {
    return fans;
  }

  // setters
  public void setTowerType (String a) {
    towerType = a;
  }

  public void setWaterCooling (boolean a) {
    waterCooling = a;
  }

  public void setFans (int a) {
    fans = a;
  }

  // class functions
  public String toString () {
    return (
        super.toString() +
        "Tower Type: " + towerType + "\n" +
        "Number of fans: " + fans + "\n" +
        "Has Water Cooling: " + waterCooling + "\n"
        );
  }

}
