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
    private int word;   // Used to store 32 bit binary

    public Word32(int word) {
        this.word = word;        
    }
    
    public void setWord(int word) {
        this.word = word;
    }
    
    public int getWord(){
        return word;
    }
    
    public int getRightRotation (int offset) {
        return Integer.rotateRight(word, offset);    
    }
    
    public int getRightShift (int offset) {
        return (word >>> offset);    
    }
        
    @Override
    public String toString() {
        return "Chunk";
    }
}
