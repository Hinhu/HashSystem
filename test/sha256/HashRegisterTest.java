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
public class HashRegisterTest {
    
    public HashRegisterTest() {
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
     * Test of initializeRegister method, of class HashRegister.
     */
    @Test
    public void testInitializeRegister() {
        System.out.println("initializeRegister");
        HashRegister instance = new HashRegister();
        instance.initializeRegister();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegister method, of class HashRegister.
     */
    @Test
    public void testGetRegister() {
        System.out.println("getRegister");
        HashRegister instance = new HashRegister();
        Word32[] expResult = null;
        Word32[] result = instance.getRegister();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class HashRegister.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int id = 0;
        HashRegister instance = new HashRegister();
        Word32 expResult = null;
        Word32 result = instance.getValue(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rollWIthValues method, of class HashRegister.
     */
    @Test
    public void testRollWIthValues() {
        System.out.println("rollWIthValues");
        int val1 = 0;
        int val2 = 0;
        HashRegister instance = new HashRegister();
        instance.rollWIthValues(val1, val2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
