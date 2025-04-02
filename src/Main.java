import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Catalogue catalogue = new Catalogue();

    Menu menu = new Menu ();

    while(true) {
      menu.displayMenu();
      System.out.print("Enter: ");
      int userInput1 = scan.nextInt();

      if (userInput1 == 1) {

        menu.viewCurrentUsers();

      } else if (userInput1 == 2) {

        menu.viewSpecificUser();

      } else if (userInput1 == 3) {

        System.out.print("Enter Username: ");
        scan.nextLine();
        String tempName = scan.nextLine();

        while(true) {
          menu.displayEditMenu(menu.getUser(tempName));
          System.out.print("Enter: ");
          int userInput2 = scan.nextInt();

          if (userInput2 == 1) {
            menu.viewCatalogue();

          } else if (userInput2 == 2) {
            //add item
            menu.displayBuyMenu();
            System.out.print("Enter Item Number: ");
            int userInput3 = scan.nextInt();

            if (userInput3 > 0 && userInput3 <= catalogue.getCataloguePCs().size()) {
              menu.getUser(tempName).addPC(userInput3);
            } else if (userInput3 > 0 && userInput3 <= catalogue.getCatalogueLaptops().size()) {
              menu.getUser(tempName).addLaptop(userInput3);
            } else if (userInput3 > 0 && userInput3 <= catalogue.getCatalogeMonitors().size()){
              menu.getUser(tempName).addLaptop(userInput3);
            } else if (userInput3 > 0 && userInput3 <= catalogue.getCatalogPhones().size()) {
              menu.getUser(tempName).addLaptop(userInput3);
            } else if (userInput3 > 0 && userInput3 <= catalogue.getCatalogeTvs().size()) {
              menu.getUser(tempName).addTv(userInput3);
            } else {
              System.out.println("Error: Invalid Item");
            }
            
          } else if (userInput2 == 3) {
            System.out.print("Enter Name of Item to Delete: ");
            String userInput4 = scan.nextLine();
            menu.getUser(tempName).deleteItem(userInput4);
          } else if (userInput2 == 4) {

            menu.clearCart(tempName);

          } else {

            System.out.println("Exiting User...");
            break;

          }
        }

      } else if (userInput1 == 4) {

        menu.createUser();

      } else if (userInput1 == 5) {

        menu.deleteUser();

      } else {

        menu.exit();
        break;

      }

    }

    scan.close();
  }
 }
