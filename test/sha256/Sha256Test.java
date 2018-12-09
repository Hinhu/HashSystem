/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author zychp
 */
public class Sha256Test {
    
    private Sha256 instance;
    
    @Before
    public void before(){
        instance = new Sha256();
    }

    
    public Sha256Test() {
    }
    
    @Test
    public void testHash() throws Exception {
        String input = "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, "
                + "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt,"
                + " explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur "
                + "magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia "
                + "dolor sit, amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt, ut labore et "
                + "dolore magnam aliquam quaerat voluptatem.";
        String expected = "381335cfd12b4f738714818bfe5c122eb1d1a3a5159c94c03eb049abe97d1c2f";
        String result = instance.getHash(input);
        assertEquals(expected, result);
    }

    @Test
    public void testPadding() {
        byte[] input = new byte[100];
        for(byte i=0;i<100;i++){
            input[i] = i;
        }
        byte[] expected = new byte[128];
        for(byte i=0;i<100;i++){
            expected[i] = i;
        }
        expected[100] = (byte)0x80;
        for(byte i=101;i<126;i++){
            expected[i] = 0x00;
        }
        expected[126] = (byte)0x03;
        expected[127] = (byte)0x20;
        
        assertArrayEquals(expected, instance.doPadding(input)); 
    }
    
    @Test
    public void testBytesToString() {
        byte[] input = new byte[10];
        for(byte i=0;i<10;i++){
            input[i] = (byte) (2*i);
        }  
        assertEquals("00020406080a0c0e1012", instance.bytesToString(input));
    }

    @Test
    public void testLongToBytes() {
        long input = 123456789123456789L;
        byte[] expected = {(byte) 0x01,(byte) 0xb6,(byte) 0x9b,(byte) 0x4b,(byte) 0xac,(byte) 0xd0,(byte) 0x5f,(byte) 0x15};
        assertArrayEquals(expected, instance.longToBytes(input));
    }

    @Test
    public void testIntToBytes() {
        int input = 123456789;
        byte[] expected = {0x07,(byte) 0x5b,(byte) 0xcd,(byte) 0x15};
        assertArrayEquals(expected, instance.intToBytes(input));
    }

    @Test
    public void testStringToBytes() {
        String input = "Sed ut p";
        byte[] expected = {(byte) 0x53,(byte) 0x65,(byte) 0x64,(byte) 0x20,(byte) 0x75,(byte) 0x74,(byte) 0x20,(byte) 0x70};
        assertArrayEquals(expected, instance.stringToBytes(input));
    }
}
