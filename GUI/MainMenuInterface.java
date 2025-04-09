import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainMenuInterface {

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

        mainPanel.add(menuPanel, "menu");
        mainPanel.add(userListPanel, "userList");

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

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(150, 230, 200, 30);
        exitBtn.setFont(buttonFont);
        exitBtn.setBackground(new Color(200, 50, 50));
        exitBtn.setForeground(Color.WHITE);
        panel.add(exitBtn);

        // Switch to user list panel
        viewUsersBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "userList");
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
        userList.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(new JScrollPane(userList), BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        bottomPanel.add(backBtn);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }
}
