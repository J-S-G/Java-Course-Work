Note that all the variables that need to be identified are bold and in red.

import java.util.Scanner;

public class LabProgram {
   
   public static int stackHeight = 0;
   public static int digitCount(int n) {
      int returnVal;
      stackHeight++;
      // Base case
      if (n < 10) {
         returnVal = 1;
         stackHeight--;          // Memory Dump
         return returnVal;
      }
      else {
         returnVal = 1 + digitCount(n / 10); // Divide input by 10 and gain 1 digit.
         stackHeight--;
         return returnVal;
      }
   }
   
   public static void main(String[] args) {
      stackHeight++;
      Scanner scnr = new Scanner(System.in);
      int num, digits;
      
      num = scnr.nextInt();  // Assume user types in 123
      digits = digitCount(num);
      System.out.println(digits);
   }
}
