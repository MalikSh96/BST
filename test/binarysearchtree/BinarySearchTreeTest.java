package binarysearchtree;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testPut() 
    {
        System.out.println("Test put");
        int key = 10;
        String name = "Test";
        
        BinarySearchTree bst = new BinarySearchTree();
        
        assertNull(bst.get(key));
        bst.put(key, name);
        assertEquals(name, bst.get(key));     
    }


    @Test
    public void testKeys() {
    }

    @Test
    public void testSize() {
    }    
}
