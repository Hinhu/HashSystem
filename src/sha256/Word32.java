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
public class Word32 {
    private int bytes;

    public Word32(int bytes) {
        this.bytes = bytes;        
    }
    
    public int getWord(){
        return bytes;
    }
    
    public int getRightRotation (int offset) {
        return Integer.rotateRight(bytes, offset);    
    }
    
    public int getRightShift (int offset) {
        return (bytes >>> offset);    
    }
        
    @Override
    public String toString() {
        return "Chunk";
    }
}
