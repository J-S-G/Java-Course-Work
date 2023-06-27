package shiptester;

/**
 * Desc:   Demonstrate the Ship, CruiseShip, and CargoShip Classes
 * @author jg
 */
public class ShipTester {

    public static void main(String[] args) 
    {
        // Empty array using Parent Class Ship which CruiseShip, 
        // CargoShip are inheriting from
        Ship[] ships = new Ship[4];
        
        // Calls to the CruiseShip||CargoShip Class toString method
        // The toString method calls the setter and getter methods.
        ships[0]= new CruiseShip("Disney Magic","1998",
                2400);
        ships[1] = new CargoShip("Black Pearl","1800",
                5000);
        ships[2]= new CruiseShip("Norwegian","1999",
                3000);
        ships[3] = new CargoShip("Japan's Lux Imports","2023",
        1000);

        // A for loop that iterates and prints ea. Ship object w/it's data
        for(Ship aShip:ships)
        {
            System.out.println(aShip);
        }
    }
    
}
