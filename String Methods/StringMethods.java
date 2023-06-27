package stringmethods;

import java.util.Random;

/**
 * Description: A bunch of random String Methods that you have to write
 *  but you can't use any built in String Methods
 * @author Joseph G
 */

public class StringMethods 
{

/**

* @param args the command line arguments

*/
f
    // Private helper method that strips out spaces and non-characters

    // from a String

    private static String charactersOnly(String str) 
    {

    String s="";

    for(int i=0;i<str.length();i++)
    {
        if((str.charAt(i)>='a' && str.charAt(i)<='z') || (str.charAt(i)>='A' && str.charAt(i)<='Z'))
        s+=str.charAt(i);
    }

    s = lowerCase(s);

    return s;

    }

    // Private helper method that checks to see if a character is a digit

    private static boolean isDigit(char c) 
    {
        if(c>='0' && c<='9')
        {
            return true;
        }
        else
        {
             return false;
        }
    }

    private static boolean isAlpha(char c) {

    if((c>='a' && c<='z') || (c>='A' && c<='Z'))

        return true;

    else

        return false;

    }

    // Private helper method that checks to see if a character is a vowell

    private static boolean isVowell(char c) 
    {

    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')

        return true;

    else

        return false;

    }

    // Private helper method that checks to see if a character is a

    // consonant

    private static boolean isConsonant(char c) {

    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')

        return false;

    else

        return true;

    }

    // Private help method that checks if two strings are equal

    private static boolean equals(String str1, String str2) {

    if(str1.length()==str2.length())

    {

    int i;

    for(i=0;i<str1.length() && str1.charAt(i)==str2.charAt(i) ;i++);

    if(i==str1.length())

        return true;

    else

        return false;

    }

    else

        return false;

    }

    /**

    * isPalindrome accepts a string and returns true if the string is a

    * palindrome, otherwise returns false; should ignore spaces, punctuation

    * and case (upper and lower are the same). So, the following ARE

    * palindromes: "Never odd or even.”, “Cigar? Toss it in a can. It is so

    * tragic.”, “A man, a plan, a canal: Panama.”

    */

    public static boolean isPalindrome(String str) {

    str=lowerCase(str);

    String s="";

    for(int i=0;i<str.length();i++)

        {

        if((str.charAt(i)>='a' && str.charAt(i)<='z')|| isDigit(str.charAt(i)))

            s+=str.charAt(i);

        }

        String r=reverse(s);

    return equals(s,r);

    }

    /**

    * reverse accepts a string and returns a string that is the reverse of the

    * original

    *

    * @param str

    * @return reversed representation of str

    */

    public static String reverse(String str) {

    String r="";

        for(int i=str.length()-1;i>=0;i--)

        r+=str.charAt(i);

    return r;

    }

    /**

    * jumble accepts a string and returns a jumbled version of the original:

    * for this method, jumbled means that two randomly chosen characters other

    * than the first and last characters of the string are swapped; this method

    * must use the class, Random (see chapter 5). Examples of what this method

    * might do: “fist” returns “fsit”, “much” returns “mcuh”

    *

    * @param str string to be jumbled

    */

    public static String jumble(String str) {

    int i = (int)(1+ (Math.random() * ( str.length() - 2 )));

    int j = (int)(1+ (Math.random() * ( str.length() - 2 )));

    System.out.println(i+" "+j);

    String s="";

    for(int k=0;k<str.length();k++) {

    if(k==i)

        s+=str.charAt(j);

    else if(k==j)

        s+=str.charAt(i);

    else

        s+=str.charAt(k);

    }

    return s;

    }

    /**

    * swapPairs accepts a string and returns a string that has adjacent pairs

    * of the original string swapped; for strings of odd length, leave the last

    * character unchanged. Examples: IN: examples OUT: xemalpse IN: count OUT:

    * ocnut

    */

    public static String swapPairs(String str) {

    String s="";

    int l=str.length();

    if(l%2==1)

    l=l-1;

    for(int i=0;i<l;)

    {

        s+=str.charAt(i+1);

        s+=str.charAt(i);

        i=i+2;

    }

    if(str.length()%2==1)

    s+=str.charAt(str.length()-1);

    return s;

    }

    /**

    * countVowels accepts a string of any characters and returns the number of

    * vowels in the string. (aeiou)

    *

    * @param str

    * @return integer count of vowels in str

    */

    public static int countVowels(String str) {

    int count=0;

    for(int i=0;i<str.length();i++)

        {

        if(isVowell(str.charAt(i)))

            count++;

        }

    return count;

    }

    /**

    * countConsonants accepts a string of any characters and returns the number

    * of consonants in the string

    *

    * @param str

    * @return integer count of consonants in str

    */

    public static int countConsonants(String str) {

    int count=0;

    for(int i=0;i<str.length();i++)

        {

            if(isConsonant(str.charAt(i)))

            count++;

        }

    return count;

    }

    /**

    * allDigits accepts a string and returns true if every character is a

    * digit, otherwise false

    *

    * @param str

    * @return true of all digits, false otherwise

    */

    public static boolean allDigits(String str) {

        for(int i=0;i<str.length();i++)

        {
            if(!isDigit(str.charAt(i)))

        return false;

        }

    return true;

    }

    /**

    * allAlpha accepts a string and returns true if every character is a letter

    * (either case), otherwise false

    *

    * @param str

    * @return true if all alpha, false otherwise

    */

    public static boolean allAlpha(String str) {

    for(int i=0;i<str.length();i++)

        {

        if(!isAlpha(str.charAt(i)))

            return false;

        }

    return true;

    }

    /**

    * stripVowels accepts a string and returns the string with no vowels.

    * Example: IN: s-cat=tered OUT: s-ct=trd

    *

    * @param str

    * @return str with no vowels to be found

    */

    public static String stripVowels(String str) {

    String s="";

    for(int i=0;i<str.length();i++)

    {

    if(isVowell(str.charAt(i)))

        continue;

        s+=str.charAt(i);

    }

    return s;

    }

    /**

    * stripConsonants accepts a string and returns the string with no

    * consonants. Example: IN: s_cat$tered OUT: _a$ee

    */

    public static String stripConsonants(String str) {

    String s="";

    for(int i=0;i<str.length();i++)

    {

        if(isConsonant(str.charAt(i)))

        continue;

        s+=str.charAt(i);

    }

        return s;

    }

    /**

    * replace accepts a string and two characters, returns the string with all

    * occurrences of char1 replaced by char2. Example: IN: mississippi, i, o

    * OUT: mossossoppo

    *

    * @param str

    * @param c1

    * @param c2

    * @return str with all instance of c1 replaced with c2

    */

    public static String replace(String str, char c1, char c2) {

    String s="";
    for(int i=0;i<str.length();i++)
    {
        char c=str.charAt(i);
            if(c==c1)

            {
                s+=c2;
            }
        else
        s+=c;
    }

    return s;

    }

    /**

    * countChar accepts a string and a character, returns the number of

    * occurences of the character in the string. Example: IN: m.is_si-ssi=pp!i,

    * i OUT: 4

    *

    * @param str

    * @param c

    * @return integer count of c in str

    */

    public static int countChar(String str, char c) {

    int count=0;

    for(int i=0;i<str.length();i++)

        {

            if(str.charAt(i)==c)

            count++;

        }

    return count;

    }

    /**

    * multiString accepts a string and returns a string with repeated

    * characters: the first character is repeated string-length times, the

    * second character is repeated one less time, until the last character is

    * included only once (not repeated). Example: IN: test OUT: tttteeesst IN:

    * sentence OUT: sssssssseeeeeeennnnnnttttteeeennncce

    *

    * @param str

    * @return revised string

    */

    public static String multiString(String str)
    {

        String s="";

        int l=str.length();

        for(int i=0;i<str.length();i++)

        {

            char c=str.charAt(i);

            for(int j=0;j<l;j++)

            s+=c;

            l--;

        }

    return s;

    }

    /**

    * lowerCase accepts a string and returns the string in all lowercase; do

    * not use the String class’s toLowerCase method, do not use the Character

    * class method either.

    *

    * @param str

    * @return str in all lower case

    */

    public static String lowerCase(String str) 
    {

        String s="";

         for(int i=0;i<str.length();i++)
        {

            char c=str.charAt(i);

        if(c>='A' && c<='Z')

        {

            c=(char)(c+32);

        }

            s+=c;

        }

        return s;

    }

    /**

    * upperCase accepts a string and returns the string in all uppercase; do

    * not use the String class’s toLowerCase method, do not use the Character

    * class method either.

    *

    * @param str

    * @return str in all upper case

    */

    public static String upperCase(String str)
    {   

        String s="";

        for(int i=0;i<str.length();i++)

            {

            char c=str.charAt(i);

            if(c>='a' && c<='z')

                {

                    c=(char)(c-32);

                }

                s+=c;

            }

            return s;

    }

    /**

    * findInStr accepts two strings and returns the character index of the

    * position where the second string begins in the first; returns -1 if the

    * second string does not appear in the first. Examples: IN: mississippi ss

    * OUT: 2 IN: superlative zzl OUT: -1

    *

    * @param s1

    * @param s2

    * @return index of s2 in s1

    */

    public static int findInStr(String s1, String s2) 
    {

        int l=s2.length();

        int index=-1;

        for(int i=0;i<(s1.length()-l);i++)

        {

            if(equals(s1.substring(i, i+l),s2))

            return i;

        }

        return index;

    }

    /**

    * findInStr is an overloaded version of previous method, accepts a string

    * and a character, returns the index of the position where the character

    * first appears in the string; returns -1 if the character does not appear

    * in the string. Examples: IN: dazzling z OUT: 2 IN: superlative z OUT: -1

    *

    * @param s1

    * @param c

    * @return

    */

    public static int findInStr(String s1, char c) 
    {

        int index=-1;

        for(int i=0;i<s1.length();i++)

        {

            if(s1.charAt(i)==c)

            return i;

        }

        return -1;

    }

    /**

    * findInStrLast accepts two strings and returns the character index of the

    * rightmost position where the second string begins in the first; returns

    * -1 if the second string does not appear in the first. Examples: IN:

    * mississippi ss OUT: 5 IN: superlative zzl OUT: -1

    *

    * @param s1

    * @param s2

    * @return

    */

    public static int findInStrLast(String s1, String s2) 
    {

        int l=s2.length();

        int index=-1;

        for(int i=0;i<(s1.length()-l);i++)

        {

            if(equals(s1.substring(i, i+l),s2))
            index= i;

        }
        return index;

    }

    /**

    * findInStrLast is an overloaded version of previous method, accepts a

    * string and a character, returns the index of the rightmost position where

    * the character first appears in the string; returns -1 if the character

    * does not appear in the string. Examples: IN: dazzling z OUT: 3 IN:

    * superlative z OUT: -1

    *

    * @param s1

    * @param c

    * @return revised String

    */

    public static int findInStrLast(String s1, char c) 
    {

        int index=-1;

        for(int i=0;i<s1.length();i++)

        {

            if(s1.charAt(i)==c)
            {
                index=i;
            }

        }

        return index;

    }

    /**

    * inOrder accepts 3 integers and returns a string containing the three

    * integers in ascending order separated by a single space between the first

    * two and another single space between the second and third. Examples: 1,

    * 2, 3 returns “1 2 3”; 199, 8, 23 returns “8 23 199” .

    *

    * @param a

    * @param b

    * @param c

    * @return String representation of numbers in order

    */

    public static String inOrder(int a, int b, int c) 
    {

        int highest = a > b && a > c ? a : b > a && b > c ? b : c;

        int lowest = a < b && a < c ? a : b < a && b < c ? b : c;

        int middle = a != highest && a != lowest ? a : b != highest && b != lowest ? b : c;

        return lowest+" "+middle+" "+highest;

    }

}