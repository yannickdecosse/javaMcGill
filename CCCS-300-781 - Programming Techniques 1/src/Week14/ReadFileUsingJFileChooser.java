package Week14;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Nov 27, 2014
// Handling Exceptions : Read File From URL

import java.util.Scanner; 
import javax.swing.JFileChooser;

public class ReadFileUsingJFileChooser {
  public static void main(String[] args) throws Exception {
    JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showOpenDialog(null)
        == JFileChooser.APPROVE_OPTION) {
      // Get the selected file
      java.io.File file = fileChooser.getSelectedFile();

      // Create a Scanner for the file
      Scanner input = new Scanner(file);

      // Read text from the file
      while (input.hasNext()) {
        System.out.println(input.nextLine());
      }

      // Close the file
      input.close();
    }
    else {
      System.out.println("No file selected");
    }
  }
}