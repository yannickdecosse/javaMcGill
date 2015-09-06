package Week0;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
 
/** Test setting Swing's JComponents properties and appearances */
@SuppressWarnings("serial")
public class test extends JFrame {
 
   // Image path relative to the project root (i.e., bin)
   private String imgCrossFilename = "images/cross.gif";
   private String imgNoughtFilename = "images/nought.gif";
 
   /** Constructor to setup the GUI */
   public test() {
 
      // Prepare ImageIcons to be used with JComponents
      ImageIcon iconCross = null;
      ImageIcon iconNought = null;
      URL imgURL = getClass().getClassLoader().getResource(imgCrossFilename);
      if (imgURL != null) {
         iconCross = new ImageIcon(imgURL);
      } else {
         System.err.println("Couldn't find file: " + imgCrossFilename);
      }
      imgURL = getClass().getClassLoader().getResource(imgNoughtFilename);
      if (imgURL != null) {
         iconNought = new ImageIcon(imgURL);
      } else {
         System.err.println("Couldn't find file: " + imgNoughtFilename);
      }
 
      Container cp = getContentPane();
      cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
 
      // Create a JLabel with text and icon and set its appearances
      JLabel label = new JLabel("JLabel", iconCross, SwingConstants.CENTER);
      label.setFont(new Font(Font.DIALOG, Font.ITALIC, 14));
      label.setOpaque(true);  // needed for JLabel to show the background color
      label.setBackground(new Color(204, 238, 241));  // light blue
      label.setForeground(Color.RED);                 // foreground text color
      label.setPreferredSize(new Dimension(120, 80));
      label.setToolTipText("This is a JLabel");  // Tool tip
      cp.add(label);
 
      // Create a JButton with text and icon and set its appearances
      JButton button = new JButton(); // use setter to set text and icon
      button.setText("Button");
      button.setIcon(iconNought);
      button.setVerticalAlignment(SwingConstants.BOTTOM);  // of text and icon
      button.setHorizontalAlignment(SwingConstants.RIGHT); // of text and icon
      button.setHorizontalTextPosition(SwingConstants.LEFT); // of text relative to icon
      button.setVerticalTextPosition(SwingConstants.TOP);    // of text relative to icon
      button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      button.setBackground(new Color(231, 240, 248));
      button.setForeground(Color.BLUE);
      button.setPreferredSize(new Dimension(150, 80));
      button.setToolTipText("This is a JButton");
      button.setMnemonic(KeyEvent.VK_B);  // can activate via Alt-B (buttons only)
      cp.add(button);
 
      // Create a JTextField with text and icon and set its appearances
      JTextField textField = new JTextField("Text Field", 15);
      textField.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
      textField.setForeground(Color.RED);
      textField.setHorizontalAlignment(JTextField.RIGHT);  // Text alignment
      textField.setToolTipText("This is a JTextField");
      cp.add(textField);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("JComponent Test");
      setLocationRelativeTo(null); // center window on the screen
      setSize(500, 150);  // or pack()
      setVisible(true);
 
      // Print description of the JComponents via toString()
      System.out.println(label);
      System.out.println(button);
      System.out.println(textField);
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run the GUI codes on Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new test(); // Let the constructor do the job
         }
      });
   }
}