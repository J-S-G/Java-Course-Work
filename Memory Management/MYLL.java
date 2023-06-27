package arraysandarraylists;

/**
 * Implement a linked list to replace the Array and Array List
 * Test to see if linked lists are faster than arrays
 * @author jg
 */
public class MYLL 
{
    // Pointers
    private Node front; 
    private Node rear;
    private int count;
    private long actions = 0;
    
    // Inner Class that is only visible in MYLL
    public MYLL()       
    {
        front = rear = null; 
        count = 0;
    }
    
    public void clear()
    {
        front = rear = null; 
        count = 0;
    }
    
    public long getActions()
    {
        return actions;
    }
    
    public void clearActions()
    {
        actions = 0;
    }
    
    public void add(int num)
    {
        Node newNode = new Node(num); // Create a new node
        if(count == 0)
        {
            front = newNode;
            rear = newNode; 
            count++;
        }
        else
        {
            rear.next = newNode; 
            rear = newNode; 
            count++;
        }
        actions += 3;
    }
    
    public void add (int loc, int num)
    {
        Node newNode = new Node(num);
       if(loc == 0)
       {
           newNode.next = front;
           front = newNode; 
           count++;
       } 
    }
    
    // We will handle removing internal nodes later
    public void remove(int loc)
    {
        if(loc == 0) // Condition that checks if the front node is deleted. Just move front to the next one
        {
            front = front.next;
            count--;
        }
        actions += 3;
    }

    // Slower than array
    public void set(int loc, int val)
    {
        Node pointer = front;
        for(int i = 0; i < loc; i++)
        {
            actions++;
            pointer = pointer.next;
        }
        pointer.data = val;
        actions+=1;
    }
    
    /**
     * Gives us a string representation of our list
     * @return 
     */
    public String toString()
    {
        String str = "";
        Node pointer = front;
        while(pointer != null)
        {
            str += pointer.data + " ";
            pointer = pointer.next;     // Update pointer to the next node
        }
        return str;
    }
    
    // Inner Class only visible in MYLL class
    class Node
    {
        int data; 
        Node next;
    
        // This is our constructor. Creates a node with an int value
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
}