package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		Implementing Linear Probing Hash Table
*/

import java.util.Scanner;

/** Class LinearProbingHashTableTest **/
public class TestLinearProbingHashTable
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /** maxSizeake object of LinearProbingHashTable **/
        LinearProbingHashTable lpht = new LinearProbingHashTable(scan.nextInt() );
 
        char ch;
        /**  Perform LinearProbingHashTable operations  **/
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");            
            System.out.println("4. clear");
            System.out.println("5. size");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter key and value");
                lpht.insert(scan.next(), scan.next() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter key");
                lpht.remove( scan.next() ); 
                break;                        
            case 3 : 
                System.out.println("Enter key");
                System.out.println("Value = "+ lpht.get( scan.next() )); 
                break;                                   
            case 4 : 
                lpht.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
            case 5 : 
                System.out.println("Size = "+ lpht.getSize() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display hash table **/
            lpht.printHashTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
        
        scan.close();
    }
}