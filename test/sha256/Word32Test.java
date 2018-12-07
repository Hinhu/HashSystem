/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zychp
 */
public class Word32Test {
    
    public Word32Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getWord method, of class Word32.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        Word32 instance = null;
        int expResult = 0;
        int result = instance.getWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRightRotation method, of class Word32.
     */
    @Test
    public void testGetRightRotation() {
        System.out.println("getRightRotation");
        int offset = 0;
        Word32 instance = null;
        int expResult = 0;
        int result = instance.getRightRotation(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRightShift method, of class Word32.
     */
    @Test
    public void testGetRightShift() {
        System.out.println("getRightShift");
        int offset = 0;
        Word32 instance = null;
        int expResult = 0;
        int result = instance.getRightShift(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Word32.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Word32 instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
