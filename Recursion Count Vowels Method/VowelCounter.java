package vowelcounter;

import java.util.*;
/**
 * Desc:   Count the vowels in a given string input
 * @author jg
 */
public class VowelCounter 
{
    // Write a recursive method that returns the number of vowels in a string
    // This is your activity
    public static int countVowels(String str) 
    {
        // Local variable for storing the number of vowels initialized with 0
        int vowelNum = 0;
        // iterate through each string character depending on length
        for(int i = 0; i < str.length(); i++)
        {
            // charater type variable for checking ea. index of the string 
            char c = str.charAt(i);
            
            //If input is null the vowel number is zero
            if(str.isBlank())
            {
                break;
            }
            // The input string vowels will be checked for ea. 
            // index of the string 
            else if(c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c =='u')
            {
                // Ea. index that contains a vowel will increment the vowelnum
                // by 1
                 vowelNum++;
            }
        }
        // The count vowels method returns an integer variable vowelNum 
        // This is the total integer amount of vowels in a string input 
        return vowelNum;
    }
}
