package com.mycompany.funwithstrings;
import java.util.Scanner;
import java.lang.*;
/**
 * Desc: Review on Strings
 * @author Joseph G.
 */

public class FunWIthStrings {

    public static void main(String[] args) 
    {
        // Strings are immutable
        // Strings are an array 
        // We have to use String Methods to do so!!
        
        Scanner stdin = new Scanner(System.in);
        
        
        String str1 = "Hello World";
        System.out.println(str1);
        str1 = str1.toUpperCase();
        
        System.out.print(str1);
        
        String str2 = " This is a sentence with a lot of vowels";
        
        str2 = killVowels(str2);
        System.out.println(str2);
        
        // Write a method that replaces a character with a String
        // throughout the String
        // abcdefabcdefabcdef - return: c with nerd
        String str3 = "I am a X, you are an X, we are all X's";
        str3 = corruptStr(str3, 'X', "nerd");
        System.out.println(str3);
        
        // Last String Example
        String words = "bignerd, fastnerd, loudnerd, chickennerd, wentnerd, tonerd, schoolnerd";
        System.out.println("What is the delimiter of the file");
        String delim = stdin.nextLine();
        String wordsArray[] = words.split(delim);
        //String wordsArray[] = words.split(" "); // split is a life saver
        for (String s: wordsArray) // Enhanced For Loop
        {
            System.out.println(s.trim()); // Get rid of white space.
        }
    }
    
    /**
     * Replaces each instance of c in the String str with the String newStr
     * @param str the original string
     * @param c the character to replace c with 
     * @param newStr the string to replace c with 
     * @return the updated String
     */
    public static String corruptStr(String str, char c, String newStr)
    {
        String returnStr = "";
        int index = str.indexOf(str,c); // Go ahead and find the first one
        
        if(index == -1)
        {
            return str;
        }
        else
        {
            while (index != -1)
            {
                returnStr += str.substring(0,index) + newStr; // "ab" + "nerd"
                str = str.substring(index); // I want ot chop off the ab and the c
                index = str.indexOf(str,c); // See if there is another one
            }
        }  
    // One more thing 
    returnStr += str;
    return returnStr;
    }
    
    public static String killVowels(String str)
    {
        // We have to create a new one
        String newStr = "";
        String vowels = "aeiou";
        
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            int index = vowels.indexOf(c);
            if(index == -1)
            {
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }
    
}
