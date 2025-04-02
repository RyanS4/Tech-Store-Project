import java.util.*;

public class Menu {
  Scanner scan = new Scanner(System.in);

  private ArrayList<Cart> userCarts;
  private static Catalogue catalogue = new Catalogue();

  public Menu () {
    userCarts = new ArrayList<>();
  }

  public ArrayList<Cart> getUserCarts () {
    return userCarts;
  }

  public void displayMenu () {
    System.out.println(
        "-----Tech Store-----\n" +
        "[1] View Current Users\n" +
        "[2] View Specific User\n" +
        "[3] Edit Specific User\n" +
        "[4] Create New User\n" +
        "[5] Remove User\n" +
        "[6] Exit\n"
        );
  }

  public void displayEditMenu (Cart cart) {
    System.out.println(
        "------Welcome " + cart.getCartName() + "!------\n" +
        "[1] View Catalogue\n" +
        "[2] Add Item to Cart\n" +
        "[3] Remove Item from Cart\n" +
        "[4] Empty Cart\n" +
        "[5] Checkout\n"
        );
  }

  public void displayBuyMenu () {
    int totalItems = 0;
    for (int i = 0; i < catalogue.getCataloguePCs().size(); i++) {
      System.out.print(
        "[" + i + "]" +
        catalogue.getCataloguePCs().get(i).getName() +
        ", $" +
        catalogue.getCataloguePCs().get(i).getPrice() +
        "\n"
      );
    }

    totalItems += catalogue.getCataloguePCs().size();

    for (int i = 0; i < catalogue.getCatalogueLaptops().size(); i++) {
      System.out.print(
        "[" + (i + totalItems) + "]" +
        catalogue.getCatalogueLaptops().get(i).getName() +
        ", $" +
        catalogue.getCatalogueLaptops().get(i).getPrice() +
        "\n"
      );
    }
    
      totalItems += catalogue.getCatalogueLaptops().size();

    for (int i = 0; i < catalogue.getCatalogeMonitors().size(); i++) {
      System.out.print(
        "[" + (i + totalItems) + "]" +
        catalogue.getCatalogeMonitors().get(i).getName() +
        ", $" +
        catalogue.getCatalogeMonitors().get(i).getPrice() +
        "\n"
      );
    }

    totalItems += catalogue.getCatalogeMonitors().size();

    for (int i = 0; i < catalogue.getCatalogPhones().size(); i++) {
      System.out.print(
        "[" + (i + totalItems) + "]" +
        catalogue.getCatalogPhones().get(i).getName() +
        ", $" +
        catalogue.getCatalogPhones().get(i).getPrice() +
        "\n"
      );
    }

    totalItems += catalogue.getCatalogPhones().size();

    for (int i = 0; i < catalogue.getCatalogeTvs().size(); i++) {
      System.out.print(
        "[" + (i + totalItems) + "]" +
        catalogue.getCatalogeTvs().get(i).getName() +
        ", $" +
        catalogue.getCatalogeTvs().get(i).getPrice() +
        "\n"
      );
    }
    
  }

  public void viewCurrentUsers () {
    for (Cart cart : userCarts) {
      System.out.println(cart.prevToString());
    }
  } 

  public void viewSpecificUser () {
    System.out.print("Enter Username: ");
    String tempName = scan.nextLine();

    for (Cart cart : userCarts) {
      if ((cart.getCartName()).equals(tempName)) {
        cart.printCart();
      } 
    }
  }

  public void createUser () {
    System.out.print("Username: ");
    String tempName = scan.nextLine();

    System.out.print("Budget: ");
    double tempMoney = scan.nextDouble();
    scan.nextLine();
    
    Cart cart = new Cart(tempName, tempMoney);

    userCarts.add(cart);
  }

  public void deleteUser () {
    System.out.print("Enter User to Delete: ");
    String tempName = scan.nextLine();

    for (int i = 0; i < userCarts.size() - 1; i++) {
      if ((userCarts.get(i).getCartName()).equals(tempName)) {
        userCarts.remove(i);
      }
    }
  }

  public void clearCart () {
    userCarts.clear();
  }

  public void clearCart(String name) {
    for (int i = 0; i < userCarts.size() -1; i++) {
      if (userCarts.get(i).equals(name)) {
        userCarts.get(i).empty();
      }
    }
  }

  public void exit () {
    userCarts.clear();
    System.out.println("Exiting...");
  }

  public void viewCatalogue () {
    catalogue.printCatalogue();
  }

  public Cart getUser (String name) {
    for (Cart cart : userCarts) {
      if ((cart.getCartName()).equals(name)) {
        return cart;
      } 
    }

    Cart DEFAULTUSER = new Cart("Error: No User Found", 0);
    return DEFAULTUSER;
  }
}                          
