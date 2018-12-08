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
public class HashRegister {
    private int[] words = new int[8]; //CHANGED FROM WORD 32

    
    public HashRegister(int[] input) {
        for(int i=0;i<8;i++){
            words[i] = input[i];
        }
    }
      
    
    public void initializeRegister(){
        
    }

    public void setValue(int id,int value) {
        words[id] = value;
    }
    
    public int[] getRegister(){
        return words;
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
    
}
