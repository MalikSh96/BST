package binarysearchtree;

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


    @Test
    public void testPut() {
    }


    @Test
    public void testKeys() {
    }

    @Test
    public void testSize() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(0, "flaske");
        bst.put(4, "glas");
        int expResult = 2;
        int result = bst.size(bst.root);
        assertEquals(expResult,result);
    }    
}
