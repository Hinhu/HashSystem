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
        Key[] result = RSA.generateKeys(p, q);
        PublicKey pub = (PublicKey) result[0];
        PrivateKey priv = (PrivateKey) result[1];
        assertTrue(gcd(pub.getE(), fi) == 1 && (priv.getD() * pub.getE()) % fi == 1);
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
