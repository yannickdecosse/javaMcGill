package Week12;
/*
	Name:			Yannick Decosse
	McGill ID:		260551160
	Course ID:		CCCS-301-751 - Programming Techniques 2
	Instructor: 	Joseph Vybihal
	Date:			March 21, 2015
	Exercises:		Overriding equals() & hashCode() methods
 */

public class Student {

    private String name;
    private int age;
    private int totalMarks;

    public Student(){}

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        totalMarks = marks;
    }

    public void setMarks(int marks) {
        totalMarks = marks;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
        	return true;
        }
            
        else if((obj == null) || (obj.getClass() != this.getClass()))
        {
        	return false;
        }
            
        // object must be Test at this point
        Student stud = (Student)obj;
        return age == stud.age && (name != null && name.equals(stud.name));
    }

    @Override
    public int hashCode() {
        final int seed = 37;
        int result = 1;
        
        result = seed * result + ((name == null) ? 0 : name.hashCode());
        result = seed * result + age;
        
        return result;
    }
}