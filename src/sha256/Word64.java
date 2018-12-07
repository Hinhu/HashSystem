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
public class Word64 {
    private byte[] bytesOfWord = new byte[8];

    public Word64(byte[] bytes) {
        bytesOfWord = bytes;        
    }
    
    public byte[] getWord(){
        return bytesOfWord;
    }

    @Override
    public String toString() {
        return "Chunk";
    }
}
