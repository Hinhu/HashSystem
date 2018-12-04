/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import hashsystem.RSApack.PrivateKey;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maciek
 */
public class PrivateKeyTest {
    
    public PrivateKeyTest() {
    }
    
    @Test
    public void testGetN() {
        System.out.println("getN");
        PrivateKey instance = new PrivateKey(1000,1000);
        long expResult = 1000L;
        long result = instance.getN();
        assertEquals(expResult, result);
    }

    public void testGetD() {
        System.out.println("getD");
        PrivateKey instance = new PrivateKey(1000,1000);
        long expResult = 1000L;
        long result = instance.getD();
        assertEquals(expResult, result);
    }
    
}
