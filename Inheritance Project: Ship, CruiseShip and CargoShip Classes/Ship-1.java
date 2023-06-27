package shiptester;

/**
 * Desc:   Abstract Class Ship w/2 instance variables
 * @author jg
 */
abstract class Ship 
{
    // Instance variables 
    private String name;
    private String yearBuilt; 

    // Constructor for Ship class object
    public Ship(String name, String yearBuilt) 
    {
        // [this.] is referring to a current object in the Ship class
        // and assigning it to the constructors object
        this.name = name;
        this.yearBuilt = yearBuilt;
    }
    
    // Getter | Accessor 
    public String getName() 
    {
        return name;
    }

    // Setter | Mutator
    public void setName(String name)
    {
        this.name = name;
    }

    // Getter | Accessor 
    public String getYearBuilt()
    {
        return yearBuilt;
    }

    // Setter | Mutator
    public void setYearBuilt(String yearBuilt) 
    {
        this.yearBuilt = yearBuilt;
    }

    // Abstract method for printing the user's input
    @Override
    public String toString() 
    {
        return "Name: " + getName() + ", Year built: " + getYearBuilt();
    }    
    
}
