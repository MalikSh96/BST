package binarysearchtree;

public class Node 
{
    private int key;
    private String name;
    public Node leftC;
    public Node rightC;

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
