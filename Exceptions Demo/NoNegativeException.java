package funwithexceptions;

/**
 * Desc:   This is our own personal fancy Exception 
 * @author Joseph Gibson
 */
public class NoNegativeException extends Exception
{
    /**
     * Constructs an instance of <code>NoNegativeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoNegativeException(String msg) 
    {
        super(msg + " No Negatives!");
    }
}
