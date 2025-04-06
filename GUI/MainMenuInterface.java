import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuInterface implements ActionListener {

    // JFrame instance variable
    private JFrame frame;

    // Implement the actionPerformed method to handle menu item actions
    public void actionPerformed(ActionEvent event) {
        System.out.println("Menu item: " + event.getActionCommand());
    }

    private void makeFrame() {
        frame = new JFrame("Tech Store Menu");
        makeMenuBar(frame);

        JPanel panel = new JPanel(new GridLayout(3, 2, 30, 30)); // 4 rows, 1 column
       JLabel loginTextUsername = new JLabel("Username");
       JLabel loginTextPassword = new JLabel("Password");
       JTextField loginUsername = new JTextField();
        loginUsername.setPreferredSize(new Dimension(250, 30));
       JPasswordField loginPassword = new JPasswordField();
       loginPassword.setPreferredSize(new Dimension(250,30));
       JButton enterLogin = new JButton("Enter");

      panel.add(loginTextUsername);
      panel.add(loginUsername);
      panel.add(loginTextPassword);
      panel.add(loginPassword);
      panel.add(enterLogin);

      frame.add(panel);

        // Setting up the frame size and close operation
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void makeMenuBar(JFrame frame) {
        // Create a JMenuBar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add "Open" and "Quit" menu items
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);  // Add action listener to handle click
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);  // Add action listener to handle click
        fileMenu.add(quitItem);
    }

    public static void main(String[] args) {
        // Create an instance of MainMenuInterface
        MainMenuInterface mainMenu = new MainMenuInterface();

        // Create the JFrame
        mainMenu.makeFrame();

        // Making the JFrame visible
        mainMenu.frame.setVisible(true);
    }
}
