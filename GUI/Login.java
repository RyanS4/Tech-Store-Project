import javax.swing.*;
import java.awt.*;

public class Login {

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Tech Store Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30)); // dark background
        frame.add(panel);

        placeComponents(panel);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Font styles
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        Font inputFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 60, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(labelFont);
        panel.add(userLabel);

        // Username Field
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 60, 180, 25);
        userText.setFont(inputFont);
        panel.add(userText);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(labelFont);
        panel.add(passwordLabel);

        // Password Field
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 100, 180, 25);
        passwordText.setFont(inputFont);
        panel.add(passwordText);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.setFont(buttonFont);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        // Example Action Listener (optional)
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = String.valueOf(passwordText.getPassword());
            System.out.println("Attempted login with: " + username + " / " + password);
            // Add validation logic or navigation here
        });
    }
}
