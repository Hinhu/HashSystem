/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import java.util.Arrays;

/**
 *
 * @author zychp
 */
public class HashRegister {
    private int[] words = new int[8]; // HashRegister 8 words x 

    
    public HashRegister() {
        for (int i=0; i<8; i++){
            words[i] = 0;
        }        
    }
     
    public void setValue(int id,int value) {
        words[id] = value;
    }
    
    public void setValue(int[] input) {
        System.arraycopy(input, 0, words, 0, 8);
    }
    
    public int[] getRegisterCopy(){
        return Arrays.copyOf(words, 8);
    }
    
    public int getValue(int id){
        return words[id];
    }
    
    public void rollWIthValues(int val1, int val2){
        for(int i=7; i>0; i--){
            if(i==4) {
                words[i] = words[i-1] + val1;
                continue;
            }
            words[i] = words[i-1];
        }
        words[0] = (val1 + val2);
    }  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashRegister");
        return "HashRegister{" + "words=" + words + '}';
    }
    
}
