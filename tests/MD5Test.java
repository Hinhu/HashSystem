/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.NoSuchAlgorithmException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MD5Test {
    
    public MD5Test() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNotNull() throws NoSuchAlgorithmException {
        MD5 instance = new MD5();
        assertNotNull(instance);
    }
    
        /**
     * Test of generateMD5 method, of class MD5.
     * @throws java.security.NoSuchAlgorithmException
     */
    @Test
    public void testGenerateMD5() throws NoSuchAlgorithmException {
        String plain = "secret";
        MD5 instance = new MD5();
        String expResult = "5EBE2294ECD0E0F08EAB7690D2A6EE69";
        String result = instance.generateMD5(plain);
        assertEquals(expResult, result);
    }
    
}
