import java.util.*;

public class Main {
    public static void main(String[] args) {

    DatabaseManager.initializeDatabase(); 

ArrayList<Cart> preloadedCarts = new ArrayList<>(DatabaseManager.loadCartData()); // Loads previous users from database
    Menu menu = new Menu(preloadedCarts);

        Scanner scan = new Scanner(System.in);
        Catalogue catalogue = new Catalogue();

        while (true) {  // Primary loop for displaying main menu
            menu.displayMenu(); // Shows menu text
            System.out.print("Enter: "); 
            int userInput1 = scan.nextInt(); // Takes user choice for menu option
            System.out.println("----------");

            if (userInput1 == 1) { 
                menu.viewCurrentUsers(); // Prints list of current users

            } else if (userInput1 == 2) {
                menu.viewSpecificUser(); // Prints specific info from a specific user

            } else if (userInput1 == 3) {
                boolean passAuth = false;
                String tempName = "";
                String tempPass = "";

                do {    // Asks user to enter a username and password until a match is found in the list of users
                System.out.print("Enter Username: ");
                scan.nextLine(); // Fix to consume newline
                tempName = scan.nextLine();

                if (tempName.equals("exit")) {  // Returns to main menu if "exit" is entered for username
                    break;
                }
                
                System.out.print("Enter Password: ");
                tempPass = scan.nextLine();
                
                if (menu.getUser(tempName).getUser().getPassword().equals(tempPass)) {  // Checks to see if the username and password belong to the same user
                    passAuth = true;
                }

                } while (!passAuth);

                while (true) {
                    menu.displayEditMenu(menu.getUser(tempName));
                    System.out.print("Enter: ");
                    int userInput2 = scan.nextInt();

                    if (userInput2 == 1) {
                        menu.viewCatalogue();

                    } else if (userInput2 == 2) {
                        menu.getUser(tempName).printCart();

                    } else if (userInput2 == 3) {
                        // Add item
                        menu.displayBuyMenu();
                        System.out.print("Enter Item Number: ");
                        int userInput3 = scan.nextInt();

                        int totalIndex = 1;

                        int sizePCs = catalogue.getCataloguePCs().size();
                        int sizeLaptops = catalogue.getCatalogueLaptops().size();
                        int sizeMonitors = catalogue.getCatalogeMonitors().size();
                        int sizePhones = catalogue.getCatalogPhones().size();
                        int sizeTvs = catalogue.getCatalogeTvs().size();

                        if (userInput3 >= totalIndex && userInput3 < totalIndex + sizePCs) {
                            menu.getUser(tempName).addPC(userInput3 - totalIndex);
                        } else if (userInput3 >= totalIndex + sizePCs && userInput3 < totalIndex + sizePCs + sizeLaptops) {
                            menu.getUser(tempName).addLaptop(userInput3 - totalIndex - sizePCs);
                        } else if (userInput3 >= totalIndex + sizePCs + sizeLaptops &&
                                   userInput3 < totalIndex + sizePCs + sizeLaptops + sizeMonitors) {
                            menu.getUser(tempName).addMonitor(userInput3 - totalIndex - sizePCs - sizeLaptops);
                        } else if (userInput3 >= totalIndex + sizePCs + sizeLaptops + sizeMonitors &&
                                   userInput3 < totalIndex + sizePCs + sizeLaptops + sizeMonitors + sizePhones) {
                            menu.getUser(tempName).addPhone(userInput3 - totalIndex - sizePCs - sizeLaptops - sizeMonitors);
                        } else if (userInput3 >= totalIndex + sizePCs + sizeLaptops + sizeMonitors + sizePhones &&
                                   userInput3 < totalIndex + sizePCs + sizeLaptops + sizeMonitors + sizePhones + sizeTvs) {
                            menu.getUser(tempName).addTv(userInput3 - totalIndex - sizePCs - sizeLaptops - sizeMonitors - sizePhones);
                        } else {
                            System.out.println("Error: Invalid Item");
                        }

                    } else if (userInput2 == 4) {
                        scan.nextLine(); // Consume leftover newline
                        System.out.print("Enter Name of Item to Delete: ");
                        String userInput4 = scan.nextLine();
                        menu.getUser(tempName).deleteItem(userInput4);

                    } else if (userInput2 == 5) {
                        menu.clearCart(tempName);

                    } else {
                        menu.getUser(tempName).checkout();
                        System.out.println("Exiting User...");
                        break;
                    }
                }

            } else if (userInput1 == 4) {
                menu.createUser();

            } else if (userInput1 == 5) {
                menu.deleteUser();
            } else {
                
                for (Cart user : menu.getUserCarts()) {
                  DatabaseManager.saveCartData(user);
                }
                System.out.println("Thank you for visiting!");
                break;
            }
        }

      scan.close();
    }
}
