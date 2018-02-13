package binarysearchtree;

public class BinarySearchTree 
{

    Node root;

    public BinarySearchTree() {
    }
    
    
    public static void main(String[] args) 
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10, "A");
        bst.put(15, "B");
        bst.put(5, "C");
        bst.put(20, "D");
        bst.put(1, "E");
        bst.Print(bst.root);
        
    }
    
//    public Node getKey(int key)
//    {
//         
//    }
    
//    public boolean containsKey(int key)
//    {
//        
//    }
    
    private void put(int key, String name, Node node)
    {   
        if(key == node.key)
        {
            node.name = name;
            return;
        } 

        if(key < node.key)
        {
            if(node.leftC == null)
            {
                node.leftC = new Node(key, name);
                return;
            }
            put(key, name, node.leftC);
        }

        //do the opposite
        if(key > node.key)
        {
            if(node.rightC == null)
            {
                node.rightC = new Node(key, name);
                return;
            }
            put(key, name, node.rightC);
        }
    }


    
    public void put(int key, String name)
    {
        
        if(root == null)
        {
            //Make new root
            root = new Node(key, name);
            return;
        }
        
        put(key, name, root);
       
    }
    
    public void Print(Node node)
    {
        if(node != null)
        {
            System.out.println(node);
            Print(node.leftC);
            Print(node.rightC);
        }
    }
    
    public int size(Node node)
    {
        if(node == null)
            return 0;
        else {
            return (size(node.leftC) + 1 + size(node.rightC));
        }
    }
}
