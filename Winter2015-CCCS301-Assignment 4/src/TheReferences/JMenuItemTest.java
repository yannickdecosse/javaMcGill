package TheReferences;

/* JMenuItemTest.java
 * Copyright (c) 2014, HerongYang.com, All Rights Reserved.
 */
import javax.swing.*;
public class JMenuItemTest {
   JFrame myFrame = null;
   public static void main(String[] a) {
      (new JMenuItemTest()).test();
   }
   private void test() {
      myFrame = new JFrame("Menu Item Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setBounds(50,50,250,150);
      myFrame.setContentPane(new JDesktopPane());

      JMenuBar myMenuBar = new JMenuBar();
      JMenu myMenu = getFileMenu();
      myMenuBar.add(myMenu);
      JMenuItem myItem = new JMenuItem("Help");
      myMenuBar.add(myItem);
      myMenu = getColorMenu();
      myMenuBar.add(myMenu);
      myMenu = getOptionMenu();
      myMenuBar.add(myMenu);
      

      myFrame.setJMenuBar(myMenuBar);
      myFrame.setVisible(true);
   }
   private JMenu getFileMenu() {
      JMenu myMenu = new JMenu("File");
      JMenuItem myItem = new JMenuItem("Open");
      myMenu.add(myItem);
      myItem = new JMenuItem("Close");
      myItem.setEnabled(false);
      myMenu.add(myItem);
      myMenu.addSeparator();
      myItem = new JMenuItem("Exit");
      myMenu.add(myItem);
      return myMenu;
   }
   private JMenu getColorMenu() {
      JMenu myMenu = new JMenu("Color");
      JMenuItem myItem = new JMenuItem("Red");
      myMenu.add(myItem);
      myItem = new JMenuItem("Green");
      myMenu.add(myItem);
      myItem = new JMenuItem("Blue");
      myMenu.add(myItem);
      return myMenu;
   }
   private JMenu getOptionMenu() {
      JMenu myMenu = new JMenu("Option");
      JMenu mySubMenu = getOnOffMenu("Sound");
      myMenu.add(mySubMenu);
      mySubMenu = getOnOffMenu("Auto save");
      mySubMenu.setEnabled(false);
      myMenu.add(mySubMenu);
      return myMenu;
   }
   private JMenu getOnOffMenu(String title) {
      JMenu myMenu = new JMenu(title);
      JMenuItem myItem = new JMenuItem("On");
      myMenu.add(myItem);
      myItem = new JMenuItem("Off");
      myMenu.add(myItem);
      return myMenu;
   }
}