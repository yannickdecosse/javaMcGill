package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		GUI
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame
{
	private static final long serialVersionUID = -3620401281669265665L;
	//	text field with set size
	private JTextField textField1;
	//	text field with text
	private JTextField textField2;
	//	text field with text and size
	private JTextField textField3;
	private JPasswordField passwordField;
	
	//	constructor adds JTextFileds to JFrame
	public TextFieldFrame()
	{
		super("Testing JTextField & JPasswordField");
		setLayout(new FlowLayout());
		
		//	construct text field of 10 cols
		textField1 = new JTextField(10);
		//	add text field to JFrame
		add(textField1);
		
		//	construct text field with default text
		textField2 = new JTextField("Enter text here: ");
		//	add text field to JFrame
		add(textField2);
		
		//	construct text field with default text and 21 cols
		textField3 = new JTextField("TEXT", 21);
		//	disable editing
		textField3.setEditable(false);
		//	add text field to JFrame
		add(textField3);	
		
		//	construct password with default text
		passwordField = new JPasswordField("Hidden text");
		//	add text field to JFrame
		add(passwordField);	
		
		//	-------------------------------------------------------------------------------------------
		//	register event handlers
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	public class TextFieldHandler implements ActionListener
	{
		//	process text field events
		public void actionPerformed(ActionEvent event)
		{
			String string = "";
			
			//	textfield1
			if (event.getSource() == textField1)
			{
				string = String.format("textField1: %s", event.getActionCommand());
			}
			
			//	textfield2
			else if (event.getSource() == textField2)
			{
				string = String.format("textField2: %s", event.getActionCommand());
			}
			
			//	textfield3
			else if (event.getSource() == textField3)
			{
				string = String.format("textField3: %s", event.getActionCommand());
			}	
			
			//	passwordField
			else if (event.getSource() == passwordField)
			{
				string = String.format("passwordField: %s", new String(passwordField.getPassword()));
			}
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
	
	public static void main(String[] args) 
	{
		TextFieldFrame textFieldFrame = new TextFieldFrame();
		textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textFieldFrame.setSize(350, 100);
		textFieldFrame.setVisible(true);
		textFieldFrame.setLocationRelativeTo(null);

	}
}
