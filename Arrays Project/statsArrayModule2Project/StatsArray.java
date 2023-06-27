package module2project;

import java.io.*;
import java.util.*;

/**
 *
 * @author jg
 */
public class StatsArray
{
    private int[] data;
    private int currentSize;
    
    // Constructor. Creates an array of size, size. 
    // Initialize currentSize to 0 
    public StatsArray(int size)
    {
        currentSize = 0;
        data = new int[size];
    }

    // returns the currentSize of the array
    public int getCurrentSize() 
    {
        return currentSize;
    }
    
    // if currentSize is less than the size of the array, add the target at 
    // the end and  return true. Otherwise returns false.
    public boolean append(int target)
    {
        if(data.length > currentSize)
        {
            data[currentSize] = target;
            currentSize++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // Calculate and return the total of all values in the array.
    public int findTotal()
    {
        int total = 0;
        for(int i = 0; i < currentSize; i++)
        {
            total += data[i];
        }
        return total;
    }
    
    // Calculate and return the mean of the values in the array.  
    public double findMean()
    {
        int total = findTotal();
        return Double.valueOf(total) / currentSize;
    }
    
    // Find and return the Median of all the elements in the array.  
    // To do this, you need to sort the array and then find the number 
    // in the middle.  Remember that if there is an even number, the Median 
    // is the average of the two numbers in the middle.
    public double findMedian()
    {
        int[] sortArr = sortArray();
        
        if(sortArr.length % 2 != 0)
        {
            return Double.valueOf(sortArr[currentSize / 2]);
        }
        else
        {
            return Double.valueOf(sortArr[currentSize / 2] + 
                    sortArr[(currentSize / 2) - 1]) / 2.0;
        }
    }
    
    // Calculate and return the standard deviation of the data array
    public double findStandardDeviation()
    {
        double stdDev = 0.0;
        double mean = findMean();
        for(int i = 0; i < currentSize; i++)
        {
            stdDev += Math.pow(data[i] - mean, 2);
        }
        return Math.sqrt(stdDev / currentSize);
    }
    
    // Given a target, it searches the Array for that target.  If found
    // returns the index of the target and removes the target from the list. 
    // It then adjusts the current size of the array. 
    // if not found, it returns -1
    public int removeValue(int target)
    {
        for(int i = 0; i < currentSize; i++)
        {
            if(data[i] == target)
            {
                for(int j = i; j < currentSize - 1; j++)
                {
                    data[j] = data[j+1];
                }
                data[currentSize -1] = 0;
            }
            currentSize --;
            return i;
        }
        return -1;
    }
    
    // creates a new array of  size currentSize.  Copy the  data array 
    // into it. It then returns the array. Use it to make a copy of the data array.
    public int[] cloneArray()
    {
        int[] newArr = new int[currentSize];
        for(int i = 0; i < currentSize; i++)
        {
            newArr[i] = data[i];
        }
        return newArr;
    }
    
    // searches the array for value.  Returns the location(index)
    // of the first occurance of the value.  Returns -1 if not found
    public int findValue(int target)
    {
        for(int i = 0; i < currentSize; i++)
        {
            if(data[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
    // Pick your favorite sort and implement it (Do not use 
    // the sort method in the Arrays class).                                        
    // It first makes a copy of the data array, 
    // sort the copy and returns the sorted copy 
    public int[] sortArray()
    {
        int[] copyArr = cloneArray();
        for(int i = 0; i < currentSize; i++)
        {
            for(int j = 1; j < (currentSize - i); j++)
            {
                if(copyArr[j - 1] > copyArr[j])
                {
                    swap(copyArr, j, j-1);
                }
            }
        }
        return copyArr;
    }    
    
    // swap the array values at index1 and index2. Use this method in sortArray
    public void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    // if currentSize is greater than 10 then displays mot more than 
    // 10 elements (0-9) of the array with                      
    // the index in [] brackets
    public void display()
    {
        int n = (currentSize > 10) ? 10 : currentSize;
        for(int i = 0; i < n; i++)
        {
            System.out.println(String.format("[%d]%d",
                    i, data[i]));
        }
    }
    
    // Write the data array to fileName file. Elements are separated 
    // by comma. Throws an exception if the file can't be created.
    public void toFile(String fileName) throws IOException
    {
        FileWriter fw = new FileWriter(fileName);
        for(int i = 0; i < currentSize; i++)
        {
            fw.write("" + data[i]);
            if(i < currentSize - 1)
            {
                fw.write(",");
            }
        }
        fw.close();
    }
    
    // Returns a String containing the total, mean, median, 
    // and Standard Deviation rounded to at least 3 decimal places.
    @Override
    public String toString() {
                return String.format("%-10s%.3f\n%-10s%.3f\n%-10s%.3f"
                        + "\n%-10s%.3f", 
                        "Total:", Double.valueOf(findTotal()), 
                        "Mean:", findMean(), 
                        "Median:", findMedian(), 
                        "StdDev:", findStandardDeviation());
    }
    
    // Read the array elements from the file into  the data array.  
    // Throws an exception if the file can't be opened for reading. 
    // Assume that the file has 2 or more scores
    public void fromFile(String fileName)
    {
        try 
        {
            // create a Scanner object to read the file
            Scanner sc = new Scanner(new File(fileName));
            // set the delimiter to comma
            sc.useDelimiter(",");

            // empty the array by setting the current size to 0
            currentSize = 0;
            // loop through each value in the input file
            while(sc.hasNext())
                // get each element and store in the array
                append(sc.nextInt());

            // close the scanner
            sc.close();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            System.out.println("\nERROR: File cannot be opened");
        }
    }
    
}
