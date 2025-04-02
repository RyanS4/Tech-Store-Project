import java.util.*;

public class Cart {
  private Customer user;
  private ArrayList <PC> pcList;
  private ArrayList <Laptop> laptopList;
  private ArrayList <Monitor> monitorList;
  private ArrayList <Phone> phoneList;
  private ArrayList <Tv> tvList;

  public Cart (String name, double startMoney) {
    this.user = new Customer (name, startMoney);
    this.pcList = new ArrayList<>();
    this.laptopList = new ArrayList<>();
    this.monitorList = new ArrayList<>();
    this.phoneList = new ArrayList<>();
    this.tvList = new ArrayList<>();
  }

  public String getCartName () {
    return user.getCustomerName();
  }

  public String prevToString () {
    return (
        "Customer Name: " + user.getCustomerName() + "\n" +
        "Budget: " + user.getMoney() + "\n"
        );
  }
  
  // add item to cart functions
  public void addPC (String name, double price, int stock, int ram, String CPU, String GPU, double storage, String towerType, boolean waterCooling, int fans){
    PC pc = new PC(name, price, stock, ram, CPU, GPU, storage, towerType, waterCooling, fans); //creates a pc object
    pcList.add(pc); // adds pc object to checkout list for pcs
    System.out.println("Added " + pc.getName() + " to cart."); // prints an 'added' notice
  }

  public void addLaptop (String name, double price, int stock, int ram, String CPU, String GPU, double storage) {
    Laptop laptop = new Laptop(name, price, stock, ram, CPU, GPU, storage);
    laptopList.add(laptop);
    System.out.println("Added " + laptop.getName() + " to cart.");
  }

  public void addMonitor (String name, double price, int stock, String size, String resolution, int Hz) {
    Monitor monitor = new Monitor (name, price, stock, size, resolution, Hz);
    monitorList.add(monitor);
    System.out.println("Added " + monitor.getName() + " to cart.");
  }

  public void addPhone (String name, double price, int stock, String model, boolean hasSIMCard, String size) {
    Phone phone = new Phone (name, price, stock, model, hasSIMCard, size);
    phoneList.add(phone);
    System.out.println("Added " + phone.getName() + " to cart.");
  }

  public void addTv (String name, double price, int stock, String size, String resolution, int Hz) {
    Tv tv = new Tv (name, price, stock, size, resolution, Hz);
    tvList.add(tv);
    System.out.println("Added " + tv.getName() + " to cart.");
  }

  //clear cart
  public void empty() {
    pcList.clear();
    laptopList.clear();
    monitorList.clear();
    phoneList.clear();
    tvList.clear();
    System.out.println("Cart Cleared!");
  }

  //toString for printing cart at the time called
  public String toString () {
    String tempPc = "";
    for (PC pc : pcList) {
      tempPc += pc.toString();
    }

    String tempLaptop = "";
    for (Laptop laptop : laptopList) {
      tempLaptop += laptop.toString();
    }

    String tempMonitor = "";
    for (Monitor monitor : monitorList) {
      tempMonitor += monitor.toString();
    }

    String tempPhone = "";
    for (Phone phone : phoneList) {
      tempPhone += phone.toString();
    }

    String tempTv = "";
    for (Tv tv : tvList) {
      tempTv += tv.toString();
    }

    return (
        "User: " + user.getCustomerName() + "\n" +
        "Account Budget: " + user.getMoney() + "\n" +
        "----------\n" +
        tempPc + "\n" +
        tempLaptop + "\n" +
        tempMonitor + "\n" +
        tempPhone + "\n" +
        tempTv + "\n"

        );
  }

  public void printCart() {
    System.out.println(toString());
  }

  public void checkout () {
    double total = 0;
    for (PC pc : pcList) {
      total += pc.getPrice();
    }
    for (Monitor monitor : monitorList) {
      total += monitor.getPrice();
    }
    for (Phone phone : phoneList) {
      total += phone.getPrice();
    }
    for (Tv tv : tvList) {
      total += tv.getPrice();
    }
    for (Laptop laptop : laptopList) {
      total += laptop.getPrice();
    }

    if (total > user.getMoney()) {
      System.out.println("Sorry! total > user budget");
      return;
    }

    System.out.println("Items sold!");
    user.setMoney(user.getMoney() - total);
    printCart();
    empty();
  }

  public void exit() {
    System.out.println(toString());
    System.out.println("Exiting user");
  }
}
