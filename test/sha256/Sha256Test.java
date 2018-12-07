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
public class Sha256Test {
    
    public Sha256Test() {
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
     * Test of stringToBytes method, of class Sha256.
     */
    @Test
    public void testStringToBytes() {
        System.out.println("stringToBytes");
        String s = "";
        Sha256 instance = new Sha256();
        byte[] expResult = null;
        byte[] result = instance.stringToBytes(s);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intToBytes method, of class Sha256.
     */
    @Test
    public void testIntToBytes() {
        System.out.println("intToBytes");
        String s = "";
        Sha256 instance = new Sha256();
        byte[] expResult = null;
        byte[] result = instance.intToBytes(s);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPadding method, of class Sha256.
     */
    @Test
    public void testDoPadding() {
        System.out.println("doPadding");
        byte[] bytes = null;
        Sha256 instance = new Sha256();
        byte[] expResult = null;
        byte[] result = instance.doPadding(bytes);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of breakToChunks method, of class Sha256.
     */
    @Test
    public void testBreakToChunks() {
        System.out.println("breakToChunks");
        byte[] bytes = null;
        Sha256 instance = new Sha256();
        Chunk512[] expResult = null;
        Chunk512[] result = instance.breakToChunks(bytes);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToWords32 method, of class Sha256.
     */
    @Test
    public void testConvertToWords32() {
        System.out.println("convertToWords32");
        Chunk512[] chunks = null;
        Sha256 instance = new Sha256();
        Word32[] expResult = null;
        Word32[] result = instance.convertToWords32(chunks);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of expandToWords64 method, of class Sha256.
     */
    @Test
    public void testExpandToWords64() {
        System.out.println("expandToWords64");
        Word32[] words = null;
        Sha256 instance = new Sha256();
        Word64[] expResult = null;
        Word64[] result = instance.expandToWords64(words);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
