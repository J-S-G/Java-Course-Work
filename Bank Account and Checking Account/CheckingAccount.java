package BankTesterJava;

import java.text.NumberFormat;

// Checking account is a child of BankAccount 
public class CheckingAccount extends BankAccount 
{
    private double transactionFee;
    /*constructors that call the superclass (BankAccount) constructors
    */
    // Link the child constructor with the parent constructors 
    // Always build the parent first. To do that, we use super 
    public CheckingAccount() 
    {
        //TODO
        // Call the superclass constructor as the first statement
        super(); 
    }
    /**
    *constructs a checking account bank account with an initial balance,
    * an account number , an owner and a fee!
    * @param acctNum account number
    * @param name name of account holder
    * @param balance balance in the account
    * @param fee fee charged with deposit and withdraws
    */
    public CheckingAccount(int acctNum, String name, double balance, double fee)
    {
        // Passes key information to the parent 
        super(acctNum, name, balance);
        // Now we init the Checking Account 
        this.transactionFee = fee;
    }
    
    /**
    * the accessor method for transactionFe
    * @return transactionFee
    */
    public double getTransactionFee()
    {
        return transactionFee;
    }
    
    /**
    * sets the transactionFee
    * @param fee the transaction Fee
    */
    public void setTransactionFee(double fee) 
    {
        transactionFee = fee;
    }
    
    /**
    * This is overridden method
    * @param amount to be deposited
    *
    */
    public void deposit(double amount)
    {
        // Calls the parent deposit method and passes an amount 
        // This deposit overrides the parents deposit method.
        super.deposit(amount - transactionFee);
    }
    
    /**
    * This is overridden method
    * @param amount to be withdrawn
    */
    public void withdraw(double amount) 
    {
        // utilize the withdraw in the parent class.
        super.withdraw(amount - transactionFee);
    }
    
    /**
    * @return String representation of CheckingAccount object
    */
    public String toString( )
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        // Utilize 
        return super.toString() + " Transaction Fee: " + 
                fmt.format(transactionFee);
    }
} //end of Checking Account Class definition