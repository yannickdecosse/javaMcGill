package Week11;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 16, 2015
	Exercises:		Lists, Stacks, Queues, Sets & Maps
 */

public class TestMyHashMap {
  public static void main(String[] args) {
    // Create a map
    MyMap<String, Integer> map = new MyHashMap<String, Integer>();
    map.put("Smith", 30);
    map.put("Anderson", 31);
    map.put("Lewis", 29);
    map.put("Cook", 29);
    map.put("Smith", 65);

    System.out.println("Entries in map: " + map);

    System.out.println("The age for " + "Lewis is " +
      map.get("Lewis"));

    System.out.println("Is Smith in the map? " + 
      map.containsKey("Smith"));
    System.out.println("Is age 33 in the map? " + 
      map.containsValue(33));

    map.remove("Smith");
    System.out.println("Entries in map: " + map);

    map.clear();
    System.out.println("Entries in map: " + map);
  }
}