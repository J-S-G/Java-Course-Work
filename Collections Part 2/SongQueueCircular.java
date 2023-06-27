package com.mycompany.funwithcollections;

/**
 *
 * @author jg
 */
public class SongQueueCircular {
    
    private Song[] songQueue;
    private int count;
    private int front; // What index is the front 
    private int rear;  // What index is the back 
    
    // Queue operations 
        //- enqueue -> adds element to end of queue
        //- dequeue -> removes element from front of the queue
        //- first -> examines front element of queue
        //- isEmpty ->  Determines if queue is empty 
        //- size -> determines number of elements in queue
        //- toString -> returns string representation of queue
    
    public SongQueueCircular(int size)
    {
        songQueue = new Song[size];
        count = 0;
    }
    
    // Add it to the rear of the queue
    public void enQueue(Song newby)
    {
        if(count == songQueue.length)
        {
            System.out.println("Error in Circle Que");
        }
        else
        {
            songQueue[rear] = newby;
            rear = (rear + 1) % songQueue.length;
            count++;
        }
    }
    
    
    // Remove it from the rear of the Queue
    public Song deQueue() throws StackEmptyException
    {
        if(count == 0) // No songs to dequeue
        {
            throw new StackEmptyException("Queue is empty. "
                    + "No song for you!");
        }
        
        Song song = songQueue[front];
        // Wrap front around for corresponding iterations
        front = (front + 1) % songQueue.length;
        count--;
        return song; 

    }
    
    public Song front() throws StackEmptyException
    {
        if(front == rear) // No songs to dequeue
        {
            throw new StackEmptyException("Queue is empty. "
                    + "No song for you!");
        }
        Song song = songQueue[front];
        return song;
    }
    
    public boolean isEmpty()
    {
        return count == 0;
    }
    
    public int size()
    {
        return count;
    }
    
    public String toString()
    {
        String str = "";
        for(int i = front; i < rear; i++)
        {
            str += songQueue[i].getTitle() + ", ";
        }
        return str;
    }
    
}