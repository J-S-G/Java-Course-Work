package bst;

/**
 * Desc: Create a simple Queue that holds a Queue of Nodes
 * @author jg
 */
public class TreeNodeQueue 
{
    private QueueNode front = null, rear = null;
    
    public void enQueue(Node newby)
    {
        QueueNode newNode = new QueueNode(newby);
        
        if(front == null)
        {
            front = rear = newNode; 
        }
        else
        {
            rear.next = newNode; 
            rear = newNode; 
        }
    }
    
    public Node deQueue()
    {
        if(front == null)
        {
            return null;
        }
        else
        {
            Node returnNode = front.data;
            front = front.next; 
            return returnNode; 
        }
    }
    
    public boolean isEmpty()
    {
        return (front == null);
    }
    
    class QueueNode
    {

        Node data; 
        QueueNode next;
        
        public QueueNode(Node newby) 
        {
            data = newby;
            next = null;
        }
    }
}
