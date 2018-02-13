package binarysearchtree;

public class Node 
{
    private int key;
    private String name;
    private Node leftC;
    private Node rightC;

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
