package funwithtrees;

/**
 * Desc:   Let's store our States in a Tree structure
 * @author jg
 */
public class StateTree 
{
    private Node root; 
    private int count;
    
    public StateTree()
    {
        root = null; 
        count = 0;
    }
}

class Node
{
    State state; 
    Node left; 
    Node right; 
    
    public Node(State state)
    {
        left = right = null; 
        this.state = state;
    }
}