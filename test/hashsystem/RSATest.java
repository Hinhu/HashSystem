/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

import hashsystem.RSApack.PublicKey;
import hashsystem.RSApack.Key;
import hashsystem.RSApack.NotAPrimeNubmerException;
import hashsystem.RSApack.PrivateKey;
import hashsystem.RSApack.RSA;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maciek
 */
public class RSATest {

    public RSATest() {
    }

    @Test
    public void testEncode() {
        System.out.println("encode");
        PublicKey key = new PublicKey(1083281, 207971);
        String text = "Lorem ipsum";
        String expResult = "248986 451946 29125 439126 694665 606461 954403 822455 193986 542454 694665 ";
        String result = RSA.encode(key, text);
        assertEquals(expResult, result);
    }

    @Test
    public void testDecode() {
        System.out.println("decode");
        PrivateKey key = new PrivateKey(1083281, 214331);
        String crytpogram = "248986 451946 29125 439126 694665 606461 954403 822455 193986 542454 694665 ";
        String expResult = "Lorem ipsum";
        String result = RSA.decode(key, crytpogram);
        assertEquals(expResult, result);
    }

    @Test
    public void testGenerateKeys() {
        System.out.println("generateKeys");
        long p = 10357L;
        long q = 10303L;
        long fi = (p - 1) * (q - 1);
        Key[] result = null;
        try {
            result = RSA.generateKeys(p, q);
        } catch (NotAPrimeNubmerException ex) {
            Logger.getLogger(RSATest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result==null){
            assertTrue(false);
        }
        PublicKey pub = (PublicKey) result[0];
        PrivateKey priv = (PrivateKey) result[1];
        assertTrue(gcd(pub.getE(), fi) == 1 && (priv.getD() * pub.getE()) % fi == 1);
    }
    
    @Test
    public void testGenerateKeysException1() {
        System.out.println("generateKeysException1");
        long p = 10352L;
        long q = 10303L;
        Key[] result = null;
        try {
            result = RSA.generateKeys(p, q);
        } catch (NotAPrimeNubmerException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testGenerateKeysException2() {
        System.out.println("generateKeysException2");
        long p = 10357L;
        long q = 10302L;
        Key[] result = null;
        try {
            result = RSA.generateKeys(p, q);
        } catch (NotAPrimeNubmerException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testGenerateKeysException3() {
        System.out.println("generateKeysException3");
        long p = 10352L;
        long q = 10302L;
        Key[] result = null;
        try {
            result = RSA.generateKeys(p, q);
        } catch (NotAPrimeNubmerException ex) {
            assertTrue(true);
        }
    }

    public long gcd(long a, long b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

}
