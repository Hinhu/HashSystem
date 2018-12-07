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
    private Word32[] bytes;

    public HashRegister() {
    }
    
    public void initializeRegister(){
        
    }
    
    public Word32[] getRegister(){
        return bytes;
    }
    
    public Word32 getValue(int id){
        return bytes[id];
    }
    
    public void rollWIthValues(int val1, int val2){
        ;
    }  
    
}
