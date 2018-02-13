package binarysearchtree;

public class Node 
{
    int key;
    String name;
    Node leftC;
    Node rightC;

    public Node(int key, String name) 
    {
        this.key = key;
        this.name = name;
    }
    
    public String toString()
    {
        return name + " has key " + key;
    }
}
