package sis;

import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author jg
 */
// Implements everything in that interface
public abstract class Person implements TimeStampMark
{

    private static int personCount = 1001;
    private String name;
    protected String nickName;
    private int ID;
    Timestamp timeStamp; // Create a timestamp when an update happens
    
    
    public Person()
    {
        this.name = "Unknown";
        ID = 0; // This is an invalid Person
        timeStamp = new Timestamp(new Date().getTime());
    }
    
    public Person(String name) 
    {
        this.name = name;
        ID = personCount;
        nickName = name + "nay"; // Pig Latin
        personCount++;
        timeStamp = new Timestamp(new Date().getTime());
        
    }
    
    public void setTimeStamp()
    {        
        timeStamp = new Timestamp(new Date().getTime());
    }
    
    public String getTimeStamp()
    {
        return timeStamp.toString(); // 
    }
    
    // Defining an abstract method. This method must 
    // Be implemented by the child classes before they can be used
    // If company A wants to hand partial code to campy B 
    // and specify methods they must implement. this is how.
    
    public abstract String getDescription();

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public static int getPersonCount() 
    {
        return personCount;
    }

    public int getID() 
    {
        return ID;
    }

    @Override
    public String toString() 
    {
        return "Person{" + "name=" + name + ", ID=" + ID + '}';
    }

    @Override
    public boolean equals(Object obj) 
    {
        System.out.println("Executing the Person Equals Method");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.ID == other.ID;
    }

    
    
}
