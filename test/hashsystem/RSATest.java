/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

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
        PublicKey key = null;
        String text = "";
        String expResult = "";
        String result = RSA.encode(key, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDecode() {
        System.out.println("decode");
        PrivateKey key = null;
        String crytpogram = "";
        String expResult = "";
        String result = RSA.decode(key, crytpogram);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGenerateKeys() {
        System.out.println("generateKeys");
        long p = 10357L;
        long q = 10303L;
        long fi = (p - 1) * (q - 1);
        Key[] result = RSA.generateKeys(p, q);
        PublicKey pub = (PublicKey) result[0];
        PrivateKey priv = (PrivateKey) result[1];
        assertTrue(gcd(pub.getE(), fi) == 1 && (priv.getD()*pub.getE())%fi==1);
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
