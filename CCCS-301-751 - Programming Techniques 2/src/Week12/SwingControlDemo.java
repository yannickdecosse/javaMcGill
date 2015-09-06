package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		GUI
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SwingControlDemo 
{
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo()
   {
      prepareGUI();
   }

   public static void main(String[] args)
   {
      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
      swingControlDemo.showDialogDemo();
   }

   private void prepareGUI()
   {
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() 
      {
         public void windowClosing(WindowEvent windowEvent)
         {
            System.exit(0);
         }        
      }); 
      
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showDialogDemo()
   {                                       
      headerLabel.setText("Control in action: JOptionPane"); 

      JButton okButton = new JButton("OK");        
      JButton javaButton = new JButton("Yes/No");
      JButton cancelButton = new JButton("Yes/No/Cancel");

      okButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {
            JOptionPane.showMessageDialog(mainFrame, "Welcome to TutorialsPoint.com");
         }          
      });

      javaButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {
            int output = JOptionPane.showConfirmDialog(mainFrame, "Click any button","TutorialsPoint.com", JOptionPane.YES_NO_OPTION);

            if(output == JOptionPane.YES_OPTION)
            {
               statusLabel.setText("Yes selected.");
            }
            
            else if(output == JOptionPane.NO_OPTION)
            {
               statusLabel.setText("No selected.");
            }
         }
      });

      cancelButton.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {                
            int output = JOptionPane.showConfirmDialog(mainFrame, "Click any button", "TutorialsPoint.com", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if(output == JOptionPane.YES_OPTION)
            {
               statusLabel.setText("Yes selected.");
            }
            
            else if(output == JOptionPane.NO_OPTION)
            {
               statusLabel.setText("No selected.");
            }
            
            else if(output == JOptionPane.CANCEL_OPTION)
            {
               statusLabel.setText("Cancel selected.");
            }
         }
      });

      controlPanel.add(okButton);
      controlPanel.add(javaButton);
      controlPanel.add(cancelButton);       
      mainFrame.setVisible(true);  
   }
}