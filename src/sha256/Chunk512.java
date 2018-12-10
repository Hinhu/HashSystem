/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

/**
 *
 * @author zychp
 */
public class Chunk512 {
    private byte[] bytesOfChunk = new byte[64]; // 512 bits chunk 64*8bit byte

    public Chunk512() {
        for(int i=0; i<64;i++){
            bytesOfChunk[i]=0;
        }
    }

    public void setChunk(byte[] bytesOfChunk) throws Exception {
        if(bytesOfChunk.length != 64)
            throw new ArraySizeNotMatchException();
        this.bytesOfChunk = bytesOfChunk;
    }
    
    public byte[] getChunk(){
        return bytesOfChunk;
    }
}