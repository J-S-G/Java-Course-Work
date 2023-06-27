package com.mycompany.funwithcollections;

/**
 * Desc:   StackEmptyException is used in our SongStack Class
 * @author jg
 */
public class StackEmptyException extends Exception
{
    /**
     * Creates a new instance of <code>StackEmptyException</code> 
     * without detail message.
     */
    public StackEmptyException()
    {
        
    }
    
    /**
     * Constructs an instance of <code>StackEmptyException</code> with the 
     * specified detail message
     * 
     * @param msg the detail message
     */
    public StackEmptyException(String msg)
    {
        super(msg);
    }
    
    
    
}
