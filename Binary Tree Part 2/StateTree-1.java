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

    /**
     * Adds a new node to the tree in the appropriate place
     * @param newState 
     */
    public void addElement(State newState)
    {
        Node newNode = new Node(newState);
        if(root == null)
        {
            root = newNode; 
            count++;
        }
        else
        {
            addElement(newNode, root);
        }
        count++;
    }

    public void addElement(Node newNode, Node subRoot)
    {
        // It needs to go to the left
        if(newNode.state.compareTo(subRoot.state) < 0)
        {
            // Add it to the left 
            if(subRoot.left == null)
            {
                subRoot.left = newNode;
                newNode.parent = subRoot;
            }
            else
            {
                addElement(newNode, subRoot.left);
            }
        }
        // It needs to go to the right
        else
        {
            // There is no Node to the right. Put it there
            if(subRoot.right == null)
            {
                subRoot.right = newNode;
                newNode.parent = subRoot;
            }
            else
            {
                // Else recursively call addElement
                addElement(newNode, subRoot.right);
            }
        }
    }
    
    /**
     *  inOrderTraversal is 
     *  traverse the Left Subtree
     *  visit the Node 
     *  traverse the Right Subtree
     */
    public void inOrderTraversal()
    {
        if(root == null)
        {
            System.out.println("No states to Traverse, we must be in Canada!");
        }
        else
        {
            inOrderTraversal(root);
        }
    }
    
    public void inOrderTraversal(Node subRoot)
    {
        if(subRoot != null)
        {
            //Left Subtree
            inOrderTraversal(subRoot.left);

            // Visit
            System.out.println(subRoot.state);

            // Right Subtree
            inOrderTraversal(subRoot.right);
        }
    }
    
        /**
     *  preOrderTraversal is 
     *  visit the Node 
     *  traverse the Left Subtree
     *  traverse the Right Subtree
     */
    public void preOrderTraversal()
    {
        if(root == null)
        {
            System.out.println("No states to Traverse, we must be in Canada!");
        }
        else
        {
            preOrderTraversal(root);
        }
    }
    
    public void preOrderTraversal(Node subRoot)
    {
        if(subRoot != null)
        {
            // Visit
            System.out.println(subRoot.state);
            // Left Subtree
            preOrderTraversal(subRoot.left);
            // Right Subtree
            preOrderTraversal(subRoot.right);
        }
    }
    
        /**
     *  pstOrderTraversal is 
     *  traverse the Left Subtree
     *  traverse the Right Subtree
     *  visit the Node 
     */
    public void postOrderTraversal()
    {
        if(root == null)
        {
            System.out.println("No states to Traverse, we must be in Canada!");
        }
        else
        {
            postOrderTraversal(root);
        }
    }
    
    public void postOrderTraversal(Node subRoot)
    {
        if(subRoot != null)
        {
            //Left Subtree
            postOrderTraversal(subRoot.left);

            // Right Subtree
            postOrderTraversal(subRoot.right);
            
            // Visit
            System.out.println(subRoot.state);
        }
    }
    
    public State findMin() throws EmptyTreeException
    {
        State minState; 
        Node subRoot; 
        
        if(root == null)
        {
            throw new EmptyTreeException("Canada");           
        }
        else
        {
            subRoot = root;
            while(subRoot.left != null)
            {
                subRoot = subRoot.left;
            }
            return subRoot.state;
        }
    }
    
    public State findMax() throws EmptyTreeException
    {
        State minState; 
        Node subRoot; 
        
        if(root == null)
        {
            throw new EmptyTreeException("Canada");           
        }
        else
        {
            subRoot = root;
            while(subRoot.right != null)
            {
                subRoot = subRoot.right;
            }
            return subRoot.state;
        }
    }
    
    public State findState(String name) throws EmptyTreeException
    {
        if(root == null)
        {
            throw new EmptyTreeException("No States Around");
        }
        else
        {
            return findState(name, root);
        }
    }
    
    public State findState(String name, Node subRoot)
    {
        // If State not found, return null. 
        // Should we return a different exception? 
        if(subRoot == null)
        {
            return null;
        }
        
        int cmp = subRoot.state.getStateName().compareTo(name);
        if(cmp == 0)
        {
            return subRoot.state;
        }
        // Search the left subtree
        else if(cmp < 0)
        {
            return findState(name, subRoot.left);
        }
        // Search the right subtree
        else
        {
            return findState(name, subRoot.right);
        }
    }
}

class Node
{
    State state; 
    Node left; 
    Node right; 
    Node parent;
    
    public Node(State state)
    {
        left = right = parent = null; 
        this.state = state;
    }
}