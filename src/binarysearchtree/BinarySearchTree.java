package binarysearchtree;

public class BinarySearchTree 
{

    Node root;

    public BinarySearchTree() {
    }
    
    
    public static void main(String[] args) 
    {
        
    }
    
//    public Node getKey(int key)
//    {
//         
//    }
    
//    public boolean containsKey(int key)
//    {
//        
//    }
    
    public int size(Node node)
    {
        if(node == null)
            return 0;
        else {
            return (size(node.leftC) + 1 + size(node.rightC));
        }
    }
    
    public void put(Node keys)
    {
        
    }
}
