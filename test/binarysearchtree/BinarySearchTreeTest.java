package binarysearchtree;

import java.util.ArrayList;
import java.util.List;
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
    public void testRemove1()
    {
        System.out.println("reomve 1");
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10, "A");
        bst.put(15, "B");
        bst.put(20, "C");
        bst.put(5, "D");
        
        bst.removeNode(5);
        String res = bst.get(5);
        assertNull(res);
    }
    
    @Test
    public void testRemove2()
    {
        System.out.println("remove 2");
        
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10, "A");
        bst.put(15, "B");
        bst.put(20, "C");
        bst.put(1, "M");
        
        
        bst.removeNode(15);
        String res = bst.get(15);
        System.out.println("test ");
        System.out.println(bst.get(20));
        System.out.println(bst.size(bst.root));
        assertTrue(bst.size(bst.root) == 3);
        assertNull(res);
    }
    
    @Test
    public void testRemove3()
    {
        System.out.println("remove 3");
    }

    @Test
    public void testKeys() 
    {
        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> list = new ArrayList<>();
        
        bst.put(10, "A");
        bst.keys(list, bst.root);
        int result = list.size();
        int expResult = 1;
        assertEquals(expResult, result);
        
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
