package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Exception Handling & IO
 */

import java.util.Scanner; 
import javax.swing.JFileChooser;

public class ReadFileUsingJFileChooser 
{
  public static void main(String[] args) throws Exception 
  {
    JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
    {
      // Get the selected file
      java.io.File file = fileChooser.getSelectedFile();

      // Create a Scanner for the file
      Scanner input = new Scanner(file);

      // Read text from the file
      while (input.hasNext()) 
      {
        System.out.println(input.nextLine());
      }

      // Close the file
      input.close();
    }
    
    else 
    {
      System.out.println("No file selected");
    }
  }
}
