import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageViewer {
  private JFrame frame;

  public ImageViewer() {
    makeFrame();
  }

  private void makeFrame() {
    frame = new JFrame("ImageViewer");
    Container contentPane = frame.getContentPane();

    JLabel label = new JLabel("I am a label. I can display some text.");
    contentPane.add(label);

    frame.pack();
    frame.setVisable(true);
  }

  public static void main(String[] args) {
    ImageViewer test = new ImageViewer();
    test.makeFrame();
  }
}
