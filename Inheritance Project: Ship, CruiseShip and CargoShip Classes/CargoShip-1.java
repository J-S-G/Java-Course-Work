package shiptester;

/**
 *
 * @author jg
 */
public class CargoShip extends Ship
{
    // Private instance variable 
    private int capacityTons;
    
    
    // Public constructor for Ship's name, year and capacity in tons
    public CargoShip(String name, String yearBuilt, int capacityTons) 
    {
        super(name, yearBuilt);
        this.capacityTons = capacityTons;
    }

    // Getter | Accessor
    public int getCapacityTons() 
    {
        return capacityTons;
    }

    // Setter | Mutator
    public void setCapacityTons(int capacityTons) 
    {
        // [this.] refers to the private local variable in the CargoShip class
        this.capacityTons = capacityTons;
    }

    @Override
    public String toString() 
    {
        return getName() + ", Cargo Capacity: " + getCapacityTons() + " tons";
    }
    
    
}
