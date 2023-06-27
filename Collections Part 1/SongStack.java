package com.mycompany.funwithcollections;
/**
 * Title: A Stack of songs like the good old days of 45's! 
 * Desc:  You have no idea how cool it was to have 10 45's 
 *        stacked up on your record player so they would 
 *        play one after another.
 * @author jg
 */
public class SongStack 
{
    Song[] songs; // Stack of songs 
    private int count; // Encapsulation
    private int initialSize;
    
    public SongStack()
    {
//        songs = new Song[10];
//        count = 0;
          this(10); // Call the other constructor
          
    }
    
    public SongStack(int count)
    {
        songs = new Song[count];
        this.count = 0;
        this.initialSize = count;
    }
    
    
    // Push is cool, but has a problem
    public void push(Song newby)
    {
        if(count == songs.length)
        {
            growStack();
        }
        
        songs[count] = newby;
        count++;
    }
    
    /**
     * A private method that increases a new stack making 
     * the song Stack larger
     * 
     * @return 
     */
    
    private void growStack()
    {
        // New Stack 
        Song[] newStack = new Song[count + initialSize];
        for(int i = 0; i < count; i++)
        {
            newStack[i] = songs[i];
        }
        // Replase the old with the new
        songs = newStack; 
    }
    
    // methods should not return null
    public Song pop() throws StackEmptyException
    {
        Song song;
        if(count == 0)
        {
            throw new StackEmptyException("Reload the disks!!!");
        }
//        if(count >= 0)
//        {
//            song = songs[count]; // 
//            //count--;  <- Do not decrement
//            return song;
//        }
        song = songs[count - 1];
        return song;
    }
    
    // Should this return null?
    // Needs Try Catch now
    public Song peek() throws StackEmptyException
    {
        if(count == 0)
        {
            throw new StackEmptyException("Reload the disks.");
        }
        Song song; 
        if(count >= 0)
        {
            song = songs[count - 1];
            return song; 
        }
        return null;
    }
    
    public boolean isEmpty()
    {
        return true;
    }
    
    public int size()
    {
        return this.count;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        for(int i = count - 1; i >= 0; i--)
        {
            str += songs[i].getTitle() + "\n";
        }
        return str;
    }
    
}
