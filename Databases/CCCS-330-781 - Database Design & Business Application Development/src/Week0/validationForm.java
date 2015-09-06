/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:	CCCS-330-781 - Database Design & Business Application Development	
	Instructor: 	Katthar Daou
	Date:				September 6, 2015
	Subject:		Validation Form and update database
 */

package Week0;

// Initialize packages
import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class validationForm extends JFrame
{	
	private static final long serialVersionUID = 3442392442635255187L;

	//	Default no-args
	public validationForm() 
	{
		//	Launch form display
		fill_in();
	}
	
	//	Create "fill_in"  method to display form
	private void fill_in()
	{
		//	Set Layout of JFrame to null
		setLayout(null);
		
		//	Create fields
		//	Field for "First Name"
		JLabel fName = new JLabel("First Name");
		fName.setBounds(10, 10, 80, 25);
		add(fName);

		JTextField firstName = new JTextField(50);
		firstName.setBounds(150, 10, 260, 25);
		add(firstName);
		
		//	Field for "Last Name"
		JLabel lName = new JLabel("Last Name");
		lName.setBounds(10, 70, 80, 25);
		add(lName);

		JTextField lastName = new JTextField(50);
		lastName.setBounds(150, 70, 260, 25);
		add(lastName);
		
		//	Field for "Address 1"
		JLabel Ad1 = new JLabel("Address 1");
		Ad1.setBounds(10, 130, 80, 25);
		add(Ad1);

		JTextField Address1 = new JTextField(70);
		Address1.setBounds(150, 130, 260, 25);
		add(Address1);
		
		//	Field for "Address 2"
		JLabel Ad2 = new JLabel("Address 2");
		Ad2.setBounds(10, 190, 80, 25);
		add(Ad2);

		JTextField Address2 = new JTextField(70);
		Address2.setBounds(150, 190, 260, 25);
		add(Address2);
		
		//	Field for "Telephone Number"
		JLabel tel = new JLabel("Telephone No.");
		tel.setBounds(10, 250, 80, 25);
		add(tel);

		JTextField telephone = new JTextField(12);
		telephone.setBounds(150, 250, 260, 25);
		add(telephone);
		
		//	Field for "Email"
		JLabel email = new JLabel("Email");
		email.setBounds(10, 310, 80, 25);
		add(email);

		JTextField e_mail = new JTextField(12);
		e_mail.setBounds(150, 310, 260, 25);
		add(e_mail);
		
		//	Field for "City"
		JLabel city = new JLabel("City");
		city.setBounds(10, 370, 80, 25);
		add(city);

		JTextField cityName = new JTextField(12);
		cityName.setBounds(150, 370, 260, 25);
		add(cityName);
		
		//	List for "Province"
		JLabel province = new JLabel("Province");
		province.setBounds(10, 430, 80, 25);
		add(province);

		String[] provinceName = { "Alberta", "British-Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon" };
	    final JComboBox<String>  provinceList = new JComboBox<String> (provinceName);
	    //	provinceList.getSelectedItem();
	    provinceList.setBounds(150, 430, 260, 25);
		add(provinceList); 
		
		//	Field for "Postal Code"
		JLabel postalCode = new JLabel("Postal Code");
		postalCode.setBounds(10, 490, 80, 25);
		add(postalCode);

		JTextField postal_code = new JTextField(7);
		postal_code.setBounds(150, 490, 50, 25);
		add(postal_code);
		
		//	Add "Submit" button
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(10, 550, 100,30);
		add(submit);
		
		//	Add "Clear" button
		JButton clear = new JButton("CLEAR");
		clear.setBounds(120, 550, 100,30);
		add(clear);
		
		//	Insert fields and labels in JFrame
		setTitle("Validation Form");
		setSize(500,700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//	Method to validate form
	private void validateForm()
	{
	}
	
}
