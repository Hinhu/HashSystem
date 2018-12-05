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

    /**
     * Test of generateMD5 method, of class MD5.
     */
    @Test
    public void testNotNull() throws NoSuchAlgorithmException {
        MD5 instance = new MD5();
        assertNotNull(instance);
    }
    
    @Test
    public void testGenerateMD5() throws NoSuchAlgorithmException {
        String plain = "secret";
        MD5 instance = new MD5();
        String expResult = "5ebe2294ecd0e0f08eab7690d2a6ee69";
        String result = instance.generateMD5(plain);
        assertEquals(expResult, result);
    }
    
}
