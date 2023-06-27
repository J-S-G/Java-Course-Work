package funwithcollections1;
import org.w3c.dom.Node;

/**
 * Desc:  SongLibrary List using a Doubly Linked List 
 * @author jg
 */
class SongsLibraryDLL
{
    private Node front; 
    private Node rear;
    private Node cursor; 
    private int count; 
    
    public SongsLibraryDLL()
    {
        front = rear = cursor = null;
        count = 0;
    }
    
    public void addToFront(Song song)
    {
        Node newNode = new Node(song) {};
        if(count == 0)
        {
            front = rear = cursor = newNode;
            count++;
        }
        else
        {
            newNode.next = front; 
            front.prev = newNode; 
            count++;
        }
    }
    
    public void addToRear(Song song)
    {
        Node newNode = new Node(song) {};
        if(count == 0)
        {
            front = rear = cursor = newNode; 
            count++;
        }
        else
        {
            newNode.next = rear;
            rear.next = newNode; 
            front = newNode; 
            rear = newNode;
            cursor = newNode; 
            count++;
        }
    }
    
    public void addAfter(Song song)
    {
        if(count == 0)
        {
            addToFront(song);
        }
        else if(cursor == rear)
        {
            addToRear(song);
        }
        else
        {
            Node newNode = new Node(song);
            newNode.prev = cursor; 
            newNode.next = cursor.next;
        }
    }
    
    public Song first() throws EmptyPlayListException
    {
        if(count == 0)
            throw new EmptyPlayListException("No songs for you");
        else
            return rear.song;
    }
    
    public Song last() throws EmptyPlayListException
    {
        if(count == 0)
            throw new EmptyPlayListException("No songs for you");
        else
            cursor = rear;
            return rear.song;
    }
        
    public Song currentSong() throws EmptyPlayListException
    {
        if(count == 0)
            throw new EmptyPlayListException("No songs for you");
        else
            return cursor.song;
    }
    
    public Song getNext() throws EmptyPlayListException
    {
        if(count == 0)
            throw new EmptyPlayListException("No songs for you");
        else if(cursor.next != null)
        {
            return cursor.next;
        }
        return cursor.song;
    }
    
    public Song getPrev() throws EmptyPlayListException
    {
        if(count == 0)
            throw new EmptyPlayListException("No songs for you");
        else if(cursor.prev != null)
        {
            return cursor.prev;
        }
    }
    
} 

    Class Node
    {
        Song song; 
        Node next; 
        Node prev;
        
        public Node(Song song)
        {
            this.song = song;
            this.next = this.prev == null;
        }
    }