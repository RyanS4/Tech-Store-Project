import java.util.*;

public class Menu {
  Scanner scan = new Scanner(System.in);

  private ArrayList<Cart> userCarts;

  public Menu () {
    userCarts = new ArrayList<>();
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

  public void displayEditMenu () {
    //add later
  }

  public void viewCurrentUsers () {
    for (Cart cart : userCarts) {
      System.out.println(cart.prevToString());
    }
  } 

  public void viewSpecificUser () {
    System.out.print("Enter Username: ");
    tempName = scan.nextLine();

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
    
    Cart cart = new Cart(tempName, tempMoney);

    userCarts.add(cart);
  }

  public void deleteUser () {
    System.out.print("Enter User to Delete: ");
    String tempName = scan.nextLine();

    for (int i = 0; i < userCarts.size() - 1; i++) {
      if ((userCarts[i].getCartName()).equals(tempName)) {
        userCarts.remove(i);
      }
    }
  }

  public void exit () {
    userCarts.clear();
    System.out.println("Exiting...");
  }
}
