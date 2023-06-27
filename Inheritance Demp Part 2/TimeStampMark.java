package sis;

/**
 * Title: TimeStampMark 
 * Desc:  ensures the class keeps track of when it is updated.
 * @author jg
 */
public interface TimeStampMark 
{
//    // We can create constants in an interface.
//    public final int MAX_TIME = 24;
    
    /**
     * setTimeStamp should record the system time when called
     */
    public void setTimeStamp();
    /**
     * getTimeStamp returns a string representation of the last time
     * the person was updated 
     * @return
     */
    
}
