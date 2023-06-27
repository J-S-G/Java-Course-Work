package module2project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


/**
 * 
 * @author Joseph Gibson
 * <p> Date 03/26/2023 
 * <p> Driver for StatsArray class
 */
public class StatsArrayDriver
{

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(System.in);
		final int SIZE = 100;
		StatsArray newArray = new StatsArray(SIZE);
		int index = 1;
		int numScores;
		String fName;

		Random rand = new Random();
		System.out.print("How many scores do you want to store in the array?  ");

		numScores = scan.nextInt();
		System.out.println("Enter " + numScores + " scores between 0 -100 inclusive");

		while (index <= numScores) {
			newArray.append(scan.nextInt());
			index++;
		}

		System.out.println("Exam Scores");
		System.out.println("---------------");
		newArray.display();

		System.out.println("The Exam Statistics");
		System.out.println("---------------");

		System.out.println(newArray.toString());
		// Testing findValue
		if (newArray.findValue(100) != -1) {
			System.out.println("You have a perfect score");
		} else
			System.out.println("\nYou DO NOT have a perfect score");

		// Testing remove Value
		System.out.print("Enter a score to be removed: ");

		index = newArray.removeValue(scan.nextInt());
		if (index != -1) {
			System.out.println("Found and Removed from the index: " + index);
			System.out.println("The new stats are: ");
			System.out.println("---------------");
			System.out.println(newArray);
		} else
			System.out.println("Not found");

		System.out.println("----- sorted array----");
		int[] sortedArray = newArray.sortArray();
		for (int i = 0; i < newArray.getCurrentSize(); i++) {
			System.out.println("[ " + i + " ]" + sortedArray[i]);
		}

		// Testing append and if the array can grow
		System.out.println("Adding two more scores");
		if (newArray.append(90))
			System.out.println("Added");
		if (newArray.append(100))
			System.out.println("Added");
		System.out.println("The current size of the array : " + newArray.getCurrentSize());
		
		// Testing if refused to add more after adding the 100th element
		for (int i = 0; i < SIZE; i++) {
			if (!newArray.append(rand.nextInt(101))) {
				System.out.println("Array is full");
				break; // break once the array is full
			}

		}
		System.out.println("Removing 10 random values ");
		for (int i = 0; i < 10; i++) {
			if (newArray.removeValue(rand.nextInt(101)) != -1) {
				System.out.println("Found and removed");
				
			}

		}
		System.out.println("The current size: " + newArray.getCurrentSize());
		System.out.println("The new stats are: ");
		System.out.println("-----------------");
		System.out.println(newArray);
		// Testing toFile and fromFile

		System.out.print("Enter the file Name to store the array: ");
		fName = scan.next();
		try {
			newArray.toFile(fName);
			System.out.println("File is written. Good bye");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nERROR: File cannot be opened");

		}
		System.out.println("Scores from File");
		System.out.println("----------------");
		
		try{
		    
	       newArray.fromFile(fName);
		   newArray.display();
		}
		catch(IOException e)
                {
		    System.out.println("\nERROR: File cannot be opened");
		}

	}

}

