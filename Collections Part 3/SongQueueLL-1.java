package funwithcollections1;
/**
 *
 * @author jg
 */
public class SongQueueLL 
{
    private Node front; 
    private Node rear; 
    private int count; 
    
    public SongQueueLL()
    {
        front = rear = null; 
        count = 0;
    }
    
    public void enQueue(Song song)
    {
        // Creates a new object in the heap 
        Node newNode = new Node(song); // Let's add White Rabbit 
        if(count == 0)// Our Queue is
        {
            front = rear = newNode;
            count++;
        }
        else 
        {
            // Set the "next" field of the rear to 
            // Point or link to the new node.
            rear.next = newNode; 
            // Update rear to point at the new node
            // Update count
            rear = newNode;
            count++;
        }
    }
    
    // This should throw a QueueEmptyException
    public Song deQueue() throws StackEmptyException
    {
        // Front and rear == null
        if(count == 0)
        {
            throw new StackEmptyException("Queue is empty");
        }
        else
        {
            // Get the address of the song at the front
            Song song = front.song;
            front = front.next;
            count--; 
            
            if(count == 0)
            {
                rear = null;
            }
            
            return song;
        }
    }
    
    public Song front() throws StackEmptyException
    {
        // Front and rear == null
        if(count == 0)
        {
            throw new StackEmptyException("Queue is empty");
        }
        else
        {
            return front.song;
        }
    }
    
    // Garbage Collection will automatically take care of unused 
    public void clearQueue()
    {
        front = rear = null; 
        count = 0;
    }
    
    public boolean isEmpty()
    {
        return this.count == 0;
    }
    
    public String toString()
    {
        String str = "";
        // Set a reference variable to the front of the Queue
        Node cursor = front; 
        while(cursor != null)
        {
            str += cursor.song.toString()+"\n";
            cursor = cursor.next;
        }
        return str;
    }
    
    /**
     * This is just to look at the code we wrote before Turkey Day
     * So we remember what our code looked like. 
     * Let's remove an item from our Song Queue
     * Normally this isn't allowed in a Queue. But we are writing our own 
     * @param song
     * @return true if found and removed. False otherwise
     */
    public boolean remove(Song song)
    {
        // We have to step through the Linked List to find it 
        // Once found, we need to change the links to skip it. 
        Node cursor = front; 
        Node trailer = null;
        // Iterate through the song object
       while(cursor != null && !front.song.equals(song))
       {
           trailer = cursor; 
           front = cursor.next;
       }
       if(cursor == null)
       {
           return false;
       }
       else
       {
           // We are removing the first song in the Queue
           if(cursor == front)
           {
               System.out.println("Removing the front");
               front = front.next;
               count--;
           }
           else if (cursor == rear)
           {
               System.out.println("Removing the rear");
               trailer.next = cursor.next;
               count--;
           }
           else
           {
               trailer.next = cursor.next; 
               count--;
           }
       }
       return true;
    }
    
    public int size()
    {
        return this.count;
    }
    
    // For a linked list, we need to have a collection of 
    // nodes that are linked together via address
    class Node
    {
        Song song; 
        Node next;
        
        // Constructor 
        public Node(Song song)
        {
            this.song = song; 
            this.next = null;
        }
    }
}