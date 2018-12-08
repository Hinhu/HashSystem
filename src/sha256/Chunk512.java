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
    private byte[] bytesOfChunk = new byte[64];

    public Chunk512() {      
    }

    public void setChunk(byte[] bytesOfChunk) {
        this.bytesOfChunk = bytesOfChunk;
    }
    
     
    public byte[] getChunk(){
        return bytesOfChunk;
    }

    @Override
    public String toString() {
        return "Chunk";
    }
}
