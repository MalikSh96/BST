package binarysearchtree;
//
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    Node root;
    
    @Before
    public void setUp() throws Exception {
    }


//    @Test
//    public void testPut() 
//    {
//        System.out.println("Test put");
//        int key = 10;
//        String name = "Test";
//        
//        BinarySearchTree bst = new BinarySearchTree();
//        
//        assertNull(bst.get(key));
//        bst.put(key, name);
//        assertEquals(name, bst.get(key));     
//    }

    @Test
    public void testPut2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(0, "john");
        String expResult = "john has key 0";
        Node result = bst.get(0,bst.root);
        assertEquals(expResult, result.toString());
        
    }
    @Test
    public void testKeys() {
    }

    @Test
    public void testSize() 
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(0, "flaske");
        bst.put(4, "glas");
        int expResult = 2;
        int result = bst.size(bst.root);
        assertEquals(expResult,result);
    }    
}
