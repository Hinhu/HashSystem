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
public class Sha256 {
    
    byte[] stringToBytes(String s){
        byte[] bytes = {1,2,3};
        return bytes;
    }
    
    byte[] intToBytes(String s){
        byte[] bytes = {1,2,3};
        return bytes;
    }
    
    byte[] doPadding(byte[] bytes){
        return bytes;
    }
    
    Chunk512[] breakToChunks(byte[] bytes){
        Chunk512[] chunks = new Chunk512[1000];
        return chunks;
    }    
    
    Word32[] convertToWords32(Chunk512[] chunks){
        Word32[] words = new Word32[1000];
        return words;
    }
    
    Word64[] expandToWords64(Word32[] words){
        Word64[] word64 = new Word64[1000];
        return word64;
    }
    
    public void calculate(HashRegister register, Word32[] words) {
        ;
    }
    
}
