/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
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
public class SHA_512Test {
    
    public SHA_512Test() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testNotNull() throws NoSuchAlgorithmException {
        SHA_512 instance = new SHA_512();
        assertNotNull(instance);
    }

    /**
     * Test of getDigest method, of class SHA_512.
     * @throws java.security.NoSuchAlgorithmException
     */
    @Test
    public void testGetDigest() throws NoSuchAlgorithmException {
        System.out.println("getDigest");
        String plain = "secret";
        SHA_512 instance = new SHA_512();
        byte[] result = instance.getDigest(plain);
        assertNotNull(result);   
    }

    /**
     * Test of getBigInteger method, of class SHA_512.
     * @throws java.security.NoSuchAlgorithmException
     */
    @Test
    public void testGetBigInteger() throws NoSuchAlgorithmException {
        System.out.println("getBigInteger");
        byte[] digest = "test".getBytes();
        SHA_512 instance = new SHA_512();
        BigInteger result = instance.getBigInteger(digest);
        assertThat(result, instanceOf(BigInteger.class));
    }

    /**
     * Test of generateSHA_512 method, of class SHA_512.
     * @throws java.security.NoSuchAlgorithmException
     */
    @Test
    public void testGenerateSHA_512() throws NoSuchAlgorithmException {
        System.out.println("generateSHA_512");
        String plain = "secret";
        SHA_512 instance = new SHA_512();
        String expResult = 
                "BD2B1AAF7EF4F09BE9F52CE2D8D599674D81AA9D6A4421696DC4D93DD061"
                + "9D682CE56B4D64A9EF097761CED99E0F67265B5F76085E5B0EE7CA4696"
                + "B2AD6FE2B2";
        String result = instance.generateSHA_512(plain);
        assertEquals(expResult, result);
    }
    
}
