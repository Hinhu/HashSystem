/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha256;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author zychp
 */
public class HashRegisterTest {
    
    private HashRegister instance;
    
    @Before
    public void before(){
        instance = new HashRegister();
    }
    
    public HashRegisterTest() {
    }
    
    @Test 
    public void testSetArraySizeTooBig() throws Exception  {
        int[] bytes = new int[9];
        try {
            instance.setValue(bytes);
        } catch (ArraySizeNotMatchException e) {
            assertTrue(true);
        }
        
    }
    
    @Test
    public void testSetArraySizeTooSmall() throws Exception  {
        int[] bytes = new int[7];
        try {
            instance.setValue(bytes);
        } catch (ArraySizeNotMatchException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testSetGetArraySizeOK() throws Exception  {
        int[] input = new int[8];
        for(int i=0;i<8;i++){
            input[i] = i;
        }
        instance.setValue(input); 
        assertArrayEquals(input, instance.getRegisterCopy());
    }


    @Test
    public void testRollWIthValues() throws Exception {
        int[] input = new int[8];
        for(int i=0;i<8;i++){
            input[i] = i;
        }
        int roll1 = 100;
        int roll2 = 200;
        instance.setValue(input);
        instance.rollWIthValues(roll1, roll2);
        
        int[] expected = new int[8];
        for(int i=1; i<8; i++){
            if(i==4) {
                expected[i] = i-1 + roll1;
                continue;
            }
            expected[i] = i-1;
        }
       expected[0] = (roll1 + roll2);
       
       assertArrayEquals(expected, instance.getRegisterCopy());
    }
    
}
