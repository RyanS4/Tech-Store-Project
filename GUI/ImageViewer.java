import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageViewer {
  private JFrame frame;

  public ImageViewer() {
    makeFrame();
  }

  private void makeFrame() {
    frame = new JFrame("Tech Store");
    Container contentPane = frame.getContentPane();

    JLabel label = new JLabel("I am a label. I can display some text.");
    contentPane.add(label);

    JButton button = new JButton("I am a button");
    contentPane.add(button);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    ImageViewer test = new ImageViewer();

    test.makeFrame();
  }
}
