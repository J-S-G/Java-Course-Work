package bst;

/**
 *
 * @author jg
 */
public class BST 
{
    public Node root;
    public int nodecnt;
    public char nextdata = 'A';
    
    public BST inOrderTraversal(Node node) 
    {
        if (root == null) return this;
        if (node == null) node = root; 
        if (node.left != null)
        inOrderTraversal(node.left);
        node.visit();
        if (node.right != null)
        inOrderTraversal(node.right);
        return this;
    }
    /*
    * TBI (To Be Implemented)...
    */
    public BST preOrderTraversal(Node node) 
    {
        if (root == null) return this;
        if (node == null) node = root; 
        if (node.left != null)              // Visit the left subtree 
        preOrderTraversal(node.left);
        node.visit();
        if (node.right != null)             // Visit the right subtree
        preOrderTraversal(node.right);
        return this;
    }
    /*
    * Desc: Visit Left tree, Visit Right Tree, Visit Node 
    */
    public BST postOrderTraversal(Node node) 
    {
        if (root == null) return this;
        if (node == null) node = root; 
        if (node.left != null)              // Visit the left subtree 
        preOrderTraversal(node.left);
        node.visit();
        if (node.right != null)             // Visit the right subtree
        preOrderTraversal(node.right);
        return this;
    }
    /*
    * We built our own Queue and used it to follow the algorithm below
    */
    public BST levelOrderTraversal(Node node) 
    {
        if(node == null)
        {
            node = root;
        }
    /*
    * the algorithm...
    * + instantiate a queue
    * + enqueue root node
    * + while queue not empty
    * - node = dequeue
    * - visit node (print)
    * - enqueue node's children (left then right)
    */
        // instantiate a queue
        TreeNodeQueue tnq = new TreeNodeQueue();
        // while queue not empty
        while(!tnq.isEmpty())
        {
            Node frontNode = tnq.deQueue();
            // node = dequeue
            frontNode.visit();
            // enqueue node's children (left then right)
            if(frontNode.left != null)
            {
                tnq.enQueue(frontNode.left);
            }
            if(frontNode.right != null)
            {
                tnq.enQueue(frontNode.right);
            }
        }
        
        return this;
        
    }
    public BST insert(int key) 
    {
        if (root == null) 
        {
            root = new Node(key, null, nextdata++);
            nodecnt++;
            return this;
        }
    return insert(key, root);
    }
    
    public BST insert(int key, Node parent) 
    {
        if (key == parent.key) return this;
        nodecnt++;
        if (key < parent.key) 
        {
            if (parent.left == null) 
            {
                parent.left = new Node(key, parent, nextdata++);
                return this;
            }
        return insert(key, parent.left);
        }
        
        if (parent.right == null) 
        {
            parent.right = new Node(key, parent, nextdata++);
            return this;
        }
        return insert(key, parent.right);
    }
    /*
    * TBI (To Be Implemented)...
    */
    public BST delete(int key) 
    {
    /*
    * three cases: node being deleted has zero kids; node being
    * deleted has one child; node being deleted has two children
    */
        // First step: find the key to see if it needs to be deleted
        Node deadNode = find(key);
        //
        if(deadNode == null)
        {
            return this;
        }
        // Both the left and parent node are null
        if(deadNode.left == null && deadNode.right == null)
        {
            deleteLeaf(deadNode);
            return this;
        }
        else if(deadNode.left == null || deadNode.right == null)
        {
            deleteSingleParent(deadNode);
            return this;
        }
        else
        {
            deleteInnerNode(deadNode);
            return this;
        }
        
    //return this;
    }
    
    // Helper method that returns true if the node is a Left child
    private boolean isLeftChild(Node n)
    {
        if(n.parent.left == n)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void deleteLeaf(Node deadNode)
    {
        if(deadNode == root)
        {
            // Simply kill the tree
            root = null;
            
        }
        
        // Delete the the node is a left child
        else if(isLeftChild(deadNode))
        {
            // delete the link from the parent to their left child
            deadNode.parent.left = null;
        }
        else
        {
            deadNode.parent.right = null;
        }
    }
    
    private void deleteSingleParent(Node deadNode)
    {
        // When deleting, delete the root, because it has no parent
        if(deadNode == root)
        {
            if(root.left != null)
            {
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        // The deadNode is a left child 
        else if(isLeftChild(deadNode))
        {
            // The deadNode has a left child
            if(deadNode.left != null)
            {
                // Set the parent to point at the left child of the deadNode
                deadNode.parent.left = deadNode.left;
            }
            // The parent points at the right child of the deadNode
            else
            {
                deadNode.parent.left = deadNode.right;
            }
        }
        else
        {
            // The deadNode has a left child
            if(deadNode.left != null)
            {
                // Set the parent to point at the left child of the deadNode
                deadNode.parent.right = deadNode.left;
            }
            // The parent points at the right child of the deadNode
            else
            {
                deadNode.parent.right = deadNode.right;
            }
        }
    }
    
    /**
     * Desc: If the node has 2 children, we have to find a replacement
     * @param deadNode 
     */
    private void deleteInnerNode(Node deadNode)
    {
        // Find the next smallest Node in the list
        // One step to left and then all the way to the right
        // We could find the next largest in the list
        
        // We know there are two children. So let's use the min method
        Node minNode = min(deadNode.left);
        
        // It will either be a leaf or a node with one parent
        deadNode.data = minNode.data;
        
        // Making minNode the deadNode
        deadNode.key = minNode.key;
        
        if(minNode.left == null && minNode.right == null)
        {
            deleteLeaf(minNode);
        }
        else
        {
            deleteSingleParent(minNode);
        }
    }
    
    public Node find(int key) 
    {
        if (root == null) return null;
        return find(key, root);
    }
    /*
    * This is passed the root or subroot and the key to search for. 
    * We are going to do it using recursion.
    */
    public Node find(int key, Node n) 
    {
        if(n == null)
        {
            return n; // Key not found
        }
        else if(key == n.key)
        {
            return n; // Key found
        }
        else if(key < n.key)
        {
            return find(key, n.left);
        }
        else
        {
            // Recursive search of the right subtree
            return find(key, n.right);
        }
        //return n; // <-- and this statement needs to be changed
    }
    /*
    * This is past the root of our tree (or subtree)
    * To find the min, we just go as far to the left as possible
    */
    public Node min(Node n) 
    {
        while(n.left != null)
        {
            n = n.left;
        }
        return n; // <-- and this statement needs to be changed
    }
    
    /*
    * To find the max of a subtree, then traverse as far to the right
    * as possible
    */
    public Node max(Node n) 
    {
        while( n.right != null)
        {
            n = n.right;
        }
        return n; // <-- and this statement needs to be changed
    }
    /*
    * BST.main(String[] argv) is used to test class BST
    */
    public static void main(String[] argv) 
    {
        int[] a = { 30, 20, 40, 18, 25, 24, 27, 23, 21, 22, 29, 35, 42 };
        
        // testing delete...
        for (int i = 0; i < a.length; i++)
        delete(init(a), a[i]);
        
        // testing min and max...
        BST tree = init(a);
        System.out.println("min = " + tree.min(tree.root).key +
        "; max = " + tree.max(tree.root).key);
        // testing find...
        
        int[] f = { a[0], a[a.length-1], 205, a[a.length/2] };
        for (int i = 0; i < f.length; i++)
        System.out.println("find(" + f[i] + "): " +
        ((tree.find(f[i]) == null) ? "not found" : "found"));
        
        // testing level-order traversal...
        System.out.println("\nlevel-order traversal:");
        tree.levelOrderTraversal(null);
        
        // testing deleting/traversal small trees (1, 2, 3 nodes)...
        deleteSmallTrees();
    }
    
    static BST init(int[] a) 
    {
        BST tree = new BST();
        System.out.print("\ninputs: ");
        for (int i = 0; i < a.length; i++) {
        tree.insert(a[i]);
        System.out.print(a[i] + " ");
        }
        System.out.println();
        return tree;
    }
    
    static void delete(BST tree, int key) 
    {
        tree.preOrderTraversal(null);
        System.out.println("\ndelete(" + key + ")...");
        tree.delete(key);
        tree.preOrderTraversal(null);
    }
    
    static void deleteSmallTrees() 
    {
        BST t = new BST();
        System.out.println("\ninputs: 10");
        t.insert(10);
        t.levelOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        if (t.root != null) {
        System.out.println("\t??? there should be no traversal");
        t.levelOrderTraversal(null);
        } else
        System.out.println("\tempty tree (no traversal)");
        t = new BST();
        System.out.println("\ninputs: 10 5");
        t.insert(10);
        t.insert(5);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);
        t = new BST();
        System.out.println("\ninputs: 10 15");
        t.insert(10);
        t.insert(15);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);
        t = new BST();
        System.out.println("\ninputs: 10 15 5");
        t.insert(10);
        t.insert(15);
        t.insert(5);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);
    }
    static void printTraversals(BST tree) 
    {
        System.out.println("\nin-order:");
        tree.inOrderTraversal(null);
        System.out.println("\npre-order traversal:");
        tree.preOrderTraversal(null);
        System.out.println("\npost-order traversal:");
        tree.postOrderTraversal(null);
        System.out.println("\nlevel-order traversal:");
        tree.levelOrderTraversal(null);
    }
}

class Node 
{
    public int key;
    public char data;
    public Node parent;
    public Node left;
    public Node right;
    
    public Node(int k, Node p, char d) 
    {
        this(k, p, d, null, null);
    }
    
    public Node(int k, Node p, char d, Node l, Node r) 
    {
        key = k;
        parent = p;
        data = d;
        right = r;
        left = l;
    }
    
    public void visit() 
    {
        System.out.print("\t" + key);
        if (parent == null)
        System.out.print(" (root node)");
        else
        System.out.print(" (parent: " + parent.key + ")");
        System.out.print(" left: ");
        if (left == null) System.out.print("na");
        else System.out.print(left.key);
        System.out.print("; right: ");
        if (right == null) System.out.print("na");
        else System.out.print(right.key);
        System.out.println("; " + data);
    }
}