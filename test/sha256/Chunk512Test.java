/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author zychp
 */
public class Chunk512Test {
    
    private Chunk512 instance;
    
    @Before
    public void before(){
        instance = new Chunk512();
    }
    
    public Chunk512Test() {
    }

    @Test
    public void testSetChunkSizeTooBig() throws Exception  {
        byte[] input = new byte[100];
        try {
            instance.setChunk(input);      
        } catch (ArraySizeNotMatchException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testSetChunkSizeTooSmall() throws Exception  {
        byte[] input = new byte[10];
        try {
            instance.setChunk(input);      
        } catch (ArraySizeNotMatchException e) {
            assertTrue(true);
        }
    }
    
    @Test 
    public void testSetGetChunkSizeOK() throws Exception  {
        byte[] input = new byte[64];
        for(int i=0;i<64;i++){
            input[i] = (byte)i;
        }
        instance.setChunk(input); 
        assertArrayEquals(input,instance.getChunk());
    }    

}