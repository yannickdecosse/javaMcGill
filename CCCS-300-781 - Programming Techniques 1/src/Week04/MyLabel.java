package Week04;
// Yannick Decosse 260551160
// CCCS-300-781 Programming Techniques 1
// Instructor: Dr. Malleswara Talla
// Sep 25, 2014

// Label Text

import java.applet.Applet;
import java.awt.*;

public class MyLabel extends Applet {
   private Font f;
   private Label noLabel, textLabel; 

   public void init()
   {
      f = new Font( "Courier", Font.BOLD, 14 );

      // call label constructor with no text
      noLabel = new Label();

      // call label constructor with a string argument
      textLabel = new Label( "This is read-only text" );

      // set font for text displayed in label
      textLabel.setFont( f );

      // add label components to applet container
      add( noLabel );
      add( textLabel );
   }
}