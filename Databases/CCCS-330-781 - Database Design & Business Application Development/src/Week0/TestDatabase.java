package Week0;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:	CCCS-330-781 - Database Design & Business Application Development	
	Instructor: 	Katthar Daou
	Date:				May 2, 2015
	Subject:		Testing MySQL Database Connection
 */

import java.sql.*;
import java.util.Scanner;

public class TestDatabase
{
	//	JDBC driver name and database URL
	private static String driverName  =  "com.mysql.jdbc.Driver";
	private static String dbURL  =  "jdbc:mysql://localhost:3306/dev_yannick";
	
	//	Credentials for database access
	private static final String USERNAME  =  "root";
	private static final String PASSWORD = "nUMe96GtZ_ymfFF2Gaj_bQzlwohOb0GAiLak5z431wgCByGqW0iB_w2SPa0ql7OFHIlgcgrKbxfg6YbYsR30CjroSM8DNdqcEjivOheIH1lWm3p06UIEGax4ptJj6xqJ";

	public static void main(String[] args) 
	{	
		Connection connectDatabase  =  null;
		String sqlQuery = "";
		
		try
		{
			//	Register JDBC Driver
			Class.forName(driverName).newInstance();
			
			//	Open connection
			connectDatabase  =  DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
			
			//	Execute query
			Statement printData  =  connectDatabase.createStatement();
			sqlQuery =  "SELECT * FROM person";
			ResultSet resultQuery = printData.executeQuery(sqlQuery);
			
			//	Extract data from table
			while (resultQuery.next())
			{
				int id =  resultQuery.getInt("personID");
				String  firstName =  resultQuery.getString("firstName");
				String  lastName =  resultQuery.getString("lastName");
				String  address =  resultQuery.getString("address");
				String  address2 =  resultQuery.getString("address2");
				String  telNumber =  resultQuery.getString("telNumber");
				String  city =  resultQuery.getString("city");
				String  province =  resultQuery.getString("province");
				String  country =  resultQuery.getString("country");
				String  postalCode =  resultQuery.getString("postalCode");
				
				//	Print data
				System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + address2 + " " + telNumber + " " + city + " " + province + " " + country + " " + postalCode);
			}
			
			//	Adding data in table 
			boolean check = true;
			Scanner input = new Scanner(System.in);
			
			System.out.print("\nDo you want to add data to table? ");
			String answer = input.nextLine();
			
			if (answer.equals("y"))
			{
				while (check)
				{	
					System.out.print("\n\nEnter First Name: ");
					String  firstName = input.nextLine();
				
					System.out.print("\nEnter Last Name: ");
					String  lastName = input.nextLine();
				
					System.out.print("\nEnter Address: ");
					String  address = input.nextLine();
				
					System.out.print("\nEnter Address (optional): ");
					String  address2 = input.nextLine();
				
					System.out.print("\nEnter Telephone Number: ");
					String  telNumber = input.nextLine();
				
					System.out.print("\nEnter City: ");
					String  city = input.nextLine();
				
					System.out.print("\nEnter Province: ");
					String  province = input.nextLine();
				
					System.out.print("\nEnter Country: ");
					String  country = input.nextLine();
				
					System.out.print("\nEnter Postal Code: ");
					String  postalCode = input.nextLine();
				
					//	Insert data by query command
					printData  =  connectDatabase.createStatement();
					printData.executeUpdate("INSERT INTO person (firstName,  lastName, address,  address2,  telNumber,  city ,  province, country, postalCode) VALUES ('"+firstName+"', '"+lastName+"', '"+address+"', '"+address2+"', '"+telNumber+"', '"+city+"', '"+province+"', '"+country+"', '"+postalCode+"')");
				
					System.out.print("\nDo you want to continue? ");
					answer = input.nextLine();
				
					if (!answer.equals("y"))
					{
						check = false;
					}
				
					//	Close Scanner object
					input.close();				
				}
			}
			
			//	Delete data
			System.out.print("\nDo you want to delete data in table? ");
			answer = input.nextLine();
			
			if (answer.equals("y"))
			{
				System.out.print("\n\nEnter ID of data to delete: ");
				int  ID = input.nextInt();
				
				//	Insert data by query command
				printData  =  connectDatabase.createStatement();
				printData.executeUpdate("DELETE FROM person WHERE personID = '"+ID+"'");
			}
			//	Close objects
			resultQuery.close();
			printData.close();
			connectDatabase.close();
		}
		
		catch (SQLException se)
		{
			System.out.println("Connection error...");
		}
		
		catch (Exception se)
		{
			System.out.println("Driver not found...");
		}
	}
}
