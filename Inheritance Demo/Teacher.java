package sis;

/**
 * Title:  Teacher
 * @author jg
 */
public class Teacher extends Person
{
    private int creditsTeaching;

    public Teacher(int creditsTeaching, String name) 
    {
        super(name);
        this.creditsTeaching = creditsTeaching;
    }

    public int getCreditsTeaching() 
    {
        return creditsTeaching;
    }

    public void setCreditsTeaching(int creditsTeaching) 
    {
        this.creditsTeaching = creditsTeaching;
    }

    @Override
    public String toString() 
    {
        return "Teacher{" + "creditsTeaching=" + creditsTeaching + '}' +
                super.toString();
    }
    
    public void talkPC()
    {
        System.out.println("I'm sorry you feel that way");
    }
}
