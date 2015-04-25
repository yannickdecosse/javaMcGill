package TheReferences;

/* MenuItemActionListenerTest.java
 * Copyright (c) 2014, HerongYang.com, All Rights Reserved.
 */
import java.awt.event.*;
import javax.swing.*;
public class MenuItemActionListener {
   JFrame myFrame = null;
   public static void main(String[] a) {
      (new MenuItemActionListener()).test();
   }
   private void test() {
      myFrame = new JFrame("Menu Listener Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setBounds(50,50,250,150);
      myFrame.setContentPane(new JDesktopPane());

      JMenuBar myMenuBar = new JMenuBar();
      JMenu myMenu = getFileMenu();
      myMenuBar.add(myMenu);
      myMenu = getColorMenu();
      myMenuBar.add(myMenu);
      myMenu = getOptionMenu();
      myMenuBar.add(myMenu);

      MyMenuItem myItem = new MyMenuItem("Help");
      myMenuBar.add(myItem);

      myFrame.setJMenuBar(myMenuBar);
      myFrame.setVisible(true);
   }
   private JMenu getFileMenu() {
      JMenu myMenu = new JMenu("File");
      MyMenuItem myItem = new MyMenuItem("Open");
      myMenu.add(myItem);
      myItem = new MyMenuItem("Close");
      myMenu.add(myItem);
      myMenu.addSeparator();
      myItem = new MyMenuItem("Exit");
      myMenu.add(myItem);
      return myMenu;
   }
   private JMenu getColorMenu() {
      JMenu myMenu = new JMenu("Color");
      JMenuItem myItem = new MyMenuItem("Red");
      myMenu.add(myItem);
      myItem = new MyMenuItem("Green");
      myMenu.add(myItem);
      myItem = new MyMenuItem("Blue");
      myMenu.add(myItem);
      return myMenu;
   }
   private JMenu getOptionMenu() {
      JMenu myMenu = new JMenu("Option");
      JMenuItem myItem = new MyMenuItem("Sound");
      myMenu.add(myItem);
      myItem = new MyMenuItem("Auto save");
      myMenu.add(myItem);
      return myMenu;
   }
   private class MyMenuItem extends JMenuItem 
      implements ActionListener {
      public MyMenuItem(String text) {
         super(text);
         addActionListener(this);
      }
      public void actionPerformed(ActionEvent e) {
         System.out.println("Item clicked: "+e.getActionCommand());
      }
   }
}