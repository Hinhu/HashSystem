/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import hashsystem.RSApack.PublicKey;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maciek
 */
public class PublicKeyTest {
    
    public PublicKeyTest() {
    }

    @Test
    public void testGetN() {
        System.out.println("getN");
        PublicKey instance = new PublicKey(1000,1000);
        long expResult = 1000L;
        long result = instance.getN();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetE() {
        System.out.println("getE");
        PublicKey instance = new PublicKey(1000,1000);;
        long expResult = 1000L;
        long result = instance.getE();
        assertEquals(expResult, result);
    }
    
}
