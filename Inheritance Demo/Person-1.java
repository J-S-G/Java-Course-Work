package sis;

/**
 *
 * @author jg
 */
public class Person {

    private static int personCount = 1001;
    private String name;
    protected String nickName;
    private int ID;

    public Person()
    {
        this.name = "Unknown";
        ID = 0; // This is an invalid Person
    }
    
    public Person(String name) 
    {
        this.name = name;
        ID = personCount;
        nickName = name + "nay"; // Pig Latin
        personCount++;
    }

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
