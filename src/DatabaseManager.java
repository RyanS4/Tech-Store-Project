import java.sql.*;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:tech_store.db";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Create users table
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
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

            PreparedStatement insertUser = conn.prepareStatement("INSERT INTO users (username, budget) VALUES (?, ?)");
            insertUser.setString(1, cart.getCartName());
            insertUser.setDouble(2, cart.getUser().getMoney());  // If private, expose with a getter
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
}
