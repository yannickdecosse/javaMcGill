package Week14;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Nov 27, 2014
// Handling Exceptions : Read File From URL

import java.util.Scanner;

public class ReadFileFromURL {
  public static void main(String[] args) {
    System.out.print("Enter a URL: ");   
    String URLString = new Scanner(System.in).next();
       
    try {
      java.net.URL url = new java.net.URL(URLString); 
      int count = 0;
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();
        count += line.length();
      } 
      
      System.out.println("The file size is " + count + " bytes");
    }
    catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    }
    catch (java.io.IOException ex) {
      System.out.println("IO Errors");
    }
  }
}   