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
        JPanel loginPanel = createLoginPanel();
        JPanel makeUserPanel = createMakeUserPanel();
        JPanel deleteUserPanel = createDeleteUserPanel();

        mainPanel.add(menuPanel, "menu");
        mainPanel.add(userListPanel, "userList");
        mainPanel.add(specificUserPanel, "specificUser");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(makeUserPanel, "makeUser");
        mainPanel.add(deleteUserPanel, "deleteUser");

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

        loginBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        createNewUserBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "makeUser");
        });

        deleteUserBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "deleteUser");
        });

        exitBtn.addActionListener(e -> System.exit(0));

        return panel;
    }

    public static JPanel createUserListPanel() {
        // title panel (at top)
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("View User", SwingConstants.CENTER);
        title.setFont(menuFont);
        title.setForeground(Color.WHITE);
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

    private static JPanel createSpecificUserPanel() {
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
    
    public static JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("User Login", SwingConstants.CENTER);
        title.setFont(menuFont);
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.DARK_GRAY);
    
        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField(15);
        formPanel.add(userLabel);
        formPanel.add(usernameField);
    
        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField(15);
        formPanel.add(passLabel);
        formPanel.add(passwordField);
    
        panel.add(formPanel, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.setFont(menuFont);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JButton loginUserBtn = new JButton("Login");
        loginUserBtn.setFont(menuFont);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn, BorderLayout.WEST);
        bottomPanel.add(loginUserBtn, BorderLayout.EAST);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static JPanel createMakeUserPanel () {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("Create New User", SwingConstants.CENTER);
        title.setFont(menuFont);
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);

        JPanel makeUserPanel = new JPanel();
        makeUserPanel.setLayout(new BorderLayout());
        makeUserPanel.setBackground(Color.DARK_GRAY);

        JButton backBtn = new JButton("Back");
        backBtn.setFont(menuFont);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static JPanel createDeleteUserPanel () {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("Delete User", SwingConstants.CENTER);
        title.setFont(menuFont);
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);
        
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
