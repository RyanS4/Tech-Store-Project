import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Catalogue catalogue = new Catalogue();
        Menu menu = new Menu();

        while (true) {
            menu.displayMenu();
            System.out.print("Enter: ");
            int userInput1 = scan.nextInt();

            if (userInput1 == 1) {
                menu.viewCurrentUsers();

            } else if (userInput1 == 2) {
                menu.viewSpecificUser();

            } else if (userInput1 == 3) {
                System.out.print("Enter Username: ");
                scan.nextLine(); // Fix to consume newline
                String tempName = scan.nextLine();

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
                menu.exit();
                break;
            }
        }

      scan.close();
    }
}
