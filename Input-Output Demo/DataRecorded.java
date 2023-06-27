package datarecorded;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Title: Data Recorder
 * Desc:  Get data from user and save it to a file
 * @author jg
 */
public class DataRecorded 
{
    public static void main(String[] args) 
    {
        Scanner stdin = new Scanner(System.in);
        String input = "";
        String name;
        int grade;
        String [] stuff;
        FileOutputStream fileStream = null;
        PrintWriter fileOut = null;
        
        try
        {
            // We need to open our file. Before anything else.
            // This connects to the hard disk
            fileStream = new FileOutputStream("../StudentData/Archive/StudentData.txt");
            
            // This allows us to read that data.
            fileOut = new PrintWriter(fileStream); 

            System.out.println("Enter a series of first name, last name and test"
                    + " scores. Enter Quit to exit");

            System.out.println("Enter a name and a grade");
            input = stdin.nextLine();
            while(!input.equalsIgnoreCase("Quit"))
            {
                // Parse the data
                stuff = input.split(" "); // Splits a String into an array
                if(stuff.length != 3)
                {
                    System.out.println("Invalid entry");
                }
                else
                {
                    try
                    {
                        // Convert third value to an int
                        grade = Integer.parseInt(stuff[2]);
                        // Validating data. So I want to write it.
                        fileOut.println(stuff[0] + "," 
                                      + stuff[1] + ","
                                      + stuff[2]);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid entry");
                    }
                }
                
                System.out.println("Enter a name and a grade");
                input = stdin.nextLine();
            }
            fileOut.close(); // Always close your file
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File not found, exiting stage left");
        }
    }
}
/*
1) What is an indeterminant vs a determinant loop? 

indeterminant = loop is not determined based on user input / not hard coded
- Do Loop: 1 or more iterations 
- While Loop: is 0 or more iterations

determinant = Loop will iterate N times.
- Will always use a For Loop for determinant loops
*/