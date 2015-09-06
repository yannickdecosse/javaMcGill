package Week5;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Dr. Hang Lau
	Date:			February 1, 2015
	Exercises:		Queues
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.TimeZone;

public class TestQueue
{
  public static void main(String[] args)
  {
    Queue<String> queue = new LinkedList<String>();
    
    queue.offer("Oklahoma");
    queue.offer("Indiana");
    queue.offer("Georgia");
    queue.offer("Texas");

    while (queue.size() > 0)
    {
    	System.out.print(queue.remove() + " ");
    }
    String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
    						"December"};
    
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    int actualYear = calendar.get(Calendar.YEAR);
    int actualMonth = calendar.get(Calendar.MONTH);
    String mName = monthName[calendar.get(Calendar.MONTH)];
    
    System.out.println("\n" + actualYear + " " + calendar.getTime() + " " + actualMonth + mName);
      
  }
}
