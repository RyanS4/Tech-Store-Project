import java.util.*;

public class Cart {
  private static Catalogue catalogue = new Catalogue();

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

  //getters
  public Customer getUser () {
    return user;
  }

  public ArrayList<PC> getPCList () {
    return pcList;
  }

  public ArrayList<Laptop> getLaptopList () {
    return laptopList;
  }

  public ArrayList<Monitor> getMonitorList () {
    return monitorList;
  }

  public ArrayList<Phone> getPhoneList () {
    return phoneList;
  }

  public ArrayList<Tv> getTvList () {
    return tvList;
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
  public void addPC (int userSelection) {
    pcList.add(catalogue.getCataloguePCs().get(userSelection)); //adds a specific PC
    System.out.println("Added " + catalogue.getCataloguePCs().get(userSelection).getName() + " to cart."); // prints an 'added' notice
  }

  public void addLaptop (int userSelection) {
    laptopList.add(catalogue.getCatalogueLaptops().get(userSelection));
    System.out.println("Added " + catalogue.getCatalogueLaptops().get(userSelection).getName() + " to cart.");
  }

  public void addMonitor (int userSelection) {
    monitorList.add(catalogue.getCatalogeMonitors().get(userSelection));
    System.out.println("Added " + catalogue.getCatalogeMonitors().get(userSelection).getName() + " to cart.");
  }
  
  public void addPhone (int userSelection) {
    phoneList.add(catalogue.getCatalogPhones().get(userSelection));
    System.out.println("Added " + catalogue.getCatalogPhones().get(userSelection).getName() + " to cart.");
  }

  public void addTv (int userSelection) {
    tvList.add(catalogue.getCatalogeTvs().get(userSelection));
    System.out.println("Added " + catalogue.getCatalogeTvs().get(userSelection).getName() + " to cart.");
  }

  public void deleteItem (String itemName) {
    for (int i = 0; i < pcList.size(); i++) {
      if (pcList.get(i).equals(itemName)) {
        pcList.remove(i);
      }
    }

    for (int i = 0; i < laptopList.size(); i++) {
      if (laptopList.get(i).equals(itemName)) {
        laptopList.remove(i);
      }
    }

    for (int i = 0; i < monitorList.size(); i++) {
      if (monitorList.get(i).equals(itemName)) {
        monitorList.remove(i);
      }
    }

    for (int i = 0; i < phoneList.size(); i++) {
      if (phoneList.get(i).equals(itemName)) {
        phoneList.remove(i);
      }
    }

    for (int i = 0; i < tvList.size(); i++) {
      if (tvList.get(i).equals(itemName)) {
        tvList.remove(i);
      }
    }
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
}
