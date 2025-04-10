import java.sql.*;
import java.util.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:data/tech_store.db";

    // Connect to the SQLite database
    public Connection connect() {
        String url = DB_URL; // Use the same URL as your database

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Create users table
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "budget REAL NOT NULL)"
            );

            // Create cart_items table
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS cart_items (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +  // Not using foreign key for simplicity
                "item_name TEXT NOT NULL," +
                "price REAL NOT NULL)"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveCartData(Cart cart) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);

            // Save or update user
            PreparedStatement deleteUser = conn.prepareStatement("DELETE FROM users WHERE username = ?");
            deleteUser.setString(1, cart.getCartName());
            deleteUser.executeUpdate();
            
            PreparedStatement insertUser = conn.prepareStatement("INSERT INTO users (username, password, budget) VALUES (?, ?, ?)");
            insertUser.setString(1, cart.getCartName());
            insertUser.setString(2, cart.getUser().getPassword());
            insertUser.setDouble(3, cart.getUser().getMoney());
            insertUser.executeUpdate();

            // Delete old cart items
            PreparedStatement deleteItems = conn.prepareStatement("DELETE FROM cart_items WHERE username = ?");
            deleteItems.setString(1, cart.getCartName());
            deleteItems.executeUpdate();

            // Insert current cart items
            PreparedStatement insertItem = conn.prepareStatement("INSERT INTO cart_items (username, item_name, price) VALUES (?, ?, ?)");

            addItems(insertItem, cart.getCartName(), cart.getPCList());
            addItems(insertItem, cart.getCartName(), cart.getLaptopList());
            addItems(insertItem, cart.getCartName(), cart.getMonitorList());
            addItems(insertItem, cart.getCartName(), cart.getPhoneList());
            addItems(insertItem, cart.getCartName(), cart.getTvList());

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Item> void addItems(PreparedStatement stmt, String username, List<T> items) throws SQLException {
        for (T item : items) {
            stmt.setString(1, username);
            stmt.setString(2, item.getName());
            stmt.setDouble(3, item.getPrice());
            stmt.addBatch();
        }
        stmt.executeBatch();
    }

    public static ArrayList<Cart> loadCartData() {
        ArrayList<Cart> carts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Load users
            PreparedStatement getUsers = conn.prepareStatement("SELECT username, password, budget FROM users");
            ResultSet userResults = getUsers.executeQuery();

            while (userResults.next()) {
                String username = userResults.getString("username");
                String password = userResults.getString("password");
                double budget = userResults.getDouble("budget");
                Cart cart = new Cart(username, password, budget);

                // Load items for this user
                PreparedStatement getItems = conn.prepareStatement("SELECT item_name, price FROM cart_items WHERE username = ?");
                getItems.setString(1, username);
                ResultSet itemResults = getItems.executeQuery();

                while (itemResults.next()) {
                    String name = itemResults.getString("item_name");
                    double price = itemResults.getDouble("price");

                    // Reconstruct item and determine type
                    Item item = Catalogue.matchItem(name, price);
                    if (item instanceof PC) cart.getPCList().add((PC)item);
                    else if (item instanceof Laptop) cart.getLaptopList().add((Laptop)item);
                    else if (item instanceof Monitor) cart.getMonitorList().add((Monitor)item);
                    else if (item instanceof Phone) cart.getPhoneList().add((Phone)item);
                    else if (item instanceof Tv) cart.getTvList().add((Tv)item);
                }

                carts.add(cart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carts;
    }

    // Method to delete user
    public void deleteUserFromDatabase(String username) {
        String sql = "DELETE FROM users WHERE username = ?"; // Use lowercase 'users'

        try (Connection conn = connect(); // Use the connect method
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with the username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}
