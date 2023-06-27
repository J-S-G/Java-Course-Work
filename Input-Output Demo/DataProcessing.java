package dataprocessing;

/**
 * Title:  Data Processing
 * Desc:   Reads/Processes data saved by the DataRecorder program
 *         Read student names and grades and write that data
 * @author jg
 */
import java.util.Scanner;
import java.io.*;

public class DataProcessing
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
       {
        String inputData;
        String [] parts; 
        String fname, lname; 
        int grade; 
        
        try
        {
            // Relative Path
            FileInputStream fileStream = 
                    new FileInputStream("../StudentData/Archive/StudentData.txt");
            
            Scanner fileIn = new Scanner(fileStream);
            
            while(fileIn.hasNext())
            {
                inputData = fileIn.nextLine();
                parts = inputData.split(",");
                // Now do something with the data
                System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
            }
            
            fileIn.close();// Always close it.
            // So we don't want DataRecorder to overwrite our data
            // We need to save it. We can rename it or move it.
            File file = new File("..\\StudentData\\Archive\\StudentData.txt");
            
            // Normally you would put a version # on the end or a date.
            if(file.renameTo(new File("..\\StudentData\\Archive\\StudentData.txt")))
            {
                System.out.println("File moved successfully");
                
            }
            else
            {
                System.err.println("Bad moon rising");
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.err.print("File Not Found");
        }
    }
}
