package com.mycompany.tipcalculator;

import java.util.*;

/**
 *
 * @author Joseph Gibson
 */
public class TipCalculator {

    enum ServiceLevel {
        GREAT, GOOD, BAD, HORRIBLE
    };
    public static final double GREAT_TIP = .20; // Great Service! Tip Well
    public static final double GOOD_TIP = .15; // Good Service! Have a nice day 
    public static final double BAD_TIP = .10; // Bad Service! Waiter was rude 
    public static final double NO_TIP = .00; // Horrible Service! Waiter would be angry

    public static void main(String[] args) {
        // Variables 
        Scanner stdin = new Scanner(System.in);
        double billAmt = 0;
        double tipAmt = 0;
        ServiceLevel serviceLevel; // Casing matters, so this is legal.

        // Get our Input 
        billAmt = getBillAmount();
        serviceLevel = getServiceLevel();

        // Processing and Output
        switch (serviceLevel) {
            case GREAT:
                tipAmt = billAmt * GREAT_TIP;
                break;
            case GOOD:
                tipAmt = billAmt * GOOD_TIP;
                break;
            case BAD:
                tipAmt = billAmt * BAD_TIP;
                break;
            case HORRIBLE:
                tipAmt = billAmt * NO_TIP;
                break;
        }
        System.out.printf("The tip is $%.2f\n", tipAmt);
        System.out.println("Thanks for playing.");
    }

    public static ServiceLevel getServiceLevel() {
        // Variables 
        Scanner stdin = new Scanner(System.in);
        ServiceLevel service = ServiceLevel.GREAT;
        boolean done = false;

        while (!done) {
            System.out.print("Please enter the service level. ");
            for (ServiceLevel srvc : ServiceLevel.values()) // This for loop prints all the values in the enum
            {
                System.out.print(srvc + " ");
            }
            try {
                service = ServiceLevel.valueOf(stdin.nextLine().toUpperCase());
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid Service Level. Try again.");
            }
        }
        return service;
    }

    /**
     * Prompts the user for the amount of the bill. Must be a positive number
     * and valid input.
     *
     * @return bill as a double
     */
    public static double getBillAmount() {
        // Variables 
        Scanner stdin = new Scanner(System.in);
        double billAmount = 0;
        boolean done = false;

        while (!done) {
            try {
                System.out.println("Enter the Bill Amount ");
                billAmount = stdin.nextDouble(); // It reads the double, but leaves the return char
                if (billAmount > 0) {
                    done = true;
                } 
                else 
                {
                    System.out.println("Invalid entry. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid entry. Try again.");
                stdin.nextLine();
            }
        }
        return billAmount; // ONe exit point in your methods.
    }
}
