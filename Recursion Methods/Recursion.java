package module11;

/**
 * Utility class for recursive methods.
 */
public class Recursion {

    /**
     * Recursive factorial function.
     *
     * @param n n
     * @return nth factorial
     */
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    /**
     * Recursive fibonacci function.
     * @param n n
     * @return nth fibonacci
     */
    public static int fib(int n) 
    {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    /**
     * Recursive greatest common denominator (GCD) function.
     *
     * @param a a
     * @param b b
     * @return gcd(a,b)
     */
    public static int gcd(int a, int b) 
    {
        if (b == 0) 
        {
            return a;
        }
        
        else 
        {
            return gcd(b, a % b);
        }
    }


}
