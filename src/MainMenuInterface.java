import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainMenuInterface {

    private static final Font menuFont = new Font("Arial", Font.BOLD, 18);

    static CardLayout cardLayout;
    static JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tech Store Menu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Panels for different screens
        JPanel menuPanel = createMainMenuPanel();
        JPanel userListPanel = createUserListPanel();
        JPanel specificUserPanel = createSpecificUserPanel();
        //JPanel loginPanel = createLoginPanel();
        //JPanel makeUserPanel = createMakeUserPanel();
        //JPanel deleteUserPanel = createDeleteUserPanel();

        mainPanel.add(menuPanel, "menu");
        mainPanel.add(userListPanel, "userList");
        mainPanel.add(specificUserPanel, "specificUser");
        //mainPanel.add(loginPanel, "login");
        //mainPanel.add(makeUserPanel, "makeUser");
        //mainPanel.add(deleteUserPanel, "deleteUser");

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createMainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));

        Font titleFont = new Font("Arial", Font.BOLD, 18);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        JLabel title = new JLabel("Welcome to Tech Store!");
        title.setBounds(130, 20, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(titleFont);
        panel.add(title);

        JButton viewUsersBtn = new JButton("View All Users");
        viewUsersBtn.setBounds(150, 70, 200, 30);
        viewUsersBtn.setFont(buttonFont);
        panel.add(viewUsersBtn);

        JButton viewSpecificUserBtn = new JButton("View Specific User");
        viewSpecificUserBtn.setBounds(150, 110, 200, 30);
        viewSpecificUserBtn.setFont(buttonFont);
        panel.add(viewSpecificUserBtn);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150,150,200,30);
        loginBtn.setFont(buttonFont);
        panel.add(loginBtn);

        JButton createNewUserBtn = new JButton("Create New User");
        createNewUserBtn.setBounds(150,190,200,30);
        createNewUserBtn.setFont(buttonFont);
        panel.add(createNewUserBtn);
        
        JButton deleteUserBtn = new JButton("Delete User");
        deleteUserBtn.setBounds(150,230,200,30);
        deleteUserBtn.setFont(buttonFont);
        panel.add(deleteUserBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(150, 290, 200, 30);
        exitBtn.setFont(buttonFont);
        exitBtn.setBackground(new Color(200, 50, 50));
        exitBtn.setForeground(Color.WHITE);
        panel.add(exitBtn);

        // Switch to user list panel
        viewUsersBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "userList");
        });

        viewSpecificUserBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "specificUser");
        });

        exitBtn.addActionListener(e -> System.exit(0));

        return panel;
    }

    private static JPanel createUserListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("All Users", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);

        // Simulated user data (replace this with actual loaded data)
        ArrayList<String> users = new ArrayList<>();
        

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String user : users) {
            listModel.addElement(user);
        }

        JList<String> userList = new JList<>(listModel);
        userList.setFont(menuFont);
        panel.add(new JScrollPane(userList), BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.setFont(menuFont);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static JPanel createSpecificUserPanel() {
        // title panel (at top)
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("View User", SwingConstants.CENTER);
        title.setFont(menuFont);
        panel.add(title, BorderLayout.NORTH);

        // body panel (middle)
        ArrayList<Cart> userList = DatabaseManager.loadCartData();
        DefaultListModel<String> model = new DefaultListModel<>();

        for (Cart cart : userList) {
            model.addElement(cart.getCartName() + " | $" + cart.getUser().getMoney());
        }
    
        JList<String> list = new JList<>(model);
        list.setFont(new Font("Arial", Font.PLAIN, 14));
        list.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(list);
    
        panel.add(scrollPane, BorderLayout.CENTER);

        //  exit panel (bottom)
        JButton backBtn = new JButton("Back");
        backBtn.setFont(menuFont);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }
}
