package funwithcollections;

/**
 * Desc:  SongLibrary List using a Doubly Linked List 
 * @author jg
 */

public class SongsLibraryDLL  extends SongQueueLL
{
    private Node front;
    private Node rear;
    private Node cursor;
    private int count;

    public SongsLibraryDLL() {
        front = rear = cursor = null;
        count = 0;
    }

    public void addToFront(Song song) {
        Node newNode = new Node(song);
        if (count == 0) {
            front = rear = cursor = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
            count++;
        }
    }

    public void addToRear(Song song) {
        Node newNode = new Node(song);
        if (count == 0) {
            front = rear = cursor = newNode;
        } 
        else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
            count++;
        }
    }

    /**
     * Adds a song after the current cursor
     * @param song 
     */
    public void addAfter(Song song) {
        if (count == 0) 
        {
            addToFront(song);
        } 
        else if (cursor == rear) 
        {
            addToRear(song);
        } 
        else 
        {
            Node newNode = new Node(song);
            newNode.prev = cursor;
            newNode.next = cursor.next;
            cursor.next.prev = newNode;
            cursor.next = newNode;
            cursor = newNode;
            count++;
        }
    }

    public Song first() throws EmptyPlayListException {
        if (count == 0) {
            throw new EmptyPlayListException("No songs for you");
        }else{
        cursor = front;
        return front.song;
        }
    }

    public Song last() throws EmptyPlayListException {
        if (count == 0) {
            throw new EmptyPlayListException("No songs for you");
        }else{
        cursor = rear;
        return rear.song;
        }
    }

    public Song currentSong() throws EmptyPlayListException {
        if (count == 0) {
            throw new EmptyPlayListException("No songs for you");
        }
        return cursor.song;
    }

    public Song getNext() throws EmptyPlayListException {
        if (count == 0) {
            throw new EmptyPlayListException("No songs for you");
        } else if (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor.song;
    }

    public Song getPrev() throws EmptyPlayListException {
        if (count == 0) {
            throw new EmptyPlayListException("No songs for you");
        } else if (cursor.prev != null) {
            cursor = cursor.prev;
        }
        return cursor.song;
    }

    /**
     * Delete the current
     * Delete the first -> the last -> the only and internal node
     */
    public void deleteCurrent() throws EmptyPlayListException 
    {
        if (count == 0) 
        {
            throw new EmptyPlayListException("No Songs for you");
        } 
        else if (count == 1) 
        { // Only one song in the list
            front = rear = cursor = null;
            count = 0;
        } 
        else if (cursor == front) 
        { // Delete the first node
            deleteFront();
        } 
        else if (cursor == rear) 
        { // Delete the last node
            deleteRear();
        } 
        else 
        { 
            // Delete an internal node
            // The varable cursor.pre.next needs to be updated
            cursor.prev.next = cursor.next;
            cursor.prev.next = cursor.prev;
            cursor = cursor.next;
            count--;
        }
    }
    
    /**
     * This is a helper method for now. 
     * Implement later 
     * @throws EmptyPlayListException 
     */
    private void deleteFront() throws EmptyPlayListException
    {
        front = front.next;
        cursor = cursor.next; 
        front.prev = null;
        count--;
    }
    

    /**
     * Helper method
     * Implement later DRY principles
     * @throws EmptyPlayListException 
     */
    private void deleteRear() throws EmptyPlayListException
    {
        rear = rear.prev;
        cursor = cursor.prev;
        rear.next = null;
        count--;
    }
    
    /**
     * Method to return an empty playlist boolean 
     * @return 
     * @return 
     */
    public boolean isEmpty()
    {
        return count == 0;
    }
    
    public String toString()
    {
        String songs = "";
        Node pointer = front;
        
        while(pointer != null)
        {
            songs += pointer.song.toString() + "\n";
            pointer = pointer.next;
        }
        return songs;
    }
    
    // For a linked list, we need to have a collection of 
    // nodes that are linked together via address
    class Node
    {
        Song song; 
        Node next;
        Node prev;
        
        // Constructor 
        public Node(Song song)
        {
            this.song = song; 
            this.next = null;
        }
    }
    
}