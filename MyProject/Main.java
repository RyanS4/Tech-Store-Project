public class Main {
  public static void main(String[] args) {
    Cart test1 = new Cart("Ryan", 10000);
    test1.addPC("My PC", 2000.0, 15, 32, "AMD", "NVIDA", 3000, "Tower", true, 6);
    test1.addMonitor("My Monitor", 300, 23, "30 x 30", "1440 x 1950", 164);
    test1.addPC("My PC 2", 5000.0, 15, 64, "AMD", "NVIDA", 3000, "Tower", true, 6);

    test1.printCart();
    
    test1.checkout();
    test1.exit();
    
  }
}
