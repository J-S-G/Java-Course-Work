package shiptester;

/**
 *
 * @author jg
 */
public class CruiseShip extends Ship
{
    // field for maximum number of passengers
    private final int maxPassengers;

    // Constructor for Cruise ship that inherits from Ship 
    public CruiseShip(String name, String yearBuilt, int maxPassengers) 
    {
        // super is a built in method that 
        // lets subclasses inherit from Super class
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }
    // Getter | Accessor
    public int getMaxPassengers()
    {
        return maxPassengers;
    }

    @Override
    public String toString()
    {
        return "Name: " + getName() + ", Year Built: " + getYearBuilt() +
                ", Maximum passengers: " + getMaxPassengers();
    }
    
    
 
}
