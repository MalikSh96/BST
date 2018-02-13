package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    Node root;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10, "A");
        bst.put(15, "B");
        bst.put(5, "C");
        bst.put(20, "D");
        bst.put(1, "E");
        bst.put(11, "M");
        bst.put(29, "O");
        bst.removeNode(29);
        bst.keys(bst.list, bst.root);
        System.out.println(bst.size(bst.root));
        System.out.println(bst.get(11, bst.root));
        System.out.println("Key 11: " + bst.containsKey(11, bst.root));
        System.out.println("Key 29: "+ bst.containsKey(29, bst.root));
    }
    
    public String get(int key)
    {
        Node node = get(key, root);        
        return node == null ? null : node.name;
    }

    public Node get(int key, Node node) 
    {
        Node getNode = null;
        if (node == null) return null;
        if(node.key == key) return node;
        if(node.leftC != null) getNode = get(key, node.leftC);
        if (getNode == null) getNode = get(key, node.rightC);
        return getNode;
    }
    

    public boolean containsKey(int key, Node node)
    {
        if(node == null) return false;
        if(node.key == key) return true;
        if(get(key, node.leftC) != null) {return true;}
        else if(get(key, node.rightC) != null) {return true;}
     return false;   
    }
    
    
    private void put(int key, String name, Node node) 
    {
        if (key == node.key) 
        {
            node.name = name;
            return;
        }

        if (key < node.key) 
        {
            if (node.leftC == null) 
            {
                node.leftC = new Node(key, name);
                return;
            }
            put(key, name, node.leftC);
        }

        //do the opposite
        if (key > node.key) 
        {
            if (node.rightC == null) 
            {
                node.rightC = new Node(key, name);
                return;
            }
            put(key, name, node.rightC);
        }
    }

    public void put(int key, String name) 
    {
        if (root == null) 
        {
            //Make new root
            root = new Node(key, name);
            return;
        }
        put(key, name, root);
    }
    
    public boolean removeNode(int key)
    {
        Node focusNode = root; //node to focus on
        Node parent = root; //so we ie start at the top of the bst, when analyzing how to move different keys
        
        boolean isItLeftC = true;
        
        while(focusNode.key != key)
        {
            //set parent to focus node
            parent = focusNode;
            //deciding if we need to search to the left
            if(key < focusNode.key)
            {
                isItLeftC = true;
                //Shift focus node to left
                focusNode = focusNode.leftC;
            }
            //If not it is a left
            else
            {
                isItLeftC = false;
                focusNode = focusNode.rightC;
            }
            //if there wasn't any node
            if(focusNode == null)
            {
                return false;
            }
        }
        
        //if node have no children
        if(focusNode.leftC == null && focusNode.rightC == null)
        {
            if(focusNode == root)
            {
                root = null; //because there is nothing else to change
            }
            //if it was marked as a leftC of the parent, we delete it and its parent
            else if(isItLeftC)
            {
                parent.leftC = null; //deletes it
            }
            else
            {
                parent.rightC = null;
            }
        }
        //If there is no rightChild
        else if(focusNode.rightC == null)
        {
            if(focusNode == root)
            {
                root = focusNode.leftC;
            }
            else if(isItLeftC)
            {
                parent.leftC = focusNode.leftC;
            }
            else
            {
                parent.rightC = focusNode.leftC;
            }
        }
        //If there is no leftChild
        else if(focusNode.leftC == null)
        {
            if(focusNode == root)
            {
                root = focusNode.rightC;
            }
            else if(isItLeftC)
            {
                parent.leftC = focusNode.rightC;
            }
            else
            {
                parent.rightC = focusNode.leftC;
            }
        }
        //If there are two children
        else
        {
            Node replace = getReplace(focusNode);
            
            //if the focusNode is root, then we need to replace root with the replacement that got send back
            if(focusNode == root)
            {
                root = replace;
            }
            else if(isItLeftC)
            {
                parent.leftC = replace;
            }
            else
            {
                parent.rightC = replace;
            }
            replace.leftC = focusNode.leftC;
        }       
        return true;
    }
    
    private Node getReplace(Node replacedNode) 
    {
        //We need to define our replacement parent and the replacement itself
        Node replaceParent = replacedNode;
        Node replacement = replacedNode;
        
        Node focusNode = replacedNode.rightC; //We are always replacing with the right child
        
        while(focusNode != null)
        {
            replaceParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftC;
        }
        
        /*if the replacement ISN'T the rightChild, we need to move the replacement 
        into the parents leftChild slot, and then move the replacedNode rightChild into the replacement rightChild*/
        if(replacement != replacedNode.rightC)
        {
            replaceParent.leftC = replacement.rightC;
            replacement.rightC = replacedNode.rightC;
        }
        
        return replacement;
    }
     
    public List<Integer> keys() 
    {
        List<Integer> list = new ArrayList<>();
        keys(list, root);
        return list;
    }
    
    public void keys(List<Integer> list, Node node){
        if (node == null) {
            System.out.println(list.toString());
            return;
        }
        keys(list, node.leftC);
        list.add(node.key);
        keys(list, node.rightC);
    }
    
    public int size(Node node) 
    {
        if (node == null) 
        {
            return 0;
        } 
        else 
        {
            return (size(node.leftC) + 1 + size(node.rightC));
        }
    }
}