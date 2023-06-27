package funwithexceptions;



/**
 * Title:  FunWithExceptions
 * Desc:   Do we ignore it and let the program die an ugly death
 *         Do we catch it and deal with it ourselves 
 *         Do we pass the buck and throw it back at the calling method.
 *         Finally, there is a finally.
 * @author Joseph Gibson
 */
public class FunWithExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int n = -1;
        
        try
        {
            blowItUp(n);
        }
        catch(NoNegativeException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e + " --- That didn't work");
        }
        //blowItUp(n);
    }
    
    public static void blowItUp(int n) throws NoNegativeException, Exception
    {
        if(n < 0)
        {
            // No being negative for you 
            throw new NoNegativeException("No being negative");
            
        }
        else if( n == 0)
        {
            // No blow it up for you 
            throw new ArithmeticException("No dividing by zero for you");
            
        }
        else if(n == 86)
        {
            throw new Exception("No more fish for you. All Gone!");
        }
        else
        {
            // Ok, here is you answer + 4/n
            System.out.println("Here's your answer : " + 4/n);
        }        
        
    }
    
//    public static void countDown(int num)
//    {
//        if(num == 0)
//        {
//            try {
//                    blowItUp(num);
//                }
//                catch(ArithmeticException e)
//                {
//                    // Explicitly throwing an exception
//                    System.out.println(e.toString() + " Yikes");
//                }
//            }
//        else
//        {
//            try
//            {
//                Thread.sleep(1000);
//                System.out.println(num);
//                countDown(--num);
//                //System.out.println(num); // Curious! -> Recursion
//            }
//            catch(InterruptedException e)
//            {
//                System.out.println("Zzz");
//            }
//        }
//    }
//    
//    // This is pass the buck. We want to throw the issue back to the calling
//    // method
//    public static void blowItUp(int n) throws ArithmeticException
//    {
//        if(n == 0)
//        {
//            throw new Exception("No divide by zero for you!");    
//        }
//        System.out.println(5/n);
//    }
//    // Dealing with it. We are going to try and catch our own issues. 
//    // I wanto to make sure you see it in a method.
//    public static void blowItUp2(int n)
//    {
//        try
//        {
//            System.out.println(5/n); // This is hoping nothing goes wrong.
//        }
//        catch(ArithmeticException e)
//        {
//            System.out.println("Nice try Gonzo. No cookie for you.");
//        }
//        finally
//        {
//            System.out.println("Let's count backwards");
//        }
//    }
    
}
