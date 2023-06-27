package sis;

/**
 * Title:  Student
 * @author jg
 */
// We want to "extend" Person so it is also a Student. Studen is-a Person
public class Student extends Person
{
    private int creditsTaking;

    // We need to call the parents constructor
    public Student() 
    {
        super(); // Super to call the parent.
    }

    // Second Constructor. Notice how we pass the name on.
    public Student(int creditsTaking, String name) 
    {
        super(name); // The parent MUST be created first
        this.creditsTaking = creditsTaking;
    }

    public int getCreditsTaking() 
    {
        return creditsTaking;
    }

    public void setCreditsTaking(int creditsTaking) 
    {
        this.creditsTaking = creditsTaking;
    }

    public String getNameAndNickName()
    {
        // Private and Protected Instance Variables in the Parent Class
        return super.getName() + " " +
                nickName; // Name is in red, NickName isn't.
    }
    
    @Override
    public String toString() 
    {
        return "Student{" + "creditsTaking=" + creditsTaking + '}' + 
                super.toString(); // We can use super to call a parents toString
    }

    public void talkTrash()
    {
        System.out.println("Students rule, teachers drool");
    }
}
