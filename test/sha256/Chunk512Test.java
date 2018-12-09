/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import static org.junit.Assert.assertArrayEquals;
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

    @Test (expected = Exception.class)
    public void testSetChunkSizeTooBig() throws Exception  {
        byte[] bytesOfChunk = new byte[100];
        instance.setChunk(bytesOfChunk);      
    }
    
    @Test (expected = Exception.class)
    public void testSetChunkSizeTooSmall() throws Exception  {
        byte[] bytesOfChunk = new byte[10];
        instance.setChunk(bytesOfChunk);      
    }
    
    @Test 
    public void testSetGetChunkSizeOK() throws Exception  {
        byte[] bytesToSet = new byte[64];
        for(int i=0;i<64;i++){
            bytesToSet[i] = (byte)i;
        }
        instance.setChunk(bytesToSet); 
        byte[] bytesGet = instance.getChunk();
        assertArrayEquals(bytesToSet,bytesGet);
    }    
}