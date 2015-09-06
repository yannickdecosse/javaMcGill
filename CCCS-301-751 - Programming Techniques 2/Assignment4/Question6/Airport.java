/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		April 1, 2015
 * 
 * Subject:		Assignment 4: Generics & GUI
 * Details:		Using Generics with a data structure together with Swing to create a multi file airport application
 * File name:	Airport.java
 * Purpose:		Use Generics and Swing library
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question6;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Airport extends JFrame
{
	private static final long serialVersionUID = 3155930622907774160L;
	private Queue<Airplane> airplanes;
	private Queue<Passenger> trackPassenger;
	private Passenger managePassenger;
	private int planeNO = 0;
	private JTextArea text = new JTextArea();
	private JScrollPane actions = new JScrollPane(text);
	
	//	Default no-args constructor
	public Airport() {};
	
	public Airport(int numOfPlanes)
	{
		airplanes = new Queue<Airplane>();
		planeNO = numOfPlanes;
		//	inserting each airplane in queue
		for (int i = 0; i < numOfPlanes; i++)
		{
			// Plane ID is index no in queue
			airplanes.enqueue(new Airplane(i, 60));
		}
		trackPassenger = new Queue<Passenger>();
	}
	
	public void menu()
	{
		initUI();
	}
	
	/* *********************************************************************************************************** */
	
	//	1. Main GUI Swing method
	private void initUI()
	{
		//	Create main JFrame
		JFrame mainFrame = new JFrame("Airport & Travel Itineraries System");
		//JTextArea actions = new JTextArea();

		mainFrame.setSize(960,600);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//	Adding an image to JPanel
		ImageIcon image = new ImageIcon("src\\Question3\\icon.gif");
		JLabel label = new JLabel(image, JLabel.CENTER);
		JPanel visual = new JPanel(new BorderLayout());
		visual.add(label, BorderLayout.CENTER);
		
		//	Adding an image to JFrame
		mainFrame.getContentPane().add(visual, BorderLayout.WEST);
		mainFrame.getContentPane().add(actions, BorderLayout.CENTER);
		
		//	Create a navigation menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new java.awt.Color(0, 123, 158));
		JMenu theItems1 = getRegisterPassenger();
		theItems1.setMnemonic(KeyEvent.VK_R);
		menuBar.add(theItems1);
		JMenu theItems2 = getManagePassenger();
		theItems2.setMnemonic(KeyEvent.VK_M);
		menuBar.add(theItems2);
		JMenu theItems3 = getDispatchAirplane();
		theItems3.setMnemonic(KeyEvent.VK_D);
		menuBar.add(theItems3);
		
		//	Add menu bar to JFrame
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);	
	}
	
	/* *********************************************************************************************************** */	
	
	//	2. Option Register A Passenger sub-menu
	private JMenu getRegisterPassenger()
	{
		JMenu registerPassengerMenu = new JMenu("Register A Passenger");
		registerPassengerMenu.setForeground(Color.WHITE);
		JMenuItem choices = new JMenuItem("Proceed to registration");
		registerPassengerMenu.add(choices);
		
		//	Add actionListener to menu option 'Register A Passenger'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent register)
			{
				registerPassenger();
			}
		});
		
		return registerPassengerMenu;
	}
	
	/* *********************************************************************************************************** */	
	
	//	3. Option Manage Passenger Itinerary sub-menu
	private JMenu getManagePassenger()
	{
		JMenu managePassengerMenu = new JMenu("Manage Passenger Itinerary");
		managePassengerMenu.setForeground(Color.WHITE);
		JMenuItem choices = new JMenuItem("Display Itinerary");
		choices.setMnemonic(KeyEvent.VK_S);
		managePassengerMenu.add(choices);
		
		//	Add actionListener to menu option 'Display Itinerary'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent dispatch)
			{
				if (checkPassengerAndAirplane())
				{
					displayItinerary();
				}
			}
		});
	
		managePassengerMenu.addSeparator();
		choices = new JMenuItem("Add an itinerary item");
		choices.setMnemonic(KeyEvent.VK_A);
		managePassengerMenu.add(choices);
		
		//		Add actionListener to menu option 'Add an itinerary item'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent dispatch)
			{
				if (checkPassengerAndAirplane())
				{
					addItinerary();
				}
			}
		});
		
		managePassengerMenu.addSeparator();
		choices = new JMenuItem("Delete an itinerary item");
		choices.setMnemonic(KeyEvent.VK_E);
		managePassengerMenu.add(choices);
		
		//	Add actionListener to menu option 'Delete an itinerary item'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent dispatch)
			{
				if (checkPassengerAndAirplane())
				{
					deleteItinerary();
				}
			}
		});
		
		managePassengerMenu.addSeparator();
		choices = new JMenuItem("Move an itinerary item");
		choices.setMnemonic(KeyEvent.VK_V);
		managePassengerMenu.add(choices);
		
		//	Add actionListener to menu option 'Move an itinerary item'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent dispatch)
			{
				if (checkPassengerAndAirplane())
				{
					moveItinerary();
				}
			}
		});		
		
		return managePassengerMenu;
	}
	
	/* *********************************************************************************************************** */	
	
	//	4. Option Dispatch An Airplane sub-menu
	private JMenu getDispatchAirplane()
	{
		JMenu dispatchAirplaneMenu = new JMenu("Dispatch An Airplane");
		dispatchAirplaneMenu.setForeground(Color.WHITE);
		JMenuItem choices = new JMenuItem("Proceed to dispatch");
		dispatchAirplaneMenu.add(choices);
		
		//	Add actionListener to menu option 'Dispatch An Airplane'
		choices.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent dispatch)
			{
				dispatchAirplane();
			}
		});
		
		return dispatchAirplaneMenu;
	}
	
	/* *********************************************************************************************************** */	
	
	//	5. Method to register each passenger
	private void registerPassenger()
	{
		boolean check = false;
		String registerName = "";
		String registerActivity = "";
		String regex = "[0-9]+";
		int registerPlane = 0;
		int registerRow = 0;
		int registerCol = 0;
		//	Counter for account for no of activities
		int counter = 1;
		//	Counter to check if passenger already exist in system
		int trackAlreadyPresent = 0;
		//	Passenger object to add new passenger
		Passenger newPassenger;
		//	Airplane object to add passenger
		Airplane modifyPlane;
		
		while (!check)
		{
			//	Reset trackAlreadyPresent
			trackAlreadyPresent = 0;
			
			String passengerName = JOptionPane.showInputDialog(null, "Please enter name of passenger: ", "Register a passenger", JOptionPane.QUESTION_MESSAGE);
			
			//	If cancel button is pressed
			if (passengerName == null)
			{
				return;
			}
			
			//	Check if something is entered. Else, prompt user to enter a name
			else if (passengerName.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Error: you haven't enter anything!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else
			{
				registerName = passengerName;
				
				// Check if passenger is already registered in system
				if (trackPassenger.getQueueSize() != 0)
				{
					for (int i = 0; i < trackPassenger.getQueueSize(); i++)
					{
						if ((trackPassenger.peek(i)).getPassengerName().equals(registerName))
						{
							trackAlreadyPresent++;
						}
					}
					
					if (trackAlreadyPresent > 0)
					{
						JOptionPane.showMessageDialog(null, "Error: this passenger is already registered in system!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else
					{					
						text.append("\n\n" + "\tNew Passenger name is " + registerName + "\n\t---------------------------------------------------------------------------------");
						//	End loop
						check = true;
					}
				}
				
				//	When queue of passenger is empty, add first passenger
				else
				{				
					text.append("\n\n" + "\tNew Passenger name is " + registerName + "\n\t---------------------------------------------------------------------------------");
					//	End loop
					check = true;
				}
			}
		}
		
		//	Instantiate new Passenger object
		newPassenger = new Passenger(registerName);
		
		//	Ask user to enter activities
		int selectedOption = JOptionPane.showConfirmDialog(null, "Do you want to add activities now?", "Register an activity", JOptionPane.YES_NO_OPTION); 
		
		if (selectedOption == JOptionPane.YES_OPTION) 
		{		
			//	Ask user to enter each activity in itinerary list
			check = false;
		
			while (!check)
			{
				String activities = JOptionPane.showInputDialog(null, "Please enter an activity: ", "Register an activity", JOptionPane.QUESTION_MESSAGE);
				
				if (activities == null)
				{
					return;
				}
				
				//	Check if something is entered. Else, prompt user to enter a name
				else if (activities.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Error: you haven't enter anything!", "Register an activity", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					registerActivity = activities;

					if (newPassenger.addItem(registerActivity))
					{
						text.append("\n\t" + counter + "." + "\t" + registerActivity);
						counter++;
					}
				}
				
				//	Ask user if add more activities
				int continueActivity = JOptionPane.showConfirmDialog(null, "Do you want to add another?", "Register an activity", JOptionPane.YES_NO_OPTION);
				
				if (continueActivity == JOptionPane.NO_OPTION)
				{
					check = true;
				}
			}
		}
		
		else
		{
			text.append("\n\tNo activity recorded now...");
		}
		
		//	Assigning passenger to an airplane
		check = false;
		
		//	Check if there is airplane registered in airport system
		if (airplanes.getQueueSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "Error: No airplane available in system!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
			
			check = true;
		}
		
		else
		{
			//	Print no of airplanes available
			text.append("\n\n" + "\tThere are " + airplanes.getQueueSize() + " airplane(s) available...");
			
			while (!check)
			{
				String planeIDregister = JOptionPane.showInputDialog(null, "Please enter id of airplane (index no in queue): ", "Register a passenger", JOptionPane.QUESTION_MESSAGE);
			
				//	If cancel button is pressed
				if (planeIDregister == null)
				{
					return;
				}
				
				//	Check if something is entered. Else, prompt user to enter a name
				else if (planeIDregister.trim().isEmpty() || !(planeIDregister.matches(regex)))
				{
					JOptionPane.showMessageDialog(null, "Error: enter a digit only!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					registerPlane = Integer.parseInt(planeIDregister);
				
					if (registerPlane < 0 || registerPlane >= planeNO)
					{
						JOptionPane.showMessageDialog(null, "Error: plane ID not found!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
					}
				
					else
					{
						//	Check if airplane is still in airport
						for (int i = 0; i < airplanes.getQueueSize(); i++)
						{
							if ((airplanes.peek(i)).getPlaneID() == registerPlane)
							{
								//	End loop
								check = true;
							}
						}
					
						if (!check)
						{
							JOptionPane.showMessageDialog(null, "Error: plane already left airport!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
						}
					
						else
						{
							newPassenger.setPlaneID(registerPlane);
							text.append("\n\n" + "\tPassenger " + registerName + " is assigned to airplane " + registerPlane);
					
							//	End loop
							check = true;
						}
					}
				}
			}
		
			// Assigning seat to passenger
			check = false;
		
			while (!check)
			{
				String seatRowRegister = JOptionPane.showInputDialog(null, "Please enter seat row: ", "Register a passenger", JOptionPane.QUESTION_MESSAGE);
				String seatColRegister = JOptionPane.showInputDialog(null, "Please enter seat number: ", "Register a passenger", JOptionPane.QUESTION_MESSAGE);
			
				//	If cancel button is pressed
				if (seatRowRegister == null || seatColRegister == null)
				{
					return;
				}
				
				//	Check if something is entered. Else, prompt user to enter a name
				else if (seatRowRegister.trim().isEmpty() || seatColRegister.trim().isEmpty() || !(seatRowRegister.matches(regex)) || !(seatColRegister.matches(regex)))
				{
					JOptionPane.showMessageDialog(null, "Error: the seat row or seat number is missing or wrong!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					registerRow = Integer.parseInt(seatRowRegister);
					registerCol = Integer.parseInt(seatColRegister);
				
					if (airplanes.peek(registerPlane).getSeat(registerRow, registerCol) || airplanes.peek(registerPlane) == null)
					{
						JOptionPane.showMessageDialog(null, "Error: seat not available!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);
					}
				
					else
					{
						//	Assigning seat row and col to pasenger
						newPassenger.setSeatRow(registerRow);
						newPassenger.setSeatColumn(registerCol);
						//	Set plane seat to true - occupied
						(airplanes.peek(registerPlane)).setSeat(registerRow, registerCol);
						text.append("\n\n" + "\tPassenger " + registerName + " is assigned seat " + registerRow + "|" + registerCol + "\n\t---------------------------------------------------------------------------------");
					
						//	End loop
						check = true;
					}
				}
			}
 
			//	When done, assign passenger to chosen airplane
			//	Remove plane from queue first
			modifyPlane = airplanes.delete(registerPlane);
			//	Add passenger to it
			modifyPlane.setPassenger(newPassenger);
			//	Put back in same position in queue
			airplanes.insert(modifyPlane, registerPlane);
			//	Add passenger to trackPassenger queue in airport
			trackPassenger.enqueue(newPassenger);
		}
	}
	
	/* *********************************************************************************************************** */	
	
	//	6. Method to display itinerary
	private void displayItinerary()
	{
		//	Check if Itinerary list is empty
		if ((managePassenger.getItinerary()).isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Error: Itinerary list is empty!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Passenger: " + managePassenger.getItinerary(), "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/* *********************************************************************************************************** */	
	
	//	7. Method to add an itinerary item
	private void addItinerary()
	{
		boolean check = false;
		int ask = 0;
		
		while (!check)
		{
			String addActivity = JOptionPane.showInputDialog(null, "Please enter new activity: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
			
			//	If cancel button is pressed
			if (addActivity == null)
			{
				return;
			}
			
			//	Check if something is entered. Else, prompt user to enter a name
			else if (addActivity.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Error: you haven't enter anything!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else
			{
				//	Message for successful addition
				if (managePassenger.addItem(addActivity))
				{
					JOptionPane.showMessageDialog(null, "Activity has been added to the list.", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//	Message for unsuccessful addition
				else
				{
					JOptionPane.showMessageDialog(null, "Error: activity hasn't been successfully added.", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//	Ask to add more activities
				ask = JOptionPane.showConfirmDialog(null, "Do you want to add another activity?", "Manage Passenger Itinerary", JOptionPane.YES_NO_OPTION);
				
				//	If user do not add more activities, quit
				if (ask == JOptionPane.NO_OPTION)
				{
					//	End loop
					check = true;
				}
			}
		}		
	}
	
	/* *********************************************************************************************************** */	
	
	//	8. Method to delete an itinerary item
	private void deleteItinerary()
	{
		boolean check = false;
		int deleteActivity = 0;
		int ask = 0;
		String regex = "[0-9]+";
		
		//	Check if Itinerary list is empty
		if ((managePassenger.getItinerary()).isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Error: Itineray list is empty!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			while (!check)
			{
				String activity = JOptionPane.showInputDialog(null, "Please enter the position of activity in list to delete: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
			
				//	If cancel button is pressed
				if (activity == null)
				{
					return;
				}
			
				//	Check if something is entered. Else, prompt user to enter a name
				else if (activity.trim().isEmpty() || !(activity.matches(regex)))
				{
					JOptionPane.showMessageDialog(null, "Error: enter a digit only!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					deleteActivity = Integer.parseInt(activity);
				
					//	Message for successful addition
					if (managePassenger.deleteItem(deleteActivity - 1))
					{
						JOptionPane.showMessageDialog(null, "Activity has been deleted from the list.", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}
				
					//	Message for unsuccessful addition
					else
					{
						JOptionPane.showMessageDialog(null, "Error: activity hasn't been successfully deleted!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}

					ask = JOptionPane.showConfirmDialog(null, "Do you want to delete another activity?", "Manage Passenger Itinerary", JOptionPane.YES_NO_OPTION);
				
					//	If user do not add more activities, quit
					if (ask == JOptionPane.NO_OPTION)
					{
						//	End loop
						check = true;
					}
				}
			}
		}
	}
	
	/* *********************************************************************************************************** */	
	
	//	9. Method to move an itinerary item
	private void moveItinerary()
	{
		boolean check = false;
		boolean moveAgain = false;
		int moveActivityFrom = 0;
		int moveActivityTo = 0;
		int ask = 0;
		String regex = "[0-9]+";
		
		//	Check if Itinerary list is empty
		if ((managePassenger.getItinerary()).isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Error: Itineray list is empty!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
		{
			while (!moveAgain)
			{
				while (!check)
				{
					String moveFrom = JOptionPane.showInputDialog(null, "Please enter the position of activity in list to move: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
			
					//	If cancel button is pressed
					if (moveFrom == null)
					{
						return;
					}
			
					//	Check if something is entered. Else, prompt user to enter a name
					else if (moveFrom.trim().isEmpty() || !(moveFrom.matches(regex)))
					{
						JOptionPane.showMessageDialog(null, "Error: enter a digit only!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}
				
					else
					{
						moveActivityFrom = Integer.parseInt(moveFrom);
						check = true;
					}
				}
			
				check = false;
			
				while (!check)
				{	
					String moveTo = JOptionPane.showInputDialog(null, "Please enter the new position: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
				
					//	If cancel button is pressed
					if (moveTo == null)
					{
						return;
					}
			
					//	Check if something is entered. Else, prompt user to enter a name
					else if (moveTo.trim().isEmpty() || !(moveTo.matches(regex)))
					{
						JOptionPane.showMessageDialog(null, "Error: enter a digit only!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}	
				
					else
					{
						moveActivityTo = Integer.parseInt(moveTo);
						check = true;
					}
				}

				//	Message for successful addition
				if (managePassenger.moveItem(moveActivityFrom - 1, moveActivityTo - 1))
				{
					JOptionPane.showMessageDialog(null, "Activity has been moved.", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//	Message for unsuccessful addition
				else
				{
					JOptionPane.showMessageDialog(null, "Error: activity hasn't been moved successfully! Try again.", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}

				ask = JOptionPane.showConfirmDialog(null, "Do you want to move another activity?", "Manage Passenger Itinerary", JOptionPane.YES_NO_OPTION);
				
				//	If user do not add more activities, quit
				if (ask == JOptionPane.NO_OPTION)
				{
					//	End loop
					moveAgain = true;
				}
			}
		}		
	}	
	
	/* *********************************************************************************************************** */	
	
	//	10. Method to dispatch airplane
	private void dispatchAirplane()
	{
		int counter = 0;
		Airplane dispatchAirplane;
		
		//	Check if queue is empty
		if (airplanes.getQueueSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "Error: no airplane available in system!", "Register a passenger", JOptionPane.INFORMATION_MESSAGE);			
		}
		
		else
		{
			//	Remove airplane from system
			dispatchAirplane = airplanes.dequeue();
			text.append("\n\n\t---------------------------------------------------------------------------------");
			text.append("\n" + "\tAirplane " + dispatchAirplane.getPlaneID() + " is leaving the airport..." + "\n\t---------------------------------------------------------------------------------");
			
			while (counter < trackPassenger.getQueueSize())
			{
				//	If passengers in system are registered on airplane removed, remove also the passengers
				if ((trackPassenger.peek(counter)).getplaneID() == dispatchAirplane.getPlaneID())
				{
					trackPassenger.delete(counter);
				}
				
				counter++;
			}
			
			dispatchAirplane = null;
		}
	}
	
	/* *********************************************************************************************************** */	
	
	//	11. Method to check if airplane and passenger exist in airport system
	private boolean checkPassengerAndAirplane()
	{
		boolean check = false;
		boolean found = false;
		String regex = "[0-9]+";
		String findPassenger = "";
		int findPlane = 0;
		
		//	Check to see if there are airplanes in system
		if (airplanes.getQueueSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "Error: no airplane available in system!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
			
			return found;
		}
		
		//	Check to see if there are passengers in system
		else if (trackPassenger.getQueueSize() == 0)
		{
			JOptionPane.showMessageDialog(null, "Error: no passengers available in system!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
			
			return found;
		}
		
		else
		{
			//	Check to see if plane exists
			while (!check)
			{
				String planeIDregister = JOptionPane.showInputDialog(null, "Please enter id of airplane: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
			
				//	If cancel button is pressed
				if (planeIDregister == null)
				{
					return false;
				}
				
				//	Check if something is entered. Else, prompt user to enter a name
				else if (planeIDregister.trim().isEmpty() || !(planeIDregister.matches(regex)))
				{
					JOptionPane.showMessageDialog(null, "Error: enter a digit only!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					findPlane = Integer.parseInt(planeIDregister);
				
					if (findPlane < 0 || findPlane >= planeNO)
					{
						JOptionPane.showMessageDialog(null, "Error: plane ID not found!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}
				
					else
					{	
						//	Check if airplane is still in airport
						for (int i = 0; i < airplanes.getQueueSize(); i++)
						{
							if ((airplanes.peek(i)).getPlaneID() == findPlane)
							{
								//	End loop
								check = true;
							}
						}
					
						if (!check)
						{
							JOptionPane.showMessageDialog(null, "Error: plane already left airport!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		
			//	Check to see if passenger exist
			check = false;

			while (!check)
			{
				String passengerName = JOptionPane.showInputDialog(null, "Please enter name of passenger: ", "Manage Passenger Itinerary", JOptionPane.QUESTION_MESSAGE);
			
				//	If cancel button is pressed
				if (passengerName == null)
				{
					return false;
				}
				
				//	Check if something is entered. Else, prompt user to enter a name
				else if (passengerName.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Error: you haven't enter anything!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
				}
			
				else
				{
					findPassenger = passengerName;
				
					if (trackPassenger.getQueueSize() == 0)
					{
						JOptionPane.showMessageDialog(null, "Error: No passenger is yet registered!", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
					}
				
					else
					{
						for (int i = 0; i < trackPassenger.getQueueSize(); i++)
						{
							if ((trackPassenger.peek(i)).getPassengerName().equals(passengerName) && (trackPassenger.peek(i)).getplaneID() == findPlane)
							{
								managePassenger = trackPassenger.peek(i);
								text.append("\n\n" + "\tPassenger " + findPassenger + " is on plane ID " + managePassenger.getplaneID() + "\n\t---------------------------------------------------------------------------------");
							
								check = true;
								found = true;
							}
						}
					
						if (!found)
						{
							JOptionPane.showMessageDialog(null, "Error: Passenger is not on this plane", "Manage Passenger Itinerary", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				
					check = true;
				}
			}
		
			return found;
		}
	}
}
