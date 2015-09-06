package Week10;
// A program to demonstrate the use of JTextFields's
//Import Statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTextFieldDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Class Declarations
	JTextField jtfText1, jtfUneditableText;
	String disp = "";
	TextHandler handler = null;
	//Constructor
	public JTextFieldDemo() {
		super("TextField Test Demo");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		jtfText1 = new JTextField(10);
		jtfUneditableText = new JTextField("Uneditable text field", 20);
		jtfUneditableText.setEditable(false);
		container.add(jtfText1);
		container.add(jtfUneditableText);
		handler = new TextHandler();
		jtfText1.addActionListener(handler);
		jtfUneditableText.addActionListener(handler);
		setSize(325, 100);
		setVisible(true);
	}
	//Inner Class TextHandler
	private class TextHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtfText1) {
				disp = "text1 : " + e.getActionCommand();
			} else if (e.getSource() == jtfUneditableText) {
				disp = "text3 : " + e.getActionCommand();
			}
			JOptionPane.showMessageDialog(null, disp);
		}
	}
	//Main Program that starts Execution
	public static void main(String args[]) {
		JTextFieldDemo test = new JTextFieldDemo();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}// End of class TextFieldTest